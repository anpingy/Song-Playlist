import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    //Fields
    public Music music;
    private String name;
    public ArrayList<Song> songs;
    private Thread t;
    public static boolean indexNumber = true;
    private int currentIndex = 0;

    //Constructor
    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    //Play all songs in the playlist in order
    public void playPlaylist() {
        currentIndex = 0;
        t = new Thread(() -> {
            while (currentIndex < songs.size()) {
                Thread.interrupted(); //clears interrupted flag so loop continues after skip
                Song song = songs.get(currentIndex);
                Music music = new Music(song.getTitle(), song.getArtist(), song.getFilePath());
                music.play();
                currentIndex++;
            }
        });
        //Start the thread to play songs
        t.start();
    }

    public void skipPlaylist() {
        System.out.println("Skipping song.");
        //Interrupt the play thread to skip to the next song
        t.interrupt();  
    }
     
    //Add a song to the end of the playlist
    public void addSong(Song song) {
        songs.add(song);
    }
    //Queue a song to play next (add to the front of the playlist)
    public void queueSong(Song song) {
        songs.add(currentIndex + 1, song); //Add the song right after the current song
        System.out.println("Queued: " + song.getTitle());
    }


    //Remove a song by its index position
    public void removeSong(int index) {
            if (index-1 >= 0 && index-1 < songs.size()) { //User inputs index starting from 1 and is adjusted to 0-based index
                System.out.println("Removed: " + songs.get(index-1).getTitle());
                songs.remove(index-1);
                indexNumber = false; //prevent index number from being displayed in the dropdown after a song is removed
            } else {
                System.out.println("Invalid track number! Please enter a valid track number:");
        }
    }


    //Shuffle all songs randomly
    public void shufflePlaylist() {
        Collections.shuffle(songs);
        System.out.println("Playlist '" + name + "' has been shuffled.");
    }


    //Display all songs in the playlist
    public void displayPlaylist() {
        System.out.println("\n--- My Playlist ---");
        if (songs.isEmpty()) {
            System.out.println("The playlist is empty.");
            return;
        }
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i).getTitle());
        }
    }
}



