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
            Guitar recentGuitar = Guitar.recentGuitar();
            model.put("recentGuitar", recentGuitar);
            Amp recentAmp = Amp.recentAmp();
            model.put("recentAmp", recentAmp);
            Pedal recentPedal = Pedal.recentPedal();
            model.put("recentPedal", recentPedal);
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

        get("/guitars/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfGuitarToFind = Integer.parseInt(req.params("id"));
            Guitar foundGuitar = Guitar.findById(idOfGuitarToFind);
            model.put("guitar", foundGuitar);
            return new ModelAndView(model, "guitar-details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/amps/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfAmpToFind = Integer.parseInt(req.params("id"));
            Amp foundAmp = Amp.findById(idOfAmpToFind);
            model.put("amp", foundAmp);
            return new ModelAndView(model, "amp-details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/pedals/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPedalToFind = Integer.parseInt(req.params("id"));
            Pedal foundPedal = Pedal.findById(idOfPedalToFind);
            model.put("pedal", foundPedal);
            return new ModelAndView(model, "pedal-details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/guitars/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfGuitarToEdit = Integer.parseInt(req.params("id"));
            Guitar editGuitar = Guitar.findById(idOfGuitarToEdit);
            model.put("editGuitar", editGuitar);
            return new ModelAndView(model, "guitar-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/amps/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfAmpToEdit = Integer.parseInt(req.params("id"));
            Amp editAmp = Amp.findById(idOfAmpToEdit);
            model.put("editAmp", editAmp);
            return new ModelAndView(model, "amp-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/pedals/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPedalToEdit = Integer.parseInt(req.params("id"));
            Pedal editPedal = Pedal.findById(idOfPedalToEdit);
            model.put("editPedal", editPedal);
            return new ModelAndView(model, "pedal-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/guitars/:id/update", (request, res) -> {
            Map<String, Object> model = new HashMap<>();
            String type = request.queryParams("type");
            String manufacturer = request.queryParams("manufacturer");
            String newModel = request.queryParams("model");
            int year = Integer.parseInt(request.queryParams("year"));
            String imageUrl = request.queryParams("imageUrl");
            String color = request.queryParams("color");
            String finish = request.queryParams("finish");
            String notes = request.queryParams("notes");
            int idOfGuitarToEdit = Integer.parseInt(request.params("id"));
            Guitar editGuitar = Guitar.findById(idOfGuitarToEdit);
            editGuitar.update(type, manufacturer, newModel, year, imageUrl, color, finish, notes);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/amps/:id/update", (request, res) -> {
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
            int idOfAmpToEdit = Integer.parseInt(request.params("id"));
            Amp editAmp = Amp.findById(idOfAmpToEdit);
            editAmp.update(type, manufacturer, newModel, year, power, imageUrl, finish, grillCloth, notes);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/pedals/:id/update", (request, res) -> {
            Map<String, Object> model = new HashMap<>();
            String type = request.queryParams("type");
            String manufacturer = request.queryParams("manufacturer");
            String newModel = request.queryParams("model");
            String imageUrl = request.queryParams("imageUrl");
            String notes = request.queryParams("notes");
            int idOfPedalToEdit = Integer.parseInt(request.params("id"));
            Pedal editPedal = Pedal.findById(idOfPedalToEdit);
            editPedal.update(type,manufacturer, newModel, imageUrl, notes);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/guitars/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfGuitarToDelete = Integer.parseInt(req.params("id"));
            Guitar deleteGuitar = Guitar.findById(idOfGuitarToDelete);
            deleteGuitar.deleteGuitar();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/amps/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfAmpToDelete = Integer.parseInt(req.params("id"));
            Amp deleteAmp = Amp.findById(idOfAmpToDelete);
            deleteAmp.deleteAmp();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/pedals/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPedalToDelete = Integer.parseInt(req.params("id"));
            Pedal deletePedal = Pedal.findById(idOfPedalToDelete);
            deletePedal.deletePedal();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
