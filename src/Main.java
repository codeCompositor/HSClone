import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 10b on 11.12.14.
 */
public class Main {
    public static ArrayList<Data> cardData;
    public static ArrayList<Card> cards;
    public static ArrayList<Action> actionLog;
    public static ArrayList<Player> players;
    public static int currentSide = 0;

    public static void main(String args[]) {
        try {
            cardData = Data.readCards("resources/cards.data");
        } catch (IOException e) {
            e.printStackTrace();
//            System.out.println("File not found!");
            return;
        }

        Card card = new Card();
        card.info = card.data = cardData.get(0);

        Player player = new Player();
        player.side = 0;
        player.hero = card;
    }

    public static void addCard(Card card, Zone zone, Player player) {
        switch (zone) {
            case HAND:
                player.hand.add(card);
                cards.add(card);
                break;
        }
    }

    public static void makeAction(Action action) {
//        for (Card card : play) {
//            card.reaction(ReactionType.BEFORE_ACTION, action);
//        }
//        for (Card card : hand) {
//            card.reaction(ReactionType.BEFORE_ACTION, action);
//        }
//        for (Card card : graveyard) {
//            card.reaction(ReactionType.BEFORE_ACTION, action);
//        }
//        for (Card card : deck) {
//            card.reaction(ReactionType.BEFORE_ACTION, action);
//        }
        for (Card card : cards)
            card.reaction(TriggerType.BEFORE_ACTION, action);
        switch (action.type) {
            case BEGIN_TURN:
                for (Player player : players) {
                    if (player.side == currentSide) {

                    }
                }
        }
    }
}