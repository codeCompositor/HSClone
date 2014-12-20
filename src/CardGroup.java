/**
 * Created by user on 14.12.2014.
 */
public enum CardGroup {
    ENEMY, FRIENDLY, THIS, NULL;

    public static CardGroup fromString(String str) {
        str = str.toUpperCase();
        switch (str) {
            case "FRIENDLY":
                return FRIENDLY;
            case "ENEMY":
                return ENEMY;
            case "THIS":
                return THIS;
        }
        return NULL;
    }

    public static CardGroup isInGroup(Card thisCard, Card targetCard) {
        if (thisCard == targetCard)
            return THIS;
        if (thisCard.info.player.side == targetCard.info.player.side)
            return FRIENDLY;
        return ENEMY;
    }

    public static boolean isInGroup(CardGroup group, Card thisCard, Card targetCard) {
        return group == NULL || group == FRIENDLY && thisCard.info.player.side == targetCard.info.player.side || group == ENEMY && thisCard.info.player.side != targetCard.info.player.side;
    }
}
