import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    ArrayList<Card> hand;
    short score;
    boolean keep;

    Scanner playerChoice = new Scanner(System.in);

    public Player() {
        this.score = 0;
        this.hand = new ArrayList<Card>();
        this.keep = false;
    }

    public void setScore() {
        short tempScore = 0;
        for (Card card : hand) {
            tempScore += card.getValue();
        }
        this.score = tempScore;
    }

    public short getScore() {
        return this.score;
    }

    public void draw(Deck deck) {
        this.hand.add(deck.drawCard());
        setScore();
    }

    public boolean bust(short score) {
        return score > 21;
    }

    public boolean keepPlaying(boolean cpu) {
        if (!cpu) {
            System.out.println("Do you want to draw a card? (Y/n)");
            String answer = playerChoice.nextLine();
            if (answer == "n" || answer == "N") {
                return false;
            }
            return true;
        }
        if (getScore() <= 16) {
            return true;
        }
        return false;
    }

}
