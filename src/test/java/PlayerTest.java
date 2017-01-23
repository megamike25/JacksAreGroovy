import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void foldACorner(){
        ImageStore.loadImages();
        Player player = new Player(0,0,0, new Card(1,1), new Card(1,1), new Card(1,1), new Card(1,1));
        player.foldCorner();

        assertEquals(1, player.getFoldedCorners());
    }

    @Test
    public void playerCreationSetsDisplayValuesCorrectly0DegRotation(){
        Player player = new Player(200, 300, 0,new Card(1,1), new Card(1,1), new Card(1,1), new Card(1,1) );

        for(int i = 0; i < 4; i++){
            Card card = (Card)player.getCards().getChildren().get(i);
            assertEquals(300, card.get_card_position_y(),0);
            assertEquals(200 + (Card.CARD_WIDTH + 20) * i, card.get_card_position_x(),0);
            assertEquals(0, card.getRotate(), 0);
        }

    }
}
