import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
    private String title;
    private String artist;
    private String filePath;

    public Music(String title, String artist, String filePath) {
        this.title = title;
        this.artist = artist;
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }



    public void play() {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            System.out.println("Playing: " + title + " by " + artist);
            while (clip.isActive()) {
                // Wait for the song to finish playing
                Thread.sleep(100);
            }
            clip.close();
        } catch (Exception e) {
            System.out.println("Error playing the song: " + e.getMessage());
        }
    }
    public void stop() {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.stop();
            System.out.println("Stopped: " + title + " by " + artist);
        } catch (Exception e) {
            System.out.println("Error stopping the song: " + e.getMessage());
        }
    }
}