import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
    private String title;
    private String artist;
    private String filePath;
    private Clip currentSong;

    
    public Music(String title, String artist, String filePath) {
        this.title = title;
        this.artist = artist;
        this.filePath = filePath;

        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            this.currentSong = AudioSystem.getClip();
            currentSong.open(audioStream);
            currentSong.start();
            System.out.println("Playing: " + title + " by " + artist);
            while (currentSong.isActive() && !Thread.currentThread().isInterrupted()) {
                // Wait for the song to finish playing
                System.out.print(""); // Prevent busy-waiting
            }
        } catch (Exception e) {
            System.out.println("Error playing the song: " + e.getMessage());
        }finally {
        currentSong.stop();
        currentSong.close();
        }
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public void play() {
        try {
            // File audioFile = new File(filePath);
            // AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            // Clip clip = AudioSystem.getClip();
            // clip.open(audioStream);
            currentSong.start();
            while (currentSong.isActive() && !Thread.currentThread().isInterrupted()) {
                // Wait for the song to finish playing
                Thread.sleep(100); // Prevent busy-waiting
            }
        } catch (Exception e) {
            System.out.println("Error playing the song: " + e.getMessage());
        }
    }
    public void skip() {
          try {
    while (currentSong.isActive() && !Thread.currentThread().isInterrupted()) {
        System.out.print(""); // Prevent busy-waiting
    }
    } finally {
    currentSong.stop();
    currentSong.close();
    }
      
        // try {
        //     currentSong.stop();
        //     // File audioFile = new File(filePath);
        //     // AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        //     // Clip clip = AudioSystem.getClip();
        //     // clip.open(audioStream);
        //     // clip.stop();
        //     System.out.println("Stopped: " + title + " by " + artist);
        // } catch (Exception e) {
        //     System.out.println("Error stopping the song: " + e.getMessage());
        // }
    }
}