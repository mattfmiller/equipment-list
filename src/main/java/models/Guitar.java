package models;

import java.util.ArrayList;

public class Guitar {
    private String type;
    private String manufacturer;
    private String model;
    private int year;
    private String imageUrl;
    private String color;
    private String finish;
//    private String notes;
    private int id;
    private static ArrayList<Guitar> guitarList = new ArrayList<>();
    private ArrayList<Note> noteList = new ArrayList<>();

    public Guitar() {
        guitarList.add(this);
        this.id = guitarList.size();
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

//    public String getNotes() {
//        return notes;
//    }
//
//    public void setNotes(String notes) {
//        this.notes = notes;
//    }

    public int getId() {
        return id;
    }

    public static ArrayList<Guitar> getGuitarList() {
        return guitarList;
    }

    public static Guitar findById(int id){
        return guitarList.get(id-1);
    }

    public void update(String type, String manufacturer, String model, int year, String imageUrl, String color, String finish){
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.imageUrl = imageUrl;
        this.color = color;
        this.finish = finish;
//        this.notes = notes;
    }

    public void deleteGuitar() {
        guitarList.remove(id-1);
    }

    public static Guitar recentGuitar() {
        if (guitarList.size() == 0){
            return null;
        } else {
            return guitarList.get(guitarList.size() - 1);
        }
    }

    public void addNote(Note addedNote) {
        noteList.add(addedNote);
    }

    public ArrayList<Note> getNoteList() {
        return noteList;
    }
}
