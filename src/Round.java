public class Round {

    Player bank = new Player();
    Player player = new Player();
    Deck deck;
    String turn;

    public Round() throws Exception {
        this.deck = new Deck();
        this.turn = "player";
        for (int i = 0; i < 2; i++) {
            bank.draw(deck);
            player.draw(deck);
        }
    }

    public String win() {
        if (bank.bust(bank.getScore())) {
            return "Player won the round!";
        } else if (player.bust(player.getScore())) {
            return "Bank won the round!";
        }
        else {
            if (bank.keepHand && player.keepHand) {
                if (player.getScore() > bank.getScore()) {
                    return "Player won the round!";
                }
                else {
                    return "Bank won the round!";
                }
            }
            return "next card";
        }
    }

    @Override
    public String toString() {
        return "Bank score: " + bank.getScore() + " | Player score: " + player.getScore();
    }

    public void play() {
        while (win() == "next card" && (!bank.keepHand || !player.keepHand)) {
            System.out.println(this);
            if (this.turn == "bank") {
                System.out.println("Bank hand: " + bank.displayHand());
                if (player.keepHand && !bank.keepHand && (player.score > bank.score) && !player.bust(player.getScore())) {
                    bank.draw(deck);
                }
                else if (!bank.keepHand && bank.keepPlaying(true)) {
                    bank.draw(deck);
                }
                this.turn = "player";
            } else if (this.turn == "player") {
                System.out.println("Player hand: " + player.displayHand());
                if (!player.keepHand && player.keepPlaying(false)) {
                    player.draw(deck);
                }
                this.turn = "bank";
            }
        }
        System.out.println(this);
        System.out.println(win());
    }



}
