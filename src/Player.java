import java.util.ArrayList;

public class Player {

    ArrayList<Card> hand;
    short score;

    public Player() {
        this.score = 0;
        this.hand = new ArrayList<Card>();
    }

    public void setScore() {
        short tempScore = 0;
        for (Card card : hand) {
            tempScore += card.getValue();
        }
        this.score = tempScore;
    }

    public boolean bust(short score) {
        return score > 21;
    }

}
