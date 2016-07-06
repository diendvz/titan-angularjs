package services;

import com.thinkaurelius.titan.core.TitanFactory;
import com.thinkaurelius.titan.core.TitanGraph;
import com.thinkaurelius.titan.core.schema.TitanManagement;
import com.thinkaurelius.titan.graphdb.database.management.ManagementSystem;
import graph.edge.Buy;
import graph.edge.Create;
import graph.edge.Partner;
import graph.edge.Teammate;
import graph.vertex.Coder;
import graph.vertex.Customer;
import graph.vertex.Software;
import play.Logger;
import play.Play;

/**
 * Create by diendvz on 7/5/16.
 */
public class GraphService {
    private static TitanGraph graph;

    public static final String LABEL_VERTEX_CODER = "coder";
    public static final String LABEL_VERTEX_CUSTOMER = "customer";
    public static final String LABEL_VERTEX_SOFTWARE = "software";

    public static final String LABEL_EDGE_BUY = "buy";
    public static final String LABEL_EDGE_CREATE = "create";
    public static final String LABEL_EDGE_PARTNER = "partner";
    public static final String LABEL_EDGE_TEAMMATE = "teammate";

    public static final String SEARCH_ENGINE = "search";

    public static void initGraph() {
        graph = TitanFactory.open(Play.application().configuration().getString("TitanConf"));
        TitanManagement tm = graph.openManagement();
        try {
            if (tm.containsVertexLabel(LABEL_VERTEX_CODER)) {
                Coder.init();
            }
            if (tm.containsVertexLabel(LABEL_VERTEX_CUSTOMER)) {
                Customer.init();
            }
            if (tm.containsVertexLabel(LABEL_VERTEX_SOFTWARE)) {
                Software.init();
            }
            if (tm.containsEdgeLabel(LABEL_EDGE_BUY)) {
                Buy.init();
            }
            if (tm.containsEdgeLabel(LABEL_EDGE_CREATE)) {
                Create.init();
            }
            if (tm.containsEdgeLabel(LABEL_EDGE_PARTNER)) {
                Partner.init();
            }
            if (tm.containsEdgeLabel(LABEL_EDGE_TEAMMATE)) {
                Teammate.init();
            }
        } catch (Exception e) {
            Logger.error(e.getMessage());
            graph.tx().rollback();
        }
    }

    public static TitanGraph getGraph() {
        return graph;
    }

    public static void stopGraph() {
        if (graph.isOpen()) {
            graph.close();
        }
    }
}
