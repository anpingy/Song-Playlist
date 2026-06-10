import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist("My Playlist");
        playlist.displayPlaylist();
        while (true) {
            System.out.println("Type 'add' to add a song, 'play' to play the playlist, 'queue' to queue a song, 'remove' to remove a song, 'shuffle' to shuffle the playlist, 'loop' to loop the playlist, 'stop' to stop the playlist, or 'exit' to quit:");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("add")) {
                System.out.println("Input the number to add songs to the playlist:");
                System.out.println("1. Anytime, Always by Wallows");
                System.out.println("2. Buttons by Lyn Lapid");
                System.out.println("3. Downer by Nirvana");
                System.out.println("4. Fell In Love With a Girl by The White Stripes");
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

            if (command.equalsIgnoreCase("play")) {
                playlist.playPlaylist();
            }

            if (command.equalsIgnoreCase("shuffle")) {
                playlist.shufflePlaylist();
            }
            if (command.equalsIgnoreCase("loop")) {
                playlist.loopPlaylist();
            }
            if (command.equalsIgnoreCase("stop")) {
                playlist.stopPlaylist();
            }
            if (command.equalsIgnoreCase("remove")) {
                System.out.println("Which song do you want to remove? (Enter the index number (starts at 0))");
                playlist.displayPlaylist();
                int index = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                playlist.removeSong(index);
            }
            if (command.equalsIgnoreCase("queue")) {
                System.out.println("Input the number to queue songs to the playlist:");
                System.out.println("1. Anytime, Always by Wallows");
                System.out.println("2. Buttons by Lyn Lapid");
                System.out.println("3. Downer by Nirvana");
                System.out.println("4. Fell In Love With a Girl by The White Stripes");
                System.out.println("5. For No One by The Beatles");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                if (choice == 1) {
                    playlist.queueSong(new Song("Anytime, Always", "Wallows", "Anytime, Always by Wallows.wav"));
                } else if (choice == 2) {
                    playlist.queueSong(new Song("Buttons", "Lyn Lapid", "Buttons by Lyn Lapid.wav"));
                } else if (choice == 3) {
                    playlist.queueSong(new Song("Downer", "Nirvana", "Downer by Nirvana.wav"));
                } else if (choice == 4) {
                    playlist.queueSong(new Song("Fell In Love With a Girl", "The White Stripes", "Fell In Love With a Girl by The White Stripes.wav"));
                } else if (choice == 5) {
                    playlist.queueSong(new Song("For No One", "The Beatles", "For No One by The Beatles.wav"));
                } else {
                    System.out.println("Invalid choice!");
                }
            }
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the music player. Goodbye!");
                break;
            }
        }
    }
}
