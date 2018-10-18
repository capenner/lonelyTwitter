/**
 * Mood object class, not used in app so don't worry about it.
 * @author Christopher Penner
 * @param date  holds the current date
 * @param mood_face string that has the face of the mood
 * @see ca.ualberta.cs.lonelytwitter.Happy
 * @see ca.ualberta.cs.lonelytwitter.Depressed
 */

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
