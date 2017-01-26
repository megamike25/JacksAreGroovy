import java.util.List;

public final class Game {

    private static CardDeck deck;
    private static final int turn = 0;
    private static Card discardCard;
    private static Player playerOne;
    private static Player playerTwo;
    private static Player playerThree;
    private static Player playerFour;


    public Game(){
        deck = new CardDeck();
        deck.shuffle();

        PlayerFactory playerFactory = new PlayerFactory();

        playerOne = playerFactory.createPlayer1(deck.get_card(), deck.get_card(), deck.get_card(), deck.get_card());
        playerTwo = playerFactory.createPlayer2(deck.get_card(), deck.get_card(), deck.get_card(), deck.get_card());
        playerThree =  playerFactory.createPlayer3(deck.get_card(), deck.get_card(), deck.get_card(), deck.get_card());
        playerFour =  playerFactory.createPlayer4(deck.get_card(), deck.get_card(), deck.get_card(), deck.get_card());

        discardCard = deck.get_card();
    }

    public Card drawCard(){
        return deck.get_card();
    }

    public Card getDiscardCard(){
        return discardCard;
    }

    public Hand getPlayerOneHand(){
        return playerOne.getHand();
    }

    public Hand getPlayerTwoHand(){
        return playerTwo.getHand();
    }

    public Hand getPlayerThreeHand(){
        return playerThree.getHand();
    }
    public Hand getPlayerFourHand(){
        return playerFour.getHand();
    }

}
