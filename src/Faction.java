/**
 * Created by 10b on 11.12.14.
 */
public enum Faction {
    NEUTRAL, NULL;

    public static Faction fromString(String str) {
        str = str.toUpperCase();
        switch (str) {
            case "NEUTRAL":
                return NEUTRAL;
        }
        return NULL;
    }
}
