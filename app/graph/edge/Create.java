package graph.edge;

import com.thinkaurelius.titan.core.Multiplicity;
import com.thinkaurelius.titan.core.schema.TitanManagement;
import services.GraphService;

/**
 * Create by diendvz on 7/5/16.
 */
public class Create {

    private static final String TIME_CREATE = "Time_Create";

    public static void init() {
        TitanManagement tm = GraphService.getGraph().openManagement();
        tm.makeEdgeLabel(GraphService.LABEL_EDGE_CREATE).multiplicity(Multiplicity.MULTI).make();
        tm.makePropertyKey(TIME_CREATE).dataType(Long.class).make();
        tm.commit();
    }
}
