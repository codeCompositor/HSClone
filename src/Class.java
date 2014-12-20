/**
 * Created by Teacher on 11.12.14.
 */
public enum Class {
    MAGE, WARLOCK, NEUTRAL, NULL;

    public static Class fromString(String str) {
        str = str.toUpperCase();
        switch (str) {
            case "MAGE":
                return MAGE;
            case "WARLOCK":
                return WARLOCK;
        }
        return NEUTRAL;
    }
}
