import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Playlist playlist = new Playlist("My Playlist");
        playlist.displayPlaylist();

        System.out.println("Do you want to add more songs? (yes/no)");
        String response = scanner.nextLine();
        
        if (response.equalsIgnoreCase("yes")) {
            System.out.println("What song do you want to add?");
            String songTitle = scanner.nextLine();
        }if (response.equalsIgnoreCase("no")) {
            System.out.println("Do you want to shuffle the playlist? (yes/no)");
            String shuffleResponse = scanner.nextLine();
            if (shuffleResponse.equalsIgnoreCase("yes")) {
                playlist.shufflePlaylist();
            }if (shuffleResponse.equalsIgnoreCase("no")) {
                System.out.println("Final Playlist:");
                playlist.displayPlaylist();
            }
        }
    }
}
