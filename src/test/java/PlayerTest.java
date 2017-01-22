import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void foldACorner(){
        Player player = new Player(0,0,0);
        player.foldCorner();

        assertEquals(1, player.getFoldedCorners());
    }

    @Test
    public void playerCreationSetsDisplayValuesCorrectly0DegRotation(){
        Player player = new Player(200, 300, 0);

        for(int i = 0; i < 4; i++){
            Card card = (Card)player.getCards().getChildren().get(i);
            assertEquals(300, card.get_card_position_y(),0);
        }

    }
}
