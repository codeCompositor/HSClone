/**
 * Created by 10b on 11.12.14.
 */
public class Card {
    public Data data;
    public Data info;

    public Card() {
        this.data = new Data();
        this.info = new Data();
    }

    public void reaction(TriggerType type, Action action) {
        for (Reaction reaction : info.reactions) {
            reaction.reaction(type, action);
        }
    }
}
