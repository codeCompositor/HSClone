import java.util.ArrayList;

/**
 * Created by 10b on 11.12.14.
 */
public class Player {
    public int side;
    public Card hero;
    public Card weapon;
    public Card heroPower;
    public ArrayList<Card> hand;
    public ArrayList<Card> deck;
    public ArrayList<Card> play;

    public Player() {
        this.side = -1;
        this.hero = new Card();
        this.weapon = new Card();
        this.heroPower = new Card();
        this.hand = new ArrayList<>();
        this.deck = new ArrayList<>();
        this.play = new ArrayList<>();
    }

    public Player(int side, Card hero, Card weapon, Card heroPower, ArrayList<Card> hand, ArrayList<Card> deck, ArrayList<Card> play) {
        this.side = side;
        this.hero = hero;
        this.weapon = weapon;
        this.heroPower = heroPower;
        this.hand = hand;
        this.deck = deck;
        this.play = play;
    }
}
