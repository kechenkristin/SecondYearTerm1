/**
 * The Card class for the game
 * Each card has a value( positive Integer)
 * Thread safe
 * @version 1.0
 * @author Kechen Liu Heegon Kim
 */
public class Card {

    // fields
    /**
     * value of the card
     */
    private Integer val;

    // constructors
    public Card(Integer val) {
        this.val = val;
    }


    // getters and setters
    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

}
