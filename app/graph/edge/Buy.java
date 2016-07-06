package graph.edge;

import com.thinkaurelius.titan.core.Multiplicity;
import com.thinkaurelius.titan.core.schema.TitanManagement;
import services.GraphService;

/**
 * Create by diendvz on 7/5/16.
 */
public class Buy {

    public static void init() {
        TitanManagement tm = GraphService.getGraph().openManagement();
        tm.makeEdgeLabel(GraphService.LABEL_EDGE_BUY).multiplicity(Multiplicity.MULTI).make();
        tm.commit();
    }
}
