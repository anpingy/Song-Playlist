

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("My Playlist");
        // Start GUI (connected to SAME playlist)
        new userInterface(playlist);
}
}
