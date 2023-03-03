package OpenAI;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javazoom.jl.player.Player;

public class MP3Player {
    private String filename;
    private Player player; 

    public MP3Player(String filename) {
        this.filename = filename;
    }

    public void play() {
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(filename));
            player = new Player(is);
            player.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void close() {
        if (player != null)
            player.close();
    }

}
