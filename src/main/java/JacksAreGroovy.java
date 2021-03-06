import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JacksAreGroovy extends Application {
    Game game = new Game();

    // A StackPane will be the root pane for all visible things on the screen.

    StackPane root_stack = new StackPane();

    Group player1Cards = new Group();
    Group player2Cards = new Group();
    Group player3Cards = new Group();
    Group player4Cards = new Group();

    Group drawCards = new Group();
    Group discardCards = new Group();

    Card drawCard;
    Card discardCard;

    Card selected_card;

    public void start(Stage stage) {
        stage.setTitle("JACKS ARE GROOVY!");

        ImageStore.loadImages();

        Button button_to_deal_cards = new Button("START GAME");

        HBox pane_for_buttons = new HBox(16); // space between buttons is 16

        pane_for_buttons.getChildren().addAll(button_to_deal_cards);

        pane_for_buttons.setAlignment(Pos.CENTER); // The Box is centered
        // With an Insets object we can specify empty space around the HBox.
        // There will be 20 pixels padding below the HBox.
        pane_for_buttons.setPadding(new Insets(0, 0, 20, 0));

        BorderPane border_pane = new BorderPane();

        border_pane.setBottom(pane_for_buttons);

        Group main_group_for_cards = new Group();

        // With the following statement we disable the automatic layout
        // management of the Card objects.
        main_group_for_cards.setManaged(false);

        main_group_for_cards.getChildren().addAll(player1Cards, player2Cards, player3Cards, player4Cards,
                drawCards, discardCards);

        initial_instructions.setFont(new Font(24));

        root_stack.getChildren().addAll(border_pane,
                main_group_for_cards,
                initial_instructions);

        Scene scene = new Scene(root_stack, 1910, 1000);

        // By eliminating the background specifications of the StackPane,
        // we can make the fill of the Scene visible.

        root_stack.setBackground(null);

        scene.setFill(Color.LAWNGREEN);

        stage.setScene(scene);
        stage.show();

        scene.setOnMouseClicked((MouseEvent event) ->
        {
            double clicked_point_x = event.getSceneX();
            double clicked_point_y = event.getSceneY();


            for (Node card_as_node : player1Cards.getChildren()) {
                Card card_in_row = (Card) card_as_node;

                if (card_in_row.contains_point(clicked_point_x,
                        clicked_point_y)) {
                    card_in_row.turn_card();

                    selected_card = card_in_row;
                }
            }

            if (drawCard != null &&
                    drawCard.contains_point(clicked_point_x,
                            clicked_point_y)) {
                drawCard.turn_card();
            }

            if (discardCard != null &&
                    discardCard.contains_point(clicked_point_x,
                            clicked_point_y)) {
                discardCard.turn_card();
            }
        });

        button_to_deal_cards.setOnAction((ActionEvent event) ->
        {
            // Before the fist dealing of cards we'll remove the Text
            // from the screen.

            if (initial_instructions != null) {
                root_stack.getChildren().remove(initial_instructions);
                button_to_deal_cards.managedProperty().bind(button_to_deal_cards.visibleProperty());
                button_to_deal_cards.setVisible(false);
                initial_instructions = null;
            }

            player1Cards.getChildren().clear();
            player1Cards.getChildren().addAll(game.getPlayerOneHand().getAllCards());

            player2Cards.getChildren().clear();
            player2Cards.getChildren().addAll(game.getPlayerTwoHand().getAllCards());

            player3Cards.getChildren().clear();
            player3Cards.getChildren().addAll(game.getPlayerThreeHand().getAllCards());

            player4Cards.getChildren().clear();
            player4Cards.getChildren().addAll(game.getPlayerFourHand().getAllCards());

            drawCard = game.drawCard();
            drawCard.set_card_position(750, 350);
            drawCards.getChildren().clear();
            drawCards.getChildren().add(drawCard);

            discardCard = game.getDiscardCard();
            discardCard.set_card_position(1000, 350);
            discardCards.getChildren().clear();
            discardCards.getChildren().add(discardCard);
            discardCard.turn_card();
        });
    }

    public static void main(String[] command_line_parameters) {
        launch(command_line_parameters);
    }

    private final String HOW_TO_PLAY = "test sting\ntest";
    Text initial_instructions = new Text(HOW_TO_PLAY);
}


