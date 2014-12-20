import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Helga on 12.12.14.
 */
public class Trigger {
    public Card thisCard;
    public ActionType actionType;
    public TriggerType type;
    public LinkedList<Data> targets;
    public LinkedList<Data> makers;
    public LinkedList<Integer> values;

    public Trigger() {
        thisCard = new Card();
        actionType = ActionType.NULL;
        type = TriggerType.NULL;
        targets = new LinkedList<>();
        makers = new LinkedList<>();
        values = new LinkedList<>();
    }

    public boolean trigger(TriggerType type, Action action) {
        boolean temp;

        if (!(this.type == TriggerType.NULL || this.type == type))
            return false;
        if (!(actionType == ActionType.NULL || actionType == action.type))
            return false;

        for (Data triggerTarget : targets) {
            temp = false;
            for (Card targetCard : action.targets) {
                if (CardGroup.isInGroup(triggerTarget.group, thisCard, targetCard) && triggerTarget.equals(targetCard.info)) {
                    temp = true;
                    break;
                }
            }
            if (!temp)
                return false;
        }

        temp = makers.isEmpty();
        for (Data triggerMaker : makers) {
            if (CardGroup.isInGroup(triggerMaker.group, thisCard, action.maker) && triggerMaker.equals(action.maker.info)) {
                temp = true;
                break;
            }
        }
        if (!temp)
            return false;

        temp = values.isEmpty();
        for (int value : values) {
            if (value == action.value) {
                temp = true;
                break;
            }
        }
        return temp;
    }


    public void addParameter(String function, ArrayList<String> args) {
        function = function.toUpperCase();
        if (function.substring(0, 1).equals("T_")) {
            targets.getLast().addParameter(function.substring(2), args);
        }
        if (function.substring(0, 1).equals("M_")) {
            makers.getLast().addParameter(function.substring(2), args);
        }
        switch (function) {
            case "TRIGGER":
                if (args.size() > 0) {
                    type = TriggerType.fromString(args.get(0));
                }
                if (args.size() > 1) {
                    actionType = ActionType.fromString(args.get(1));
                }
                break;
            case "TYPE":
                type = TriggerType.fromString(args.get(0));
                break;
            case "ACTION":
                actionType = ActionType.fromString(args.get(0));
                break;
            case "TARGET":
                targets.add(new Data());
                break;
            case "MAKER":
                makers.add(new Data());
                break;
            default:
        }
    }
}