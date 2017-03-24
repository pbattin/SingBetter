package model;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

/**
 * Created by prestonbattin on 2/21/17. 😇😇😇😇😇😇😇😇😇
 */
public class Main {


    public static void main(String[] args) throws IOException, UnsupportedAudioFileException {
        final SoundInput recorder = new SoundInput();

        // creates a new thread that waits for a specified
        // of time before stopping
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(recorder.RECORD_TIME);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                recorder.finish();
            }
        });

        stopper.start();

        // start recording
        recorder.start();
        new ConvertAudioToNotes().run(new File("/Users/prestonbattin/Desktop/Michael Jackson - Beat It- Isolated Vocal Track.wav"));
    }




}
