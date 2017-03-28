package controller;

import model.ConvertAudioToNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prestonbattin on 3/23/17.
 */
@RestController
@CrossOrigin
public class SongController {

    @RequestMapping(value = "/getSongs",method = RequestMethod.GET , produces = {"application/json"})
    @ResponseBody List songs(){

           List songs = new ArrayList();
           for(Song s: songDOA.findAll()){
             songs.add(s.getTitle());
           }
        return songs;
    }

    @RequestMapping(value = "/addDio", method = RequestMethod.PUT)
    void addSongDio(){
        String[] notes = {"none, none, C2, B2, F1, F#1, G0, G0, G0, C3, none, F#1, F#2, E2, C#2, C#3, E3, D#3, G#1, D#2," +
                " none, none, none, none, none, none, A0, A0, C#0, C0, F0, F#0, C#3, B2, D2, G0, none, F#0, G0, G0, C3, C3," +
                " G#1, C2, F#1, F#1, F#0, F#0, F0, D#0, E0, C#3, C#3, F0, F0, F0, A3, G2, none, G#4, E3, B0, B0, C3, G#3, C0," +
                " B0, A0, A0, A0, none, none, none, F0, none, F#1, F#1, G1, G1, G1, G1, F1, C4, none, E0, C#3, C#3, none, G2," +
                " F#0, E1, F1, F#1, F1, F1, F1, E1, E2, E2, C#3, C#3, D0, D1, C1, C1, B0, C0, C#3, C3, D3, C#3, C#3, D3, C#3," +
                " D3, D3, C3, C3, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none," +
                " none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none," +
                " A0, D0, F0, D2, B3, D3, none, A1, none, C#2, D2, C#2, E2, C#3, D#3, E3, G#1, G#2, E2, none, none, none, none, none," +
                " none, A0, D0, F#0, F#0, C4, B4, F0, F0, G0, D#3, G0, B3, F#4, G4, G#0, G1, C3, none, B4, F1, F#0, D0, D#0, E0, F#1," +
                " F1, F1, G1, F#0, G0, D3, none, none, A0, B0, D3, D3, D3, D3, B0, Bb0, A0, A0, none, none, none, F0, none, G1, G1," +
                " G1, G1, C4, E1, none, none, none, D#0, D#0, none, G#4, C4, F0, E0, C3, C3, C3, C3, C3, C#3, C#3, C#3, E1, E1, D#1, G2," +
                " E2, C#2, A0, D3, C#3, C#3, C#3, C#3, C#3, C#3, C#3, C#3, C3, Bb0, A0, none, none, none, none, none, none, none, none," +
                " none, none, none, none, none, none, none, none, none, none, none, none, none, A0, A0, Bb4, C#2, D#2, F2, C#3, D#1," +
                " D#1, C1, C1, C1, C1, C1, C1, C1, C1, C1, C1, C1, B1, Bb1, A1, G#0, A1, D3, C#3, none, none, none, none, none, none," +
                " Bb2, B2, C2, F#1, F#0, F#0, F0, F#0, C#3, Bb3, A2, D#2, A2, C3, C#3, C#3, F2, F#2, C#2, C#2, D#2, C#2, D#2, D#2," +
                " D2, D#2, D#2, D2, D2, D2, D2, B2, Bb2, C#2, A2, C2, C#2, C2, F#2, C#2, C2, C2, C#2, C2, C2, C2, C2, C2, C2, C2," +
                " F2, F#2, G2, G2, Bb2, G2, B2, F2, G2, B2, Bb2, Bb2, B2, G2, G2, B2, G2, B2, B2, E2, F#2, F#2, F#2, F#2, G2, B2, " +
                "Bb2, G2, Bb2, Bb2, Bb2, F#2, A2, F#2, A2, D1, Bb0, B1, C1, C3, C#3, C#3, C3, G#0, B3, B3, Bb3, Bb3, Bb3, Bb3, G#1," +
                " G1, Bb2, A2, G#1, G1, none"};
        Song Dio = new Song();
        Dio.setTitle("Holy Diver");
        Dio.setArtist("Dio");
        Dio.setNotes(notes);
        songDOA.save(Dio);
    }

