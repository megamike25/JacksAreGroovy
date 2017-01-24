import java.util.ArrayList;
import java.util.List;

public class Hand {

    private int CARD_LIMIT = 4;

    private List<Card> hand = new ArrayList<>();

    public Card getCard(int position){
        return hand.get(position);
    }

    public List<Card> getAllCards(){
        return hand;
    }

    public void addCards(List<Card> cards){

        if((hand.size() + cards.size()) <= CARD_LIMIT){
            hand.addAll(cards);
        }
    }

    public void addCard(Card card){

        if((hand.size() + 1) <= CARD_LIMIT ){
            hand.add(card);
        }
    }
}
