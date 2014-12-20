/**
 * Created by 10b on 11.12.14.
 */
public enum Rarity {
    LEGENDARY, NULL;

    public static Rarity fromString(String str) {
        str = str.toUpperCase();
        switch (str) {
            case "LEGENDARY":
                return LEGENDARY;
        }
        return NULL;
    }
}
