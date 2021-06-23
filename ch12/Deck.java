public class Deck {

    public static Card[] makeDeck()
    {
        Card[] newCardDeck = new Card[52];
        int index = 0;
        for (int suit = 0; suit < 4; suit ++)
        {
            for (int rank = 1; rank < 14; rank++)
            {
                newCardDeck[index++] = new Card(rank, suit);
            }
        }
        return newCardDeck;
    }

    public static int[] suitHist(Card[] hand)
    {
        int[] suitHistogram = new int[4];
        for (Card card: hand)
        {
            suitHistogram[card.getSuit()]++;
        }
        return suitHistogram;
    }

    public static boolean hasFlush(Card[] hand)
    {
        int[] suitHistogram = suitHist(hand);
        for (int count : suitHistogram)
        {
            if (count >= 5) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasRoyal(Card[] hand)
    {
        int[] suitHistogram = suitHist(hand);
        for (int suit = 0; suit < 4; suit++)
        {
            int count = suitHistogram[suit];
            if (count >= 5) {
                int numRoyalCards = 0;
                for (Card card: hand)
                {
                    if (card.getSuit() == suit
                            && (card.getRank() >= 10 || card.getRank() == 1))
                    {
                        numRoyalCards++;
                    }
                }
                if (numRoyalCards >= 5)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Card[] deck = makeDeck();
    }
}
