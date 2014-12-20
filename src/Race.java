/**
 * Created by Teacher on 11.12.14.
 */
public enum Race {
    DEMON, NULL;

    public static Race fromString(String str) {
        str = str.toUpperCase();
        switch (str) {
            case "DEMON":
                return DEMON;
        }
        return NULL;
    }
}
