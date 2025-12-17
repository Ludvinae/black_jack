
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Deck {

    ArrayList<Card> startingDeck = getStartingDeck();
    ArrayList<Card> remainingCards;

    public Deck() throws Exception {
        this.remainingCards = startingDeck;
    }

    public ArrayList<Card> getStartingDeck() throws Exception {
        return Card.generateDeck();
    }

    @Override
    public String toString() {
        return "A deck of " + startingDeck.size() + " cards with " + remainingCards.size() + " cards remaining.";
    }


    public Card drawCard() {
        Card card;
        if (!remainingCards.isEmpty()) {
            int randomIndex = ThreadLocalRandom.current().nextInt(remainingCards.size());
            card = remainingCards.get(randomIndex);
            remainingCards.remove(card);
        }
        else {
            card = null;
        }
        return card;
    }
}
