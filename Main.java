import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("My Playlist");
        playlist.displayPlaylist();

        // Start GUI (connected to SAME playlist)
        new userInterface(playlist);




}
}
