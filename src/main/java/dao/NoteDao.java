package dao;

import models.Note;

import java.util.List;

public interface NoteDao {

    // LIST
    List<Note> getAll();

    // CREATE
    void add(Note note);

    // READ
    Note findByGuitarId(int guitarId);
    Note findByAmpId(int ampId);
    Note findByPedalId(int pedalId);

    // UPDATE
    void update( int id, String type, String manufacturer, String model, String imageUrl, String notes);

    // DELETE
    void deleteById(int id);

    List<Note> getAllNotesByPedal(int guitarId);

}
