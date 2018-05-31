package models;

import java.util.ArrayList;

public class Amp {
    private String type;
    private String manufacturer;
    private String model;
    private int year;
    private String power;
    private String imageUrl;
    private String finish;
    private String grillCloth;
    private String notes;
    private int id;
    private static ArrayList<Amp> ampList = new ArrayList<>();

    public Amp() {
        ampList.add(this);
        this.id = ampList.size();
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getGrillCloth() {
        return grillCloth;
    }

    public void setGrillCloth(String grillCloth) {
        this.grillCloth = grillCloth;
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

    public static ArrayList<Amp> getAmpList() {
        return ampList;
    }

    public static Amp findById(int id){
        return ampList.get(id-1);
    }

    public void update(String type, String manufacturer, String model, int year, String power, String imageUrl, String finish, String grillCloth, String notes){
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.power = power;
        this.imageUrl = imageUrl;
        this.grillCloth = grillCloth;
        this.finish = finish;
        this.notes = notes;
    }

    public void deleteAmp() {
        ampList.remove(id-1);
    }
}