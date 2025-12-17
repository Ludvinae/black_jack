
import java.util.ArrayList;
import java.util.List;

public class Card {
    String card;
    String type;
    short value;

    static List<String> validCard = List.of("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
    static List<String> validType = List.of("Diamonds", "Hearts", "Spades", "Clubs");

    public Card(String card, String type) throws Exception {
        setValue(card);
        setType(type);
        this.value = getValue();
    }

    @Override
    public String toString() {
        return card + " of " + type;
    }

    public void setValue(String value) throws Exception {
        if (validCard.contains(value)) {
            this.card = value;
        }
        else {
            throw new Exception("Invalid card value");
        }
    }

    public void setType(String type) throws Exception {
        if (validType.contains(type)) {
            this.type = type;
        }
        else {
            throw new Exception("Invalid card type");
        }
    }

    public short getValue() {
        if (this.card == "J" || this.card == "Q" || this.card == "K") {
            return 10;
        } else if (this.card == "Ace") {
            return 11;
        }
        else {
            return Short.parseShort(this.card);
        }
    }

    public static List<Card> generateDeck() throws Exception {
        ArrayList<Card> deck = new ArrayList<>();
        for (String type : validType) {
            for (String card : validCard) {
                deck.add(new Card(card, type));
            }
        }
        return deck;
    }


}
