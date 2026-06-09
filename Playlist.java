import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    private String name;
    private ArrayList<Song> songs;

    // Constructor
    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
        
    }

    // Add a song to the end of the playlist
    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Added: " + song.getTitle());
    }

    // Queue a song to play next (add to the front of the playlist)
    public void queueSong(Song song) {
        songs.add(0, song);
        System.out.println("Queued: " + song.getTitle());
    }

    // Remove a song by its index position
    public void removeSong(int index) {
        if (index >= 0 && index < songs.size()) {
            System.out.println("Removed: " + songs.get(index).getTitle());
            songs.remove(index);
        } else {
            System.out.println("Invalid track index!");
        }
    }

    // Shuffle all songs randomly
    public void shufflePlaylist() {
        Collections.shuffle(songs);
        System.out.println("Playlist '" + name + "' has been shuffled.");
    }

    //loop through the playlist indefinitely
    public void loopPlaylist() {
        System.out.println("Looping playlist '" + name + "'.");
        while (true) {
            for (Song song : songs) {
                System.out.println("Playing: " + song.getTitle());
            }
        }
    }
    

    // Display all songs in the playlist
    public void displayPlaylist() {
        System.out.println("\n--- " + name + " Playlist ---");
        if (songs.isEmpty()) {
            System.out.println("The playlist is empty.");
            return;
        }
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
    }
}