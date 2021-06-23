import junit.framework.TestCase;
import org.junit.Test;

/**
 * Class to test Exercise 12.3 Poker Hand
 */
public class PokerHandTest extends TestCase
{
    public void testPokerHand()
    {
        Card[] hand = new Card[9];

        // No flush, no royal flush
        hand[0] = new Card(1, 0);
        hand[1] = new Card(2, 1);
        hand[2] = new Card(3,2);
        hand[3] = new Card(4, 3);

        hand[4] = new Card(5, 0);
        hand[5] = new Card(6, 1);
        hand[6] = new Card(7,2);
        hand[7] = new Card(8, 3);

        hand[8] = new Card(9, 0);

        int[] suitHistogram = Deck.suitHist(hand);

        int[] expectedResult = {3, 2, 2, 2};
        for(int i = 0; i < 4; i++) {
            assertEquals(expectedResult[i], suitHistogram[i]);
        }

        System.out.println("Suit histogram test passes!");

        boolean hasFlush = Deck.hasFlush(hand);
        assertFalse(hasFlush);

        System.out.println("No flush test passes!");

        // Flush
        hand[0] = new Card(1, 1);
        hand[1] = new Card(2, 1);
        hand[2] = new Card(3,1);
        hand[3] = new Card(4, 3);

        hand[4] = new Card(5, 0);
        hand[5] = new Card(6, 1);
        hand[6] = new Card(7,1);
        hand[7] = new Card(8, 3);

        hand[8] = new Card(9, 0);

        hasFlush = Deck.hasFlush(hand);
        assertTrue(hasFlush);

        System.out.println("Has flush test passes!");

        boolean hasRoyal = Deck.hasRoyal(hand);
        assertFalse(hasRoyal);

        System.out.println("No royal flush test passes!");

        // Royal Flush
        hand[0] = new Card(1, 1);
        hand[1] = new Card(13, 1);
        hand[2] = new Card(12,1);
        hand[3] = new Card(11, 1);

        hand[4] = new Card(10, 1);
        hand[5] = new Card(6, 1);
        hand[6] = new Card(7,1);
        hand[7] = new Card(8, 3);

        hand[8] = new Card(9, 0);

        hasRoyal = Deck.hasRoyal(hand);
        assertTrue(hasRoyal);

        System.out.println("Has royal flush test passes!");

    }
}
