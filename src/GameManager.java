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
    private JLabel statusText;
    private JLabel outcome;
    private JLabel robotsMove;
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
     * loads the starting window for users to enter their name.
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
        playButton.setBounds(400, 100, 100, 50);
        playButton.addActionListener(e -> loadGameWindow());

        //window setup
        if (window == null) {
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
        title.setText("Rock Paper Scissors in Progress");
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setOpaque(true);
        title.setBounds(0, 0, 250, 250);

        //Button to return
        JButton menuButton = new JButton("Back to menu");
        menuButton.setBounds(0, 0, 200, 50);
        menuButton.addActionListener(e -> loadMenuWindow());

        //Button for player to choose rock
        JButton rockButton = new JButton("Rock");
        rockButton.addActionListener(e -> setStatusText("rock"));
        rockButton.setBounds(200, 100, 100, 50);


        //Button for player to choose paper
        JButton paperButton = new JButton("Paper");
        paperButton.setBounds(400, 100, 100, 50);
        paperButton.addActionListener(e -> setStatusText("paper"));

        //Button for player to choose scissor
        JButton scissorsButton = new JButton("Scissors");
        scissorsButton.setBounds(300, 100, 100, 50);
        scissorsButton.addActionListener(e -> setStatusText("scissor"));

        //Button for the player to submit their move
        JButton submitButton = new JButton("Confirm action");
        submitButton.setBounds(400, 400, 200, 50);
        submitButton.addActionListener(e -> submitUpdate());

        //Updating text field
        statusText = new JLabel("Choosing:");
        statusText.setBounds(400, 300, 100, 50);
        statusText.setOpaque(true);

        //Tells player if they win
        outcome = new JLabel("Waiting input");
        outcome.setBounds(300, 300, 100, 50);

        //Tells player what the robot chose
        robotsMove = new JLabel("Robot is thinking");
        robotsMove.setBounds(0, 300, 200, 50);

        //loads everything onto screen
        window.add(robotsMove);
        window.add(outcome);
        window.add(statusText);
        window.add(rockButton);
        window.add(paperButton);
        window.add(scissorsButton);
        window.add(submitButton);
        window.add(menuButton);
        window.add(title);
        window.setVisible(true);
    }

    // Game Logic Section
//-------------------------------------------------------------------------------------------

    /**
     *
     * @param chosenMove
     */
    private void setStatusText(String chosenMove) {
        statusText.setText(chosenMove);
    }

    /**
     * Confirms the player's choice of move
     * @return true if the action was successful, false if the player didn't pick a move
     */
    public boolean submitUpdate() {
        int gameOutcome;
        if (statusText.getText().contains("rock")
                || statusText.getText().contains("paper")
                || statusText.getText().contains("scissor")) {
            gameOutcome = this.gameEvaluation(statusText.getText());
        } else {
            statusText.setText("Pick something before submitting");
            return false;
        }

        if(gameOutcome == 1) {
            outcome.setText("You won!");
        } else if (gameOutcome == -1) {
            outcome.setText("You lost lol!");
        } else {
            outcome.setText("You tied with the bot");
        }
        statusText.setText("pick again");
        return true;
    }

    /**
     * Evaluates and updates the game page when the play
     *
     * @param move A string that is binded to the RPS buttons from the game page.
     * @return an integer representing whether or not the player won.
     */
    private int gameEvaluation(String move) {
        String robotsMove = robot.getMove();
        String playersMove = move;
        this.robotsMove.setText("The robot picked:" + robotsMove); //shows what the robot chose

        //evaluates the tie condition and winning condition. Any other case scenario is a lost for the player.
        if (playersMove.equals(robotsMove)) {
            return 0;
        } else if (playersMove.equals("paper") && robotsMove.equals("rock")) {
            return 1;
        } else if (playersMove.equals("scissor") && robotsMove.equals("paper")) {
            return 1;
        } else if (playersMove.equals("rock") && robotsMove.equals("scissor")) {
            return 1;
        } else {
            return -1;
        }
    }
}
