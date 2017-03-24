package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    void addSong(){
        String[] notes = {"A1, A3, A#"};
        Song mj = new Song();
        mj.setId(1);
        mj.setTitle("Beat It");
        mj.setNotes(notes);
        songDOA.save(mj);
        mj.setId(2);
        mj.setTitle("Frozen");
        notes = new String[] {"C4, A1, B4"};
        mj.setNotes(notes);
        songDOA.save(mj);
    }

    @Autowired
    SongDOA songDOA;
}
