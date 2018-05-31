package models;

import java.time.LocalDateTime;

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
}
