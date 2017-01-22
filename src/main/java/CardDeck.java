import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
    static int[] suits = {Card.HEARTS, Card.DIAMONDS,
            Card.SPADES, Card.CLUBS};

    ArrayList<Card> cards_in_this_deck = new ArrayList<Card>();


    public CardDeck() {
        for (int suit_index = 0;
             suit_index < 4;
             suit_index++) {
            for (int card_rank = 1;
                 card_rank < 14;
                 card_rank++) {
                add_card(new Card(card_rank, suits[suit_index]));
            }
        }
    }

    public void shuffle() {
        // The cards in an ArrayList-based dynamic array can be
        // ordered randomly by using the static method shuffle() of
        // the Collections class.

        Collections.shuffle(cards_in_this_deck);
    }

    public void add_card(Card given_card) {
        if (cards_in_this_deck.size() < 52) {
            cards_in_this_deck.add(given_card);
        }
    }

    public Card get_card() {
        //  Value null is returned if there are no available cards
        //  in the deck.

        //  If cards are left in the deck, the last card in the array
        //  is returned, and the returned card is removed from the deck.

        Card card_to_return = null;

        if (cards_in_this_deck.size() > 0) {
            // ArrayList method remove() returns a reference to the
            // object that it removes from the array.

            card_to_return =

                    cards_in_this_deck.remove(cards_in_this_deck.size() - 1);
        }

        return card_to_return;
    }
}



