package controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by prestonbattin on 3/28/17.
 */
public class SongTest {

    Song song;
    @Before
    public void setUp(){
        song = new Song();
    }

    @Test
    public void accuracyDetector(){
        String Bflat = "Bb";
        boolean expected = true;
        boolean actual = song.accuracyDetector(Bflat);
        Assert.assertEquals("Testing that this prints true", expected, actual );

        String A = "A";
        expected = false;
        actual = song.accuracyDetector(A);
        Assert.assertEquals("Testing that this returns false", expected, actual);
    }

    @Test
    public void compareNotesTest(){

        String[] notes = {"A", "Bb", "C#"};
        ArrayList<String> testNotes = new ArrayList<>();
        testNotes.add("A");
        testNotes.add("Bb");
        testNotes.add("C#");
        song.setNotes(notes);

        double expected = 100;
        double actual = song.compareNotes(testNotes);
        Assert.assertEquals("Testing that the notes are equal", expected, actual, 0);




    }
}