package controller;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

import static model.Notes.*;

/**
 * Created by prestonbattin on 3/23/17.
 */
@SuppressWarnings("Duplicates")
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
      double count = 0;

      if(this.getNotes().length > sungNotesArray.length){

          for(int i = 0; i < sungNotesArray.length; i++){

              if(accuracyDetector(this.getNotes()[i].substring(0,2))) {
                  if (this.getNotes()[i].substring(0, 2).equals(sungNotesArray[i].substring(0, 2)))
                      count++;
              }

              else
                  if(this.getNotes()[i].substring(0,1).equals(sungNotesArray[i].substring(0,1)))
                      count++;
          }
      }
      else
          for(int i = 0; i < this.getNotes().length; i++){

              if(accuracyDetector(this.getNotes()[i].substring(0,2))) {
                  if (this.getNotes()[i].substring(0, 2).equals(sungNotesArray[i].substring(0, 2)))
                      count++;
              }

                  else {
                  if (this.getNotes()[i].substring(0, 1).equals(sungNotesArray[i].substring(0, 1))) {
                      count++;
                  }
              }


          }

          double percentage = ((count / getNotes().length) * 100);
          return Math.ceil(percentage);
    }

    public boolean accuracyDetector(String notes){

        if(notes.equals(B_FLAT.toString()) || notes.equals(C_SHARP.toString()) || notes.equals(D_SHARP.toString()) ||
                notes.equals(F_SHARP.toString()) || notes.equals(G_SHARP.toString())){
            return true;
        }
        return false;

    }
}
