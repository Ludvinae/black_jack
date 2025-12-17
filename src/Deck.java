
import java.util.ArrayList;


public class Deck {


    ArrayList<Card> remainingCards;

    public Deck() throws Exception {
        this.remainingCards = getStartingDeck();
    }

    public ArrayList<Card> getStartingDeck() throws Exception {
        return Card.generateDeck();
    }


}
