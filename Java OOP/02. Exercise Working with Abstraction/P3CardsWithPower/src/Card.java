public class Card {
    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    private int getPower() {
        return this.cardRank.getPower() + this.cardSuit.getPower();
    }

    public void print() {
        System.out.printf("Card name: %s of %s; Card power: %d", cardRank, cardSuit, getPower());
    }
}
