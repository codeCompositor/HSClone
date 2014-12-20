/**
 * Created by 10b on 11.12.14.
 */
public enum ActionType {
    BEGIN_TURN, END_TURN, DAMAGE, DESTROY_CARD, PLAY_CARD, DRAW_CARD, SUMMON_MINION, NULL;

    public static ActionType fromString(String str) {
        str = str.toUpperCase();
        switch (str) {
            case "BEGIN_TURN":
                return BEGIN_TURN;
            case "END_TURN":
                return END_TURN;
            case "DAMAGE":
                return DAMAGE;
            case "DESTROY_CARD":
                return DESTROY_CARD;
            case "PLAY_CARD":
                return PLAY_CARD;
            case "DRAW_CARD":
                return DRAW_CARD;
            case "SUMMON_MINION":
                return SUMMON_MINION;
        }
        return NULL;
    }
}
