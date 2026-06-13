import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class userInterface {
    public static void main(String[] args) {
        // 1. Create the main window frame
        JFrame frame = new JFrame("My Playlist");
        frame.setSize(400, 200); // Width and height in pixels
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Stop program when closed
        frame.setLayout(new FlowLayout()); // Arrange components left-to-right

        // 2. Create UI components
        JLabel label = new JLabel("Welcome to My Playlist!");
        JButton button = new JButton("Click Me");

        // 3. Add components to the frame
        frame.add(label);
        frame.add(button);

        // 4. Make the window visible on screen
        frame.setVisible(true);
    }
}