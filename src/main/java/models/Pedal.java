package models;

import java.util.ArrayList;

public class Pedal {
    private String type;
    private String manufacturer;
    private String model;
    private String imageUrl;
    private String notes;
    private int id;
    private static ArrayList<Pedal> pedalList = new ArrayList<>();

    public Pedal() {
        pedalList.add(this);
        this.id = pedalList.size();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public static ArrayList<Pedal> getPedalList() {
        return pedalList;
    }

    public static Pedal findById(int id){
        return pedalList.get(id-1);
    }

    public void update(String type, String manufacturer, String model, String imageUrl, String notes){
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.imageUrl = imageUrl;
        this.notes = notes;
    }

    public void deletePedal() {
        pedalList.remove(id-1);
    }
}
