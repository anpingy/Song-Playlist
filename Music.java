import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
    //Fields
    private String title;
    private String artist;
    private String filePath;
    private Clip currentSong;

    
    public Music(String title, String artist, String filePath) {
        //Initialize fields
        this.title = title;
        this.artist = artist;
        this.filePath = filePath;
        //Load the audio file and prepare the clip
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            this.currentSong = AudioSystem.getClip();
            currentSong.open(audioStream);
            currentSong.start();
            System.out.println("Playing: " + title + " by " + artist);
            while (currentSong.isActive() && !Thread.currentThread().isInterrupted()) { //Waits for the song to finish playing
                System.out.print("");
            }
        } catch (Exception e) { //Catches exceptions and informs user
            System.out.println("Error playing the song: " + e.getMessage());
        }finally {
        currentSong.stop();
        currentSong.close();
        }
    }
    //Getters
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public void play() {
        try {
            currentSong.start();
            //Wait for the song to finish playing to prevent all songs playing at once
            while (currentSong.isActive() && !Thread.currentThread().isInterrupted()) {
                // Wait for the song to finish playing
                Thread.sleep(100); 
            }
        } catch (Exception e) {
            System.out.println("Error playing the song: " + e.getMessage());
        }
    }
    public void skip() {
        //Stops current song and interrupts the play loop in Playlist to move to the next song
        try {
        while (currentSong.isActive() && !Thread.currentThread().isInterrupted()) {
        System.out.print(""); 
    }
        } finally {
        currentSong.stop();
        currentSong.close();
    }
    }
}