package models;

import java.util.ArrayList;
import java.util.Objects;

public class Guitar {
    private String type;
    private String manufacturer;
    private String model;
    private int year;
    private String imageUrl;
    private String color;
    private String finish;
    private int id;

    public Guitar() {

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
        Guitar guitar = (Guitar) o;
        return year == guitar.year &&
                id == guitar.id &&
                Objects.equals(type, guitar.type) &&
                Objects.equals(manufacturer, guitar.manufacturer) &&
                Objects.equals(model, guitar.model) &&
                Objects.equals(imageUrl, guitar.imageUrl) &&
                Objects.equals(color, guitar.color) &&
                Objects.equals(finish, guitar.finish);
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, manufacturer, model, year, imageUrl, color, finish, id);
    }
}
