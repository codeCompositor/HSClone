/**
 * Created by 10b on 11.12.14.
 */
public enum Type {
    HERO, MINION, WEAPON, NULL;

    public static Type fromString(String str) {
        str = str.toUpperCase();
        switch (str) {
            case "HERO":
                return HERO;
            case "MINION":
                return MINION;
            case "WEAPON":
                return WEAPON;
        }
        return NULL;
    }

    public boolean equals(Type type) {
        return this == NULL || this == type;
    }
}
