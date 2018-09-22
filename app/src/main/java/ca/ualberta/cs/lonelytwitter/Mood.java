package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {
    private Date date;
    private String mood_face;

    Mood() {
        this.date = new Date();
        this.mood_face = "";
    }

    Mood(Date date) {
        this.date = date;
        this.mood_face = mood_face;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMoodFace() {
        return this.mood_face;
    }
}
