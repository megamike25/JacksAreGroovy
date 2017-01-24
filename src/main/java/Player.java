
public class Player {

    private Hand hand;
    private int foldedCorners = 0;
    private int x,y;
    private double rotate;

    public Player(int x, int y, double rotate, Card... cards){
        this.x = x;
        this.y = y;
        this.rotate = rotate;

        hand = new Hand();

        for(int i = 0; i < cards.length; i++){
            hand.addCard(transformCardDisplay(cards[i], i));
        }
    }

    public int getFoldedCorners(){
        return foldedCorners;
    }

    public int foldCorner(){
        return foldedCorners++;
    }

    public Hand getHand(){
        return hand;
    }

    private Card transformCardDisplay(Card card, int position){
        if(rotate == 0 || rotate == 180){
            card.setX(x + (Card.CARD_WIDTH + 20) * position);
            card.setY(y);
            card.setRotate(rotate);
        }else if( rotate == 90 || rotate == 270){
            card.setX(x);
            card.setY(y  + (Card.CARD_WIDTH + 20) * position);
            card.setRotate(rotate);
        }

        return card;
    }
}
