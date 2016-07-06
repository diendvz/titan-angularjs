package graph.vertex;

import com.thinkaurelius.titan.core.PropertyKey;
import com.thinkaurelius.titan.core.TitanGraph;
import com.thinkaurelius.titan.core.TitanVertex;
import com.thinkaurelius.titan.core.attribute.Text;
import com.thinkaurelius.titan.core.schema.TitanManagement;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.json.simple.JSONObject;
import play.Logger;
import services.GraphService;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by diendvz on 7/5/16.
 */
public class Coder {

    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String SEARCH = "codersearch";

    public static void init() {
        TitanManagement tm = GraphService.getGraph().openManagement();
        tm.makeVertexLabel(GraphService.LABEL_VERTEX_CODER).make();
        PropertyKey name = tm.makePropertyKey(NAME).dataType(String.class).make();
        PropertyKey age = tm.makePropertyKey(NAME).dataType(String.class).make();
        tm.makePropertyKey(AGE).dataType(Integer.class).make();
        tm.buildIndex(SEARCH, Vertex.class).addKey(name).addKey(age).buildMixedIndex("search");
    }

    public static long addCoder(String name, int age) {
        TitanGraph g = GraphService.getGraph();
        try {
            TitanVertex v = g.addVertex(GraphService.LABEL_VERTEX_CODER);
            v.property(NAME, name);
            v.property(AGE, age);
            g.tx().commit();
            return v.longId();
        } catch (Exception e) {
            Logger.error(e.getMessage());
            g.tx().rollback();
            return -1;
        }
    }

    public static JSONObject findCoderById(long id){
        TitanGraph g = GraphService.getGraph();
//        Vertex coder = g.vertices(id).next();
        Vertex coder = g.traversal().V().hasId(id).next();
        if(coder == null){
            return null;
        }else {
            return getCoder(coder);
        }
    }

    public static List<JSONObject> listCoder(){
        List<JSONObject> coders = new ArrayList<>();
        TitanGraph g = GraphService.getGraph();
        g.traversal().V().hasLabel(GraphService.LABEL_VERTEX_CODER).forEachRemaining(coder->{
            coders.add(getCoder(coder));
        });
        return coders;
    }

    private static JSONObject getCoder(Vertex coder) {
        JSONObject node = new JSONObject();
        node.put(NAME,coder.value(NAME));
        node.put(AGE,coder.value(AGE));
        return node;
    }

    public static List<JSONObject> getCoderByName(String name){
        List<JSONObject> coders = new ArrayList<>();
        TitanGraph g = GraphService.getGraph();
        g.query().has(NAME, Text.CONTAINS,name).vertices().forEach(coder->{
            coders.add(getCoder(coder));
        });
        return coders;
    }
}
