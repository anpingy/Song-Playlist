import java.awt.*;
import javax.swing.*;

public class userInterface extends JFrame {

    private boolean empty = true;

    public userInterface(Playlist playlist) {

        setTitle("My Playlist");
        setSize(500, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel label = new JLabel("My Playlist Controls");

        JButton playButton    = new JButton("Play");
        JButton showButton    = new JButton("Show");
        JButton shuffleButton = new JButton("Shuffle");
        JButton skipButton    = new JButton("Skip");
        JButton addButton     = new JButton("Add Song");
        JButton queueButton   = new JButton("Queue Song");
        JButton removeButton  = new JButton("Remove Song");
        JButton searchButton  = new JButton("Search Song");
        JButton exitButton    = new JButton("Exit");

        playButton.setVisible(false);
        shuffleButton.setVisible(false);
        skipButton.setVisible(false);
        queueButton.setVisible(false);
        removeButton.setVisible(false);
        searchButton.setVisible(false);

        // PLAY
        playButton.addActionListener(e -> {
            playlist.playPlaylist();
            if (playlist.songs.isEmpty()) {
                JOptionPane.showMessageDialog(this, "The playlist is empty.", "Play", JOptionPane.WARNING_MESSAGE);
            } else {
                playButton.setVisible(false);
            }
        });

        // SHOW
        showButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("<html><b>--- My Playlist ---</b><br>");
            if (playlist.songs.isEmpty()) {
                sb.append("The playlist is empty.");
            } else {
                for (int i = 0; i < playlist.songs.size(); i++) {
                    sb.append((i + 1)).append(". ")
                      .append(playlist.songs.get(i).getTitle()).append("<br>");
                }
            }
            sb.append("</html>");
            JOptionPane.showMessageDialog(this, sb.toString(), "Playlist", JOptionPane.INFORMATION_MESSAGE);
        });

        // SHUFFLE
        shuffleButton.addActionListener(e -> {
            playlist.shufflePlaylist();
            JOptionPane.showMessageDialog(this, "Playlist shuffled!", "Shuffle", JOptionPane.INFORMATION_MESSAGE);
        });

        // SKIP
        skipButton.addActionListener(e -> playlist.skipPlaylist());


        // ADD SONG
        addButton.addActionListener(e -> {
            Song chosen = pickSong("Add Song", "Choose a song to add:");
            if (chosen != null) {
                if (empty) {
                    empty = false;
                    playButton.setVisible(true);
                }
                shuffleButton.setVisible(true);
                skipButton.setVisible(true);
                queueButton.setVisible(true);
                removeButton.setVisible(true);
                searchButton.setVisible(true);
                playlist.addSong(chosen);
                JOptionPane.showMessageDialog(this, "Added: " + chosen.getTitle(), "Add Song", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // QUEUE SONG
        queueButton.addActionListener(e -> {
            Song chosen = pickSong("Queue Song", "Choose a song to queue:");
            if (chosen != null) {
                playlist.queueSong(chosen);
                JOptionPane.showMessageDialog(this, "Queued: " + chosen.getTitle(), "Queue Song", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //Search Song

        searchButton.addActionListener(e -> {
            String searchTitle = JOptionPane.showInputDialog(this, "Confirm if the song exists in your playlist:", "Search Song", JOptionPane.QUESTION_MESSAGE);
                if (searchTitle != null) {
                    boolean found = false;
                    for (int i = 0; i < playlist.songs.size(); i++) {
                        Song song = playlist.songs.get(i);
                        if (song.getTitle().equalsIgnoreCase(searchTitle)) {
                            JOptionPane.showMessageDialog(this, "Found: " + song.getTitle() + " by " + song.getArtist(), "Search Result", JOptionPane.INFORMATION_MESSAGE);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(this, "Song not found in the playlist.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
        });
        // REMOVE SONG
        removeButton.addActionListener(e -> {
            if (playlist.songs.isEmpty()) {
                JOptionPane.showMessageDialog(this, "The playlist is empty.", "Remove Song", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String[] titles = new String[playlist.songs.size()];
            for (int i = 0; i < playlist.songs.size(); i++) {
                titles[i] = (i + 1) + ". " + playlist.songs.get(i).getTitle();
            }
            String chosen = (String) JOptionPane.showInputDialog(
                this,
                "Choose a song to remove:",
                "Remove Song",
                JOptionPane.QUESTION_MESSAGE,
                null,
                titles,
                titles[0]
            );
            if (chosen == null) return;
            int index = Integer.parseInt(chosen.split("\\.")[0]); // extract track number
            playlist.removeSong(index);
            JOptionPane.showMessageDialog(this, "Removed track " + index, "Remove Song", JOptionPane.INFORMATION_MESSAGE);
        });
        exitButton.addActionListener(e -> System.exit(0));
        add(label);
        add(playButton);
        add(skipButton);
        add(shuffleButton);
        add(addButton);
        add(queueButton);
        add(removeButton);
        add(showButton);
        add(searchButton);
        add(exitButton);

        setVisible(true);
    }

    // Reusable song picker — avoids duplicating the options list
    private Song pickSong(String title, String prompt) {
        String[] options = {
            "Anytime, Always - Wallows",
            "Buttons - Lyn Lapid",
            "Downer - Nirvana",
            "Fell In Love With a Girl - The White Stripes",
            "For No One - The Beatles"
        };

        String choice = (String) JOptionPane.showInputDialog(
            this, prompt, title,
            JOptionPane.QUESTION_MESSAGE, null, options, options[0]
        );

        if (choice == null) return null;

        return switch (choice) {
            case "Anytime, Always - Wallows"               -> new Song("Anytime, Always", "Wallows", "Anytime, Always by Wallows.wav");
            case "Buttons - Lyn Lapid"                     -> new Song("Buttons", "Lyn Lapid", "Buttons by Lyn Lapid.wav");
            case "Downer - Nirvana"                        -> new Song("Downer", "Nirvana", "Downer by Nirvana.wav");
            case "Fell In Love With a Girl - The White Stripes" -> new Song("Fell In Love With a Girl", "The White Stripes", "Fell In Love With a Girl by The White Stripes.wav");
            case "For No One - The Beatles"                -> new Song("For No One", "The Beatles", "For No One by The Beatles.wav");
            default -> null;
        };
    }
}