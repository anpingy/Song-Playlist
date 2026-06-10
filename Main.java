import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Playlist playlist = new Playlist("My Playlist");
        playlist.displayPlaylist();

        System.out.println("Input the number to add songs to the playlist:");
        System.out.println("1. Good 4 u by Olivia Rodrigo");
        System.out.println("2. Good Graces by Sabrina Carpenter");
        System.out.println("3. Consulation no 3 by Franz Joseph Liszt");
        System.out.println("4. Give Up Baby Go by Peach Pitt");
        System.out.println("5. Friend Like Me by Will Smith");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (choice == 1) {
            playlist.addSong(new Song("Good 4 u", "Olivia Rodrigo", "path/to/good4u.mp3"));
        } else if (choice == 2) {
            playlist.addSong(new Song("Good Graces", "Sabrina Carpenter", "path/to/goodgraces.mp3"));
        } else if (choice == 3) {
            playlist.addSong(new Song("Consulation no 3", "Franz Joseph Liszt", "path/to/consulationno3.mp3"));
        } else if (choice == 4) {
            playlist.addSong(new Song("Give Up Baby Go", "Peach Pitt", "path/to/giveupbabygo.mp3"));
        } else if (choice == 5) {
            playlist.addSong(new Song("Friend Like Me", "Will Smith", "path/to/friendlikeme.mp3"));
        } else {
            System.out.println("Invalid choice!");
        }

        System.out.println("Do you want to add more songs? (yes/no)");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            // Add more songs to the playlist
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
