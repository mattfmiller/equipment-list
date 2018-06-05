package dao;

import models.Guitar;
import models.Note;

import java.util.List;

public interface GuitarDao {
    // LIST
    List<Guitar> getAll();

    // CREATE
    void add(Guitar guitar);

    // READ
    Guitar findById(int id);

    // UPDATE
    void update( int id, String type, String manufacturer, String model, int year, String imageUrl, String color, String finish);

    // DELETE
    void deleteById(int id);

    List<Note> getAllNotesByGuitarId(int guitarId);

}
