/**
 * Player class stores user information
 */
public class Player {
    private String name;
    private int age;
    private float money;

    /**
     * default constructor for guests
     */
    public Player() {
        this.name = "Player";
        this.age = 0;
        this.money = 0;
    }

    /**
     * Basic constructor to setup custom player info
     */
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.money = 0;
    }


}
