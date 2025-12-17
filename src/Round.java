public class Round {

    Player bank = new Player();
    Player player = new Player();
    Deck deck;
    String turn;

    public Round() throws Exception {
        this.deck = new Deck();
        this.turn = "bank";
        for (int i = 0; i < 2; i++) {
            bank.hand.add(deck.drawCard());
            player.hand.add(deck.drawCard());
        }
    }

    public String win() {
        if (bank.bust(bank.getScore())) {
            return "Player won the round!";
        } else if (player.bust(player.getScore())) {
            return "Bank won the round!";
        }
        else {
            return "next card";
        }
    }

    public void play() {
        while (win() == "next card") {
            System.out.println("Bank score: " + bank.getScore() + " | Player score: " + player.getScore());
            if (this.turn == "bank") {
                bank.hand.add(deck.drawCard());
                this.turn = "player";
            } else if (this.turn == "player") {
                player.hand.add(deck.drawCard());
                this.turn = "bank";
            }
        }
    }



}