    @RequestMapping(value = "/addNirvana", method = RequestMethod.PUT)
    void addSongNirvana(){
        String[] notes = {"G#5, G#5, none, A0, A0, A0, C0, E2, C1, C1, D#1, D#1, D#1, D#2, D#2, D#0, F0, F1, C2, C2, B2, A0, A0, A0, G#0," +
                " D#1, D#1, A0, A0, A0, A0, A0, A0, A0, A0, none, G#0, none, C0, D0, D#0, E0, E0, F0, F0, F0, E0, E0, D#0, D0, C0, A0, F0, B0," +
                " C1, C1, C1, C1, C1, C1, C1, C1, C1, C1, C0, C1, C1, C1, C1, C1, C1, C1, E2, E2, E2, E2, C1, C1, C1, B1, A0, A0, A0, A0, G#0, G#0, " +
                "G#0, G#0, G#0, G#0, A0, A0, G#0, G#0, A0, A0, A0, A0, A0, Bb0, Bb0, Bb0, B0, C0, C0, C0, Bb0, Bb0, B0, Bb0, A0, A0, A0, A0, A0, D1," +
                " A0, D1, A0, A0, A0, G#0, A0, A4, A4, C0, B0, A0, D0, E1, D#1, D#2, D#1, D#1, D#1, D#1, F0, F1, F1, F1, D#1, Bb0, A0, A0, G0, D#1, " +
                "D#1, D#1, D#1, D#1, A0, A0, none, none, A0, A0, A0, D#4, C0, D#0, D#1, D#1, E1, F1, G#2, F1, D#2, D#2, D#1, D#1, A0, B4, Bb5, C0," +
                " C1, C1, C1, C1, C1, C1, C1, C1, C1, C1, C1, C1, G0, G0, B1, C1, C1, C1, C1, C1, C1, C1, C1, C1, C1, B2, F1, D1, A0, A0, D#1, D#1," +
                " D#1, D#1, D#1, D#1, none, none, none, none, A0, A0, A0, A0, Bb0, Bb1, B1, B1, B1, C1, C1, B1, Bb1, Bb1, Bb1, A1, A0, A0, A0, A0, " +
                "G0, D1, G0, A0, G0, A0, A0, G0, G0, G0, G0, F#0, A0, G0, D1, D1, D1, A0, A0, D1, A0, A0, A0, D1, G0, A0, G#0, G#0, G0, D1, D1, D1, " +
                "D1, G1, D1, A0, A0, A0, A0, A0, D1, D1, G0, G0, D1, D1, D1, G1, D1, B2, D1, D1, A0, G#1, A0, D1, A0, F2, F2, D1, D1, G1, D2, F1, " +
                "C2, E1, A0, A0, none, A0, A0, G#0, G#0, G#0, G#0, D1, G1, G1, B2, D1, G1, D1, D1, A0, D1, A0, G0, G#0, G#0, G#0, D1, D1, G1, G1," +
                " D1, D1, D1, D1, A0, D1, D1, A0, G#0, G#0, D1, G1, G1, G1, D1, A0, A0, G#1, G#1, D#1, G#1, A0, D1, G0, D1, G1, G1, E2, F#1, A2," +
                " C1, B1, A0, none, none, E1, F1, G2, G#0, G#0, D1, D1, D1, G1, G1, D2, D2, Bb2, D1, A0, A0, D1, D1, D#1, D#1, D1, D1, G1, G1," +
                " G1, D1, D1, D1, C#1, A0, A0, G#1, G#0, G0, D1, D1, G1, D2, D2, B2, Bb2, F#1, G#2, B2, G#1, D2, B2, G0, D2, D1, G1, G1, B2, E1," +
                " C#2, C2, A0, none, A0, A0, G1, D1, D#2, G#0, D#1, G1, G#1, G1, D2, D2, Bb2, Bb2, F#0, A0, A0, G#1, D1, G#0, G#0, G1, G1, F2, " +
                "D2, D2, D1, G1, G0, A0, C#1, G2, G#2, G#0, D#1, D1, G1, G1, G#1, D1, D1, G#1, G#1, G#1, G#1, G#2, G#2, G#2, G1, Bb2, D2, D2, D2," +
                " Bb2, G1, E0, F1, C2, C2, C2, C2, C2, C2, B2, D2, C#2, none, none, none, D1, G#1, Bb2, Bb2, F#2, F#2, F3, none, Bb1, Bb2, Bb2, Bb2, " +
                "Bb2, Bb1, D3, G#0, A1, G#1, G#1, G#1, G#1, A3, G#2, G#1, E1, G#1, none, none, none, none, A0, A1, C#1, C#1, C#1, C#1, C#1, C#1, C#1," +
                " G#2, F2, F2, G#1, F2, G#1, B0, C1, G1, G1, G1, E2, E2, G1, G1, E1, A0, none, none, none, none, C#1, D1, Bb2, Bb2, Bb2, Bb1, Bb2, A1," +
                " A1, Bb2, Bb2, Bb2, Bb1, Bb1, Bb1, G#1, G#1, G#1, G#1, G#2, G#1, G#1, G#2, F#1, G#1, G#1, none, none, none, E1, G1, D#2, G#1, G#1, G#0," +
                " F0, none, G#0, G#2, G1, G2, G1, D2, B0, F#1, F1, F1, F#1, F1, A3, F1, E1, E1, A0, A0, none, none, none, A1, G1, G1, Bb3, Bb2, Bb3, B1," +
                " none, A1, Bb2, Bb2, Bb2, F1, C3, Bb1, Bb1, A1, G#1, G#1, G#1, G#1, G#1, G#1, G#1, G#1, E1, none, none, G#1, none, A0, C1, C#1, C#1, C#1," +
                " C#1, C#1, C#1, G#2, G#2, G#1, G#1, G#1, G#1, G#1, B1, C1, G1, G1, G1, E2, E2, G1, F#1, A0, A0, none, none, none, none, D1, G1, Bb2, Bb2," +
                " Bb2, Bb2, Bb2, A1, Bb2, Bb2, Bb2, Bb2, Bb1, Bb1, Bb1, G#1, G#1, G#1, G#1, G#1, G#1, G#1, G1, G#1, G#1, G#1, none, none, none, F#1, G#1," +
                " G#1, G#1, G0, G0, G0, G#0, G#1, G2, D2, G2, G2, D2, F1, F1, F1, E1, F1, F2, F2, E2, C#1, Bb2, none, none, none, none, none, Bb1, F#1," +
                " Bb2, Bb2, F2, F2, Bb1, F2, A2, Bb2, Bb2, Bb2, Bb3, Bb2, G#0, G#1, G#1, G#2, G#1, G#2, G#1, G#1, G1, E1, Bb2, Bb2, none, G#1, none, E2," +
                " E2, D2, D2, D1, C#1, none, none, D0, C#1, C#1, C#1, C#1, C#1, C#1, C#1, C1, G1, G1, G#1, G#1, G#1, G1, G1, C#2, Bb2, G#1, G#1, G#1, B0," +
                " E1, E2, Bb2, Bb2, Bb2, F2, none, Bb1, Bb1, Bb3, Bb1, Bb1, Bb1, A1, G#1, G#1, G#1, G#1, G#1, G#2, G#1, G#2, G#1, G1, E1, D1, none, G1, " +
                "none, none, D#0, F#0, G0, D#1, G#1, G#1, G#1, G#1, G#1, G1, G1, F1, C1, G1, none, G#1, none, none, none"};
        Song Nirvana = new Song();
        Nirvana.setTitle("Smells Like Teen Spirit");
        Nirvana.setArtist("Nirvana");
        Nirvana.setNotes(notes);
        songDOA.save(Nirvana);
    }

