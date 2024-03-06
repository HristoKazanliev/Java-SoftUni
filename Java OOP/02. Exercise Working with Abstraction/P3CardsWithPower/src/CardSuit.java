public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);
    private int power;
    CardSuit(int power) {
        this.power = power;
    }
    public int getPower() {
        return power;
    }
    public static void printCardSuits() {
        System.out.println("Card Suits:");
        for (CardSuit cardSuit : CardSuit.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s\n", cardSuit.ordinal(), cardSuit);
        }
    }
}
