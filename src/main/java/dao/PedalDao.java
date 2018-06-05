package dao;

import models.Note;
import models.Pedal;

import java.util.List;

public interface PedalDao {
    // LIST
    List<Pedal> getAll();

    // CREATE
    void add(Pedal pedal);

    // READ
    Pedal findById(int id);

    // UPDATE
    void update( int id, String type, String manufacturer, String model, String imageUrl, String notes);

    // DELETE
    void deleteById(int id);

    List<Note> getAllNotesByPedalId(int pedalId);
}
