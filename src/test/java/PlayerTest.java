import javafx.scene.image.Image;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

public class PlayerTest {

    @Test
    public void foldACorner(){
        Player player = new Player(0,0,0, new Card(1,1), new Card(1,1), new Card(1,1), new Card(1,1));
        player.foldCorner();

        assertEquals(1, player.getFoldedCorners());
    }

    @Test
    public void playerCreationSetsDisplayValuesCorrectly0DegRotation(){
        Player player = new Player(200, 300, 0, new Card(1,1), new Card(1,1), new Card(1,1), new Card(1,1));

        for(int i = 0; i < 4; i++){
            Card card = (Card)player.getCards().getChildren().get(i);

            assertEquals(300, card.get_card_position_y(),0);
            assertEquals(200 + (Card.CARD_WIDTH + 20) * i, 0);
            assertEquals(0, card.getRotate(), 0);
        }

    }
}
