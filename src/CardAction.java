import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Helga on 17.12.14.
 */
public class CardAction {
    public Card thisCard;
    public ActionType type;
    public LinkedList<Data> targets;
    public int value;

    public CardAction() {
        thisCard = new Card();
        type = ActionType.NULL;
        targets = new LinkedList<>();
        value = -1;
    }

    public void action() {
        Action res = new Action();
        res.maker = thisCard;
        res.type = type;
        res.value = value;

        for (Data actionTarget : targets) {
            for (Card targetCard : Main.cards) {
                if (CardGroup.isInGroup(actionTarget.group, thisCard, targetCard) && actionTarget.equals(targetCard.info)) {
                    res.targets.add(targetCard);
                }
            }
        }

        Main.makeAction(res);
    }


    public void addParameter(String function, ArrayList<String> args) {
        function = function.toUpperCase();
        if (function.substring(0, 1).equals("T_")) {
            targets.getLast().addParameter(function.substring(2), args);
        }
        switch (function) {
            case "ACTION":
                if (args.size() > 0) {
                    type = ActionType.fromString(args.get(0));
                }
                break;
            case "TYPE":
                type = ActionType.fromString(args.get(0));
                break;
            case "TARGET":
                targets.add(new Data());
                break;
            default:
        }
    }
}
