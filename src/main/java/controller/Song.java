package controller;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

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

    @NotNull
    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

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

    public double compareNotes(ArrayList<String> sungNotes){
      String[]  sungNotesArray = new String[sungNotes.size()];
      sungNotesArray = sungNotes.toArray(sungNotesArray);
      int count = 0;

      if(this.getNotes().length > sungNotesArray.length){
          for(int i = 0; i < sungNotesArray.length; i++){
              if(this.getNotes()[i] == sungNotesArray[i])
                  count++;
          }
      }
      else
          for(int i = 0; i < this.getNotes().length; i++){
          if(this.getNotes()[i] == sungNotesArray[i])
              count++;
          }
          return (count / this.getNotes().length) * 100;
    }
}
