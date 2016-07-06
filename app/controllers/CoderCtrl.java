package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import graph.vertex.Coder;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by diendvz on 7/6/16.
 */
public class CoderCtrl extends Controller{
    public Result searchCoderByName(String name) {
        Logger.error(name);
        return ok(Json.toJson(Coder.getCoderByName(name)));
    }

    public Result listCoder(){
        return ok(Json.toJson(Coder.listCoder()));
    }

    public Result addCoder(){
        JsonNode data = request().body().asJson();
        return ok(Coder.addCoder(data.get("name").asText(),data.get("age").asInt()) + "");
    }
}
