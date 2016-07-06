package graph.vertex;

import com.thinkaurelius.titan.core.PropertyKey;
import com.thinkaurelius.titan.core.schema.TitanManagement;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import services.GraphService;

/**
 * Create by diendvz on 7/5/16.
 */
public class Customer {
    private static final String NAME = "name";
    private static final String SEARCH = "cussearch";

    public static void init() {
        TitanManagement tm = GraphService.getGraph().openManagement();
        tm.makeVertexLabel(GraphService.LABEL_VERTEX_CUSTOMER).make();
        PropertyKey name = tm.makePropertyKey(NAME).dataType(String.class).make();
        tm.buildIndex(SEARCH, Vertex.class).addKey(name).buildCompositeIndex();
    }
}
