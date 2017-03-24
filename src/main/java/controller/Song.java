package controller;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by prestonbattin on 3/23/17.
 */
@Entity
@Table(name = "Songs")
public class Song {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String[] Notes;

    @NotNull
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getNotes() {
        return Notes;
    }

    public void setNotes(String[] notes) {
        Notes = notes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
