
public class PlayerFactory {

    public Player createPlayer1(Card... cards){
        return new Player(625, 700, 0, cards);
    }

    public Player createPlayer2(Card... cards){
        return new Player(300, 150, 90, cards);
    }

    public Player createPlayer3(Card... cards){
        return new Player(625, 50, 180, cards);
    }

    public Player createPlayer4(Card... cards){
        return new Player(1450, 150, 270, cards);
    }
}
