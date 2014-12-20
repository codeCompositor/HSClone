/**
 * Created by user on 11.12.2014.
 */
public enum TriggerType {
    BEFORE_ACTION, AFTER_ACTION, NULL;

    public static TriggerType fromString(String str) {
        str = str.toUpperCase();
        switch (str) {
            case "BEFORE_ACTION":
                return BEFORE_ACTION;
            case "AFTER_ACTION":
                return AFTER_ACTION;
        }
        return NULL;
    }
}
