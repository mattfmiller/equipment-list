package dao;

import models.Amp;
import models.Note;

import java.util.List;

public interface AmpDao {

    // LIST
    List<Amp> getAll();

    // CREATE
    void add(Amp amp);

    // READ
    Amp findById(int id);

    // UPDATE
    void update(int id, String type, String manufacturer, String model, int year, String power, String imageUrl, String finish, String grillCloth);

    // DELETE
    void deleteById(int id);

    List<Note> getAllNotesByAmpId(int ampId);
}
