import javafx.scene.Group;

public class Player {

    private Group cards;
    private int foldedCorners = 0;

    public Player(int x, int y, double rotate,Card card1, Card card2, Card card3, Card card4 ){
        cards = new Group();
        cards.getChildren().clear();

        for(int i = 0; i < 4; i++){
            //cards.getChildren().add(card);
        }
    }

    public int getFoldedCorners(){
        return foldedCorners;
    }

    public int foldCorner(){
        return foldedCorners++;
    }

    public Group getCards(){
        return cards;
    }
}
