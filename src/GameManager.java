import javax.swing.*;
import javax.swing.JLabel;
/**
 * GameManager operates rules and condition for the player and robot.
 * Operates a minimal amount of GUI objects using java swing
 */
public class GameManager {
    private Robot robot;
    private Player player;
    private JFrame window;
    private StatTracker statTracker;

    /**
     * Constructor initializes a starting menu for the player to insert information
     */
    public GameManager() {
        //initializes game objects
        robot = new Robot();
        player = new Player();
        statTracker = new StatTracker();

        //loads the menuWindow
        this.loadMenuWindow();

    }

// Windows/GUI section
//-------------------------------------------------------------------------------------------
    /**
     * loads the
     */
    public void loadMenuWindow() {
        //the window has already been initialized
        if (window != null) {
            window.getContentPane().removeAll();
            window.repaint();
        }

        JLabel title = new JLabel();
        title.setText("Rock Paper Scissors in Java");
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setOpaque(true);
        title.setBounds(0, 0, 250, 250);

        //Button to start playing
        JButton playButton = new JButton("Play");
        playButton.setBounds(200, 100, 100, 50);
        playButton.addActionListener(e -> loadGameWindow());

        //window setup
        if ( window == null) {
            window = new JFrame();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setLayout(null);
            window.setSize(1920, 1080);
            window.setTitle("Menu");
            window.setResizable(true);
        }

        //loads everything onto screen
        window.add(playButton);
        window.add(title);
        window.setVisible(true);
    }

    /**
     * Loads the window where the user can interact with the Robot and gamble
     */
    public void loadGameWindow() {
        window.getContentPane().removeAll();
        window.repaint();

        JLabel title = new JLabel();
        title.setText("Rock Paper Scissors");
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setOpaque(true);
        title.setBounds(0, 0, 250, 250);

        //Button to return
        JButton menuButton = new JButton("Back to menu");
        menuButton.setBounds(0, 0, 100, 50);
        menuButton.addActionListener(e -> loadMenuWindow());

        //Button for player to choose rock
        JButton rockButton = new JButton("Back to menu");
        rockButton.setBounds(0, 0, 100, 50);
        rockButton.addActionListener(e -> gameEvaluation("rock"));

        //Button for player to choose paper
        JButton paperButton = new JButton("Back to menu");
        paperButton.setBounds(0, 0, 100, 50);
        paperButton.addActionListener(e -> gameEvaluation("paper"));

        //Button for player to choose paper
        JButton scissorsButton = new JButton("Back to menu");
        scissorsButton.setBounds(0, 0, 100, 50);
        scissorsButton.addActionListener(e -> gameEvaluation("scissor"));

        //loads everything onto screen
        window.add(rockButton);
        window.add(paperButton);
        window.add(scissorsButton);
        window.add(menuButton);
        window.add(title);
        window.setVisible(true);




    }
// Game Logic Section
//-------------------------------------------------------------------------------------------

    /**
     *
     * @param move
     * @return an integer representing whether or not the player won.
     */
    public int gameEvaluation(String move) {
        String robotsMove = robot.getMove();
        String playersMove = move;

        //evaluates the tie condition and winning condition. Any other case scenario is a lost for the player.
        if (playersMove.equals(robotsMove)) {
            return 0;
        } else if(playersMove.equals("paper") && robotsMove.equals("rock")) {
            return 1;
        } else if(playersMove.equals("scissor") && robotsMove.equals("paper")) {
            return 1;
        } else if(playersMove.equals("rock") && robotsMove.equals("scissor")) {
            return 1;
        } else {
            return -1;
        }
    }

}
