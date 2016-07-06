import play.Application;
import play.GlobalSettings;
import services.GraphService;

/**
 * Create by diendvz on 7/5/16.
 */
public class Global extends GlobalSettings {
    public void onStart(Application app){
        GraphService.initGraph();
        super.onStart(app);
    }

    public void onStop(Application app){
        super.onStop(app);
    }
}
