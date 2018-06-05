package models;

import java.util.ArrayList;
import java.util.Objects;

public class Amp {
    private String type;
    private String manufacturer;
    private String model;
    private int year;
    private String power;
    private String imageUrl;
    private String finish;
    private String grillCloth;
    private int id;

    public Amp() {
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
        Amp amp = (Amp) o;
        return year == amp.year &&
                id == amp.id &&
                Objects.equals(type, amp.type) &&
                Objects.equals(manufacturer, amp.manufacturer) &&
                Objects.equals(model, amp.model) &&
                Objects.equals(power, amp.power) &&
                Objects.equals(imageUrl, amp.imageUrl) &&
                Objects.equals(finish, amp.finish) &&
                Objects.equals(grillCloth, amp.grillCloth);
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, manufacturer, model, year, power, imageUrl, finish, grillCloth,  id);
    }
}