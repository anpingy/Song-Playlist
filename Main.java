import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist("My Playlist");
        Music music1 = new Music("Buttons", "Lyn Lapid", "Buttons by Lyn Lapid.wav");
        music1.play();
        playlist.displayPlaylist();
        System.out.println("Do you want to add more songs? (yes/no)");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")){
            System.out.println("Input the number to add songs to the playlist:");
            System.out.println("1. Anytime, Always by Wallows");
            System.out.println("2. Buttons by Lyn Lapid");
            System.out.println("3. Downer by Nirvana");
            System.out.println("4. Fell in Love With a Girl by The White Stripes");
            System.out.println("5. For No One by The Beatles");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            if (choice == 1) {
                playlist.addSong(new Song("Anytime, Always", "Wallows", "Anytime, Always by Wallows.wav"));
            } else if (choice == 2) {
                playlist.addSong(new Song("Buttons", "Lyn Lapid", "Buttons by Lyn Lapid.wav"));
            } else if (choice == 3) {
                playlist.addSong(new Song("Downer", "Nirvana", "Downer by Nirvana.wav"));
            } else if (choice == 4) {
                playlist.addSong(new Song("Fell In Love With a Girl", "The White Stripes", "Fell In Love With a Girl by The White Stripes.wav"));
            } else if (choice == 5) {
                playlist.addSong(new Song("For No One", "The Beatles", "For No One by The Beatles.wav"));
            } else {
                System.out.println("Invalid choice!");
            }
        }
        if (response.equalsIgnoreCase("no")) {
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
