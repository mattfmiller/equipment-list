package models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Note {
    private String comment;
    private LocalDateTime timeStamp;

    public Note(String comment) {
        this.comment = comment;
        this.timeStamp = LocalDateTime.now();
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(comment, note.comment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(comment);
    }
}
