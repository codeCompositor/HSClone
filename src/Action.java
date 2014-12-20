import java.util.LinkedList;

/**
 * Created by 10b on 11.12.14.
 */
public class Action {
    public ActionType type;
    public LinkedList<Card> targets;
    public Card maker;
    public int value;
    public Player player;

    public Action() {
        this.type = ActionType.NULL;
        this.targets = new LinkedList<>();
        this.maker = null;
        this.value = -1;
        this.player = null;
    }
}