    @RequestMapping(value = "/addJackson5", method = RequestMethod.PUT)
    void addSongJackson5(){
        String[] notes = {"G#5, G#5, G#5, G#5, G#5, G#5, G#5, G#5, G#5, G#5, G#5, G#5, G#5, G#5, none, none, none, none, none, G#1, A2, C1, G2, D#1, D#1, D2, D#1," +
                " C#1, D#2, D#2, D2, D#1, E1, C#1, C#1, D#2, D#1, D#1, F1, F1, F1, F1, F1, F1, F1, F1, F1, F1, E1, D#1, C#1, B1, D#1, F1, none, none, A0, none, none," +
                " none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, none, " +
                "none, G#0, G#0, A1, Bb1, E3, E3, C2, D1, D#1, D#1, E1, D#1, D#1, D2, D1, D1, C1, C3, D4, D#2, A3, Bb3, Bb3, D#1, B3, F2, C3, C3, C3, B3, Bb3, C2, G#1," +
                " G1, none, G#0, G0, F#0, G0, G0, Bb2, Bb2, Bb3, Bb3, Bb2, Bb2, B2, B3, B3, B1, B1, A1, G#0, G#0, C3, A1, D#2, G#1, G#1, G1, E2, A2, B2, G#1, C2, G#1," +
                " G#1, G#1, G#2, C3, D#3, D3, E3, E3, G#2, B2, B2, Bb2, Bb2, B2, C2, C#2, F#1, C#2, F#2, D#3, G#3, D0, D#3, D#3, B0, F3, A3, A3, G#2, none, none, Bb3, G#1," +
                " G#1, none, none, C#0, none, B0, B0, E1, G#3, G#1, G#1, D#2, G#1, A1, Bb1, A1, Bb1, Bb2, B2, A1, Bb2, B1, G0, G#0, A1, G#1, G#1, G#0, none, G#1, G#1, G1, G#1, " +
                "F0, C3, C3, B3, C3, F0, B3, Bb3, B3, B3, C#3, C#3, C#2, C2, G#2, A3, D#2, D#2, D#2, D#2, Bb3, D#2, C#2, C#2, D#1, D1, Bb1, B1, Bb1, B1, B1, G0, G#0, G#0, G#0," +
                " G0, A1, G0, A1, A1, none, none, none, none, none, none, none, none, none, none, none, none, D#2, E2, E2, C#2, G2, G2, C2, D2, D2, A3, D2, Bb4, A3, D#2, Bb3, " +
                "Bb3, D#3, F3, F3, F3, C2, C#2, C3, none, none, none, none, none, none, none, none, none, none, none, none, none, G#0, A1, G3, none, none, D#0, none, Bb3, Bb3," +
                " F#2, none, G#2, A3, A2, Bb2, F#1, F#2, D#2, none, C#3, C#3, C#0, E3, E3, E3, none, C#0, D0, D#0, D0, D0, none, none, none, none, A2, A2, A2, G#1, D#2, D2, C2," +
                " D0, D#3, F#1, C#2, C#2, F#2, none, Bb3, D0, D0, C#0, C0, B0, none, D0, C#0, E3, E3, Bb3, G#2, F3, B1, C0, C#0, C#0, D#3, D#3, D#0, D#0, none, none, none, D#1," +
                " D#1, D#1, D#1, D#0, D#0, D#0, F0, F0, F0, F0, G#0, G#0, G#0, A1, G#0, A1, A1, G#0, G#0, none, G#0, none, none, none, none, none, E3, Bb1, B1, B1, C1, Bb1, Bb1," +
                " G#1, G#1, D0, D1, C#1, E1, D#1, D1, E0, F0, F0, F0, F0, G#0, G#0, G#0, G#0, G#0, G#0, G#0, G#0, none, none, none, none, F2, F2, F#2, F#2, F#2, B1, D3, D3, B1, " +
                "Bb1, Bb1, A1, G#1, A1, E1, D#1, D1, E1, D#1, D#1, D0, F0, F1, F0, E0, F0, G#0, A1, G#0, G#0, G0, none, A2, B2, D3, D3, Bb1, Bb1, Bb1, B1, B1, B1, C1, B1, G#0, " +
                "F0, F0, none, none, none, A1, Bb2, B2, C2, C2, C3, C1, Bb1, Bb1, Bb1, A1, Bb1, G#0, G#0, D#3, A1, A1, G#0, G#0, G#0, G#0, B1, Bb1, Bb1, C2, C2, C3, B1, B1, C1," +
                " C1, C1, C1, G#0, G#0, G#1, G#1, G#1, G#1, B3, G1, G#0, B3, G#0, G#0, G0, G#0, G#2, G1, A1, G1, G#0, G#0, G1, G1, none, none, none, none, none, none, none, none," +
                " none, G#0, Bb1, B1, B1, B1, B1, Bb1, G1, G1, D0, D#1, D#1, D#1, E1, D1, E0, F0, F0, F0, F0, F0, G#0, G#0, G#0, G#0, G#0, G#0, G#0, none, none, none, none, F2," +
                " F#2, F#2, B2, F#2, B1, D3, B1, B2, A1, Bb1, A1, G1, G#1, F0, D#1, D1, D#1, D#1, D#1, E0, C3, F1, F0, F0, F0, G#0, G#0, G#0, G#0, G#0, none, A2, C#3, D3, Bb1, Bb1," +
                " Bb1, Bb1, B1, C1, B1, C1, A1, A1, F#0, F0, none, none, none, G#0, Bb2, Bb2, B2, B1, B1, B2, A1, A1, A1, G#0, A1, G0, G0, G#0, G0, D1, D3, D3, D#3, D#3, D#3, D1," +
                " D#2, A3, D2, D#3, B1, B1, C1, C1, C1, G#0, G#2, G1, G#2, G1, G#1, G#1, G1, G#1, G0, A2, G#0, G1, G#1, G1, G#1, A2, G1, G#1, G0, G#1, E2, D2, D2, G#1, G0, G#0, G#0," +
                " A1, A1, A1, Bb1, G#0, Bb1, none, none, none, none, none, none, none, none, none, none"};
        Song Jackson5 = new Song();
        Jackson5.setTitle("ABC");
        Jackson5.setArtist("Jackson5");
        Jackson5.setNotes(notes);
        songDOA.save(Jackson5);
    }

    @RequestMapping(value = "/getNotes", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody String[] getNotes(@RequestBody int id){

        try{
           Song song = songDOA.findByid(id);
           return song.getNotes();
        }
        catch(Exception e){
             String[] s = {"No", "Songs"};
             return s;
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody Song test(){
        Song x = null;
        for(Song s: songDOA.findAll()){
            x = s;
        }
        return x;
    }

    @RequestMapping(value = "/holyDiver", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public @ResponseBody
    double uploadFileHandler(@RequestParam("file") MultipartFile file) throws IOException, UnsupportedAudioFileException {

        File convFile = new File(file.getOriginalFilename());
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        Song dio = songDOA.findByid(1);
        String[] dioNotes =  dio.getNotes();
        ArrayList<String> sungNotes =  new  ConvertAudioToNotes().run(convFile);
      return  dio.compareNotes(sungNotes);

    }

    @Autowired
    SongDOA songDOA;
}
