import java.util.Random;
/**
 * Robot class is the "AI" that the user will go against.
 */
public class Robot {
    private String name;
    private int age;
    private float money;

    public static final String[] STD_MOVES = {"rock", "paper", "scissor"};

    public Robot(){
        this.name = "AI";
        this.age = 0;
        this.money = 1000000;
    }

    public String getMove() {
        Random rand = new Random();
        int moveInt = 1 + rand.nextInt(3);
        return STD_MOVES[moveInt];
    }


}
