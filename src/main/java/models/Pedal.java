package models;

import java.util.ArrayList;
import java.util.Objects;

public class Pedal {
    private String type;
    private String manufacturer;
    private String model;
    private String imageUrl;
    private String notes;
    private int id;

    public Pedal() {
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedal pedal = (Pedal) o;
        return id == pedal.id &&
                Objects.equals(type, pedal.type) &&
                Objects.equals(manufacturer, pedal.manufacturer) &&
                Objects.equals(model, pedal.model) &&
                Objects.equals(imageUrl, pedal.imageUrl) &&
                Objects.equals(notes, pedal.notes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, manufacturer, model, imageUrl, notes, id);
    }
}

