
public class PlayerFactory {

    public Player createPlayer1(Card... cards){
        return new Player(625, 700, 0, cards);
    }
}
