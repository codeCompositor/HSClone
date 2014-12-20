import java.util.LinkedList;

/**
 * Created by user on 14.12.2014.
 */
public class ActionSample {
    public Card thisCard;
    public ActionType type;
    public LinkedList<CardSample> targets;
    public int value;

    public ActionSample() {
        this.thisCard = new Card();
        this.type = ActionType.NULL;
        this.targets = new LinkedList<>();
        this.value = -1;
    }
}
