import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Guitar;
import models.Amp;
import models.Pedal;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/guitars/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "guitar-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/amps/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "amp-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/pedals/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "pedal-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/guitars/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String type = request.queryParams("type");
            String manufacturer = request.queryParams("manufacturer");
            String newModel = request.queryParams("model");
            int year = Integer.parseInt(request.queryParams("year"));
            String imageUrl = request.queryParams("imageUrl");
            String color = request.queryParams("color");
            String finish = request.queryParams("finish");
            String notes = request.queryParams("notes");
            Guitar newGuitar = new Guitar();
            newGuitar.setType(type);
            newGuitar.setManufacturer(manufacturer);
            newGuitar.setModel(newModel);
            newGuitar.setYear(year);
            newGuitar.setImageUrl(imageUrl);
            newGuitar.setColor(color);
            newGuitar.setFinish(finish);
            newGuitar.setNotes(notes);
            model.put("guitars", newGuitar);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/amps/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String type = request.queryParams("type");
            String manufacturer = request.queryParams("manufacturer");
            String newModel = request.queryParams("model");
            int year = Integer.parseInt(request.queryParams("year"));
            String power = request.queryParams("power");
            String imageUrl = request.queryParams("imageUrl");
            String grillCloth = request.queryParams("grillCloth");
            String finish = request.queryParams("finish");
            String notes = request.queryParams("notes");
            Amp newAmp = new Amp();
            newAmp.setType(type);
            newAmp.setManufacturer(manufacturer);
            newAmp.setModel(newModel);
            newAmp.setYear(year);
            newAmp.setPower(power);
            newAmp.setImageUrl(imageUrl);
            newAmp.setGrillCloth(grillCloth);
            newAmp.setFinish(finish);
            newAmp.setNotes(notes);
            model.put("amps", newAmp);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/pedals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String type = request.queryParams("type");
            String manufacturer = request.queryParams("manufacturer");
            String newModel = request.queryParams("model");
            String imageUrl = request.queryParams("imageUrl");
            String notes = request.queryParams("notes");
            Pedal newPedal = new Pedal();
            newPedal.setType(type);
            newPedal.setManufacturer(manufacturer);
            newPedal.setModel(newModel);
            newPedal.setImageUrl(imageUrl);
            newPedal.setNotes(notes);
            model.put("pedals", newPedal);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/guitars", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Guitar> guitars = Guitar.getGuitarList();
            model.put("guitars", guitars);
            return new ModelAndView(model, "guitars.hbs");
        }, new HandlebarsTemplateEngine());

        get("/amps", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Amp> amps = Amp.getAmpList();
            model.put("amps", amps);
            return new ModelAndView(model, "amps.hbs");
        }, new HandlebarsTemplateEngine());

        get("/pedals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Pedal> pedals = Pedal.getPedalList();
            model.put("pedals", pedals);
            return new ModelAndView(model, "pedals.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
