package graph.edge;

import com.thinkaurelius.titan.core.Multiplicity;
import com.thinkaurelius.titan.core.schema.TitanManagement;
import services.GraphService;

/**
 * Create by diendvz on 7/5/16.
 */
public class Partner {
    private static final String PROJECT = "project";

    public static void init() {
        TitanManagement tm = GraphService.getGraph().openManagement();
        tm.makePropertyKey(PROJECT).dataType(String.class).make();
        tm.makeEdgeLabel(GraphService.LABEL_EDGE_PARTNER).multiplicity(Multiplicity.MULTI).make();
        tm.commit();
    }
}
