import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist("My Playlist");
        Music music1 = new Music("Buttons", "Lyn Lapid", "Buttons by Lyn Lapid.wav");
        music1.play();
        playlist.displayPlaylist();
<<<<<<< HEAD
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
=======
        while (true) {
            System.out.println("Type 'add' to add a song, 'queue' to queue a song, 'remove' to remove a song, 'shuffle' to shuffle the playlist, 'loop' to loop the playlist, or 'exit' to quit:");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("add")) {
                System.out.println("Input the number to add songs to the playlist:");
                System.out.println("1. Good 4 u by Olivia Rodrigo");
                System.out.println("2. Good Graces by Sabrina Carpenter");
                System.out.println("3. Consolation no. 3 by Franz Joseph Liszt");
                System.out.println("4. Give Up Baby Go by Peach Pitt");
                System.out.println("5. Friend Like Me by Will Smith");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                if (choice == 1) {
                playlist.addSong(new Song("Good 4 u", "Olivia Rodrigo", "path/to/good4u.mp3"));
                } else if (choice == 2) {
                    playlist.addSong(new Song("Good Graces", "Sabrina Carpenter", "path/to/goodgraces.mp3"));
                } else if (choice == 3) {
                    playlist.addSong(new Song("Consolation no. 3", "Franz Joseph Liszt", "path/to/consolationno3.mp3"));
                } else if (choice == 4) {
                    playlist.addSong(new Song("Give Up Baby Go", "Peach Pitt", "path/to/giveupbabygo.mp3"));
                } else if (choice == 5) {
                    playlist.addSong(new Song("Friend Like Me", "Will Smith", "path/to/friendlikeme.mp3"));
                } else {
                    System.out.println("Invalid choice!");
                }
>>>>>>> e81267b59572de4ec57167ef4305361135d2ff02
            }
            if (command.equalsIgnoreCase("shuffle")) {
                playlist.shufflePlaylist();
            }
            if (command.equalsIgnoreCase("loop")) {
                playlist.loopPlaylist();
            }
            if (command.equalsIgnoreCase("remove")) {
                System.out.println("Which song do you want to remove? (Enter the index number)");
                playlist.displayPlaylist();
                int index = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                playlist.removeSong(index);
            }
            if (command.equalsIgnoreCase("queue")) {
                System.out.println("Input the number to queue songs to the playlist:");
                System.out.println("1. Good 4 u by Olivia Rodrigo");
                System.out.println("2. Good Graces by Sabrina Carpenter");
                System.out.println("3. Consolation no. 3 by Franz Joseph Liszt");
                System.out.println("4. Give Up Baby Go by Peach Pitt");
                System.out.println("5. Friend Like Me by Will Smith");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                if (choice == 1) {
                    playlist.queueSong(new Song("Good 4 u", "Olivia Rodrigo", "path/to/good4u.mp3"));
                } else if (choice == 2) {
                    playlist.queueSong(new Song("Good Graces", "Sabrina Carpenter", "path/to/goodgraces.mp3"));
                } else if (choice == 3) {
                    playlist.queueSong(new Song("Consolation no. 3", "Franz Joseph Liszt", "path/to/consolationno3.mp3"));
                } else if (choice == 4) {
                    playlist.queueSong(new Song("Give Up Baby Go", "Peach Pitt", "path/to/giveupbabygo.mp3"));
                } else if (choice == 5) {
                    playlist.queueSong(new Song("Friend Like Me", "Will Smith", "path/to/friendlikeme.mp3"));
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
