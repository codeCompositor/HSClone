import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Helga on 12.12.14.
 */
public class Reaction {
    public LinkedList<Trigger> triggers;
    public LinkedList<CardAction> actions;


    public Reaction() {
        this.triggers = new LinkedList<>();
        this.actions = new LinkedList<>();
    }

    public void addParameter(String function, ArrayList<String> args) {
        function = function.toUpperCase();
        switch (function.substring(0, 1)) {
            case "T_":
                triggers.getLast().addParameter(function.substring(2), args);
                break;

            case "A_":
                actions.getLast().addParameter(function.substring(2), args);
        }

        switch (function) {
            case "REACTION":
                break;

            case "TRIGGER":
                triggers.add(new Trigger());
                triggers.getLast().addParameter(function, args);
                break;

            case "ACTION":
                actions.add(new CardAction());
                actions.getLast().addParameter(function, args);
                break;
        }
    }

    public void reaction(TriggerType type, Action action) {
        for (Trigger trigger : triggers) {
            if (trigger.trigger(type, action)) {
                for (CardAction cardAction : actions) {
                    cardAction.action();
                }
            }
        }
    }
}
