import javax.swing.*;

/**
 * GameManager operates rules and condition for the player and robot.
 */
public class GameManager {
    private Robot robot;
    private Player player;
    private JFrame window;

    /**
     * Constructor initializes a starting menu for the player to insert information
     */
    public GameManager() {
        window = new JFrame();
        window.setSize(720,480);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Menu");
        JLabel title = JLabel();
        JButton playButton = new JButton("Play");
        //playButton.addActionListener(this);
    }
}
