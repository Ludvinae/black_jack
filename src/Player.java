import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Player {

    ArrayList<Card> hand;
    short score;
    boolean keepHand;

    Scanner playerChoice = new Scanner(System.in);

    public Player() {
        this.score = 0;
        this.hand = new ArrayList<Card>();
        this.keepHand = false;
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

    public StringBuilder displayHand() {
        StringBuilder message = new StringBuilder();
        for (Card card : hand) {
            message.append(card).append(" | ");
        }
        return message;
    }

    public boolean bust(short score) {
        return score > 21;
    }

    public boolean keepPlaying(boolean cpu) {
        if (!cpu) {
            System.out.println("Do you want to draw a card? (Y/n)");
            String answer = playerChoice.nextLine();
            if (Objects.equals(answer, "n") || Objects.equals(answer, "N")) {
                this.keepHand = true;
                return false;
            }
            return true;
        }
        if (getScore() <= 16) {
            return true;
        }
        this.keepHand = true;
        return false;
    }

}
