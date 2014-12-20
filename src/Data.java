import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by 10b on 11.12.14.
 */
public class Data {
    public String ID;
    public Type type;
    public String name;
    public Faction faction;
    public Rarity rarity;
    public int attack;
    public int health;
    public String flavor;
    public Class playerClass;
    public Race race;
    public int cost;
    public Zone zone;
    public int zoneID;
    public Player player;
    public CardGroup group;
    public LinkedList<Reaction> reactions;

    public Data() {
        ID = null;
        type = Type.NULL;
        name = null;
        faction = Faction.NULL;
        rarity = Rarity.NULL;
        attack = -1;
        health = -1;
        flavor = null;
        playerClass = Class.NULL;
        race = Race.NULL;
        cost = -1;
        zone = Zone.NULL;
        zoneID = -1;
        player = new Player();
        group = CardGroup.NULL;
        reactions = new LinkedList<>();
    }

    public static ArrayList<Data> readCards(String path) throws IOException {
        ArrayList<Data> result = new ArrayList<>();
        ArrayList<String> args = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(path));
        int c = 0;
        char ch;
        String str = "", function = null;
        int state = 0;

        while ((c = in.read()) != -1) {
            ch = (char) c;
            switch (state) {
                case 0:
                    if (ch == '[') {
                        state = 1;
                    }
                    break;

                case 1:
                    if (ch == ':') {
                        state = 2;
                        function = str;
                        str = "";
                        break;
                    }
                    str += ch;
                    break;

                case 2:
                    switch (ch) {
                        case ']':
                            if (function.toUpperCase().equals("CARD")) {
                                result.add(new Data());
                            }
                            state = 0;
                            args.clear();

                        case ':':
                            args.add(str);
                            str = "";

                            result.get(result.size() - 1).addParameter(function, args);
                            break;

                        default:
                            str += ch;
                            break;
                    }
                    break;
            }
        }
        return result;
    }

    public void addParameter(String function, ArrayList<String> args) {
        function = function.toUpperCase();
        if (function.substring(0, 1).equals("R_")) {
            reactions.getLast().addParameter(function.substring(2), args);
        }
        switch (function) {
            case "CARD":
                ID = args.get(0);
                break;
            case "NAME":
                name = args.get(0);
                break;
            case "TYPE":
                type = Type.fromString(args.get(0));
                break;
            case "FACTION":
                faction = Faction.fromString(args.get(0));
                break;
            case "RARITY":
                rarity = Rarity.fromString(args.get(0));
                break;
            case "COST":
                cost = Integer.parseInt(args.get(0));
                break;
            case "ATTACK":
                attack = Integer.parseInt(args.get(0));
                break;
            case "HEALTH":
                health = Integer.parseInt(args.get(0));
                break;
            case "CLASS":
                playerClass = Class.fromString(args.get(0));
                break;
            case "FLAVOR":
                flavor = args.get(0);
                break;
            case "BONUS":
                if (new Random().nextInt(Integer.parseInt(args.get(0))) == 0)
                    flavor = args.get(1);
                break;
            case "RACE":
                race = Race.fromString(args.get(0));
                break;
            case "REACTION":
                reactions.add(new Reaction());
                reactions.getLast().addParameter(function, args);
                break;
        }
    }

    public boolean equals(Data data) {
        return (ID == null || ID.equals(data.ID)) && (name == null || name.equals(data.name)) &&
                (flavor == null || flavor.equals(data.flavor)) && (type == Type.NULL || type == data.type) &&
                (faction == Faction.NULL || faction == data.faction) && (rarity == Rarity.NULL || rarity == data.rarity) &&
                (playerClass == Class.NULL || playerClass == data.playerClass) && (race == Race.NULL || race == data.race) &&
                (zone == Zone.NULL || zone == data.zone) && (attack == -1 || attack == data.attack) &&
                (health == -1 || health == data.health) && (cost == -1 || cost == data.cost) &&
                (zoneID == -1 || zoneID == data.zoneID);
    }
}
