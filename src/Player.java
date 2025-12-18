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
            tempScore += card.getValue(false);
        }
        short loopCount = 1;
        while (tempScore > 21) {
            short counter = 0;
            tempScore = 0;
            boolean exceed = true;
            for (Card card : hand) {
                tempScore += card.getValue(exceed);
                System.out.println(tempScore);
                if (card.card == "Ace" && (counter >= loopCount)) {
                    counter += 1;
                    exceed = false;
                }
            }
            if (loopCount > hand.size()) {
                break;
            }
            loopCount += 1;
        }
        this.score = tempScore;
    }

    public short getScore() {
        return this.score;
    }

    public void draw(Deck deck) {
        Card card = deck.drawCard();
        System.out.println("Drew a card: " + card);
        this.hand.add(card);
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
            if (this.getScore() == 21) {
                this.keepHand = true;
                System.out.println("BlackJack !");
                return false;
            }
            System.out.println("Do you want to draw a card? (Y/n)");
            String answer = playerChoice.nextLine();
            if (Objects.equals(answer, "n") || Objects.equals(answer, "N")) {
                this.keepHand = true;
                return false;
            }
            return true;
        }
        if (this.getScore() == 21) {
            this.keepHand = true;
            return false;
        }
        else if (this.getScore() <= 16) {
            return true;
        }
        this.keepHand = true;
        return false;
    }

}
