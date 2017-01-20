package main.java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;

public class PlayingCardsFX extends Application {
    CardDeck card_deck;

    // A StackPane will be the root pane for all visible things on the screen.

    StackPane root_stack = new StackPane();

    Text initial_instructions = new Text("CLICK THE CARDS AFTER DEALING.");

    Group row_of_cards = new Group();

    Group group_for_lonesome_card = new Group();

    Card lonesome_card;

    Card selected_card;


    public void start(Stage stage) {
        stage.setTitle("PlayingCardsFX.java");

        //  The files that contain card face images have
        //  names such as hearts1.png, hearts2.png, hearts3.png, etc.
        //  They are located in a folder named playing_cards_images.
        //  Next we'll programmatically create the file names and
        //  corresponding Image objects.

        //  The Image objects will be stored in a data structure called
        //  HashMap so that the file name body can be used as a key
        //  to get references to the Image objects.

        ImageStore.card_back_image = new Image(
                "playing_cards_images/card_back.png");


        ImageStore.card_face_images = new HashMap<String, Image>();

        String[] words_in_image_file_names = {"hearts", "diamonds",
                "spades", "clubs"};

        for (int suit_index = 0;
             suit_index < 4;
             suit_index++) {
            for (int card_rank = 1;
                 card_rank < 14;
                 card_rank++) {
                String image_file_name = "playing_cards_images/"
                        + words_in_image_file_names[suit_index]
                        + card_rank
                        + ".png";

                Image card_faceup_image = new Image(image_file_name);


                String key_for_image = words_in_image_file_names[suit_index]
                        + card_rank;

                ImageStore.card_face_images.put(key_for_image, card_faceup_image);
            }
        }

        // Now, that we have loaded the card images, we can create the deck.

        card_deck = new CardDeck();


        // Next, we'll create two buttons and specify the actions that
        // will be performed when the buttons are pressed.

        Button button_to_deal_cards = new Button("DEAL");
        Button button_to_shuffle_deck = new Button("SHUFFLE");

        button_to_deal_cards.setOnAction((ActionEvent event) ->
        {
            // Before the fist dealing of cards we'll remove the Text
            // from the screen.

            if (initial_instructions != null) {
                root_stack.getChildren().remove(initial_instructions);
                initial_instructions = null;
            }

            //  We'll first empty the list 'inside' the Group

            row_of_cards.getChildren().clear();

            for (int card_index = 0;
                 card_index < 5;
                 card_index++) {
                Card new_card = card_deck.get_card();

                double card_position_x = 40 + (Card.CARD_WIDTH + 20) * card_index;
                double card_position_y = 50;

                new_card.set_card_position(card_position_x, card_position_y);

                row_of_cards.getChildren().add(new_card);
            }

            lonesome_card = card_deck.get_card();
            lonesome_card.set_card_position(188, 300);

            group_for_lonesome_card.getChildren().clear();
            group_for_lonesome_card.getChildren().add(lonesome_card);
        });

        button_to_shuffle_deck.setOnAction((ActionEvent event) ->
        {
            card_deck.shuffle();
        });


        HBox pane_for_buttons = new HBox(16); // space between buttons is 16

        pane_for_buttons.getChildren().addAll(button_to_deal_cards,
                button_to_shuffle_deck);

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

        main_group_for_cards.getChildren().addAll(row_of_cards,
                group_for_lonesome_card);

        initial_instructions.setFont(new Font(24));

        root_stack.getChildren().addAll(border_pane,
                main_group_for_cards,
                initial_instructions);

        Scene scene = new Scene(root_stack, 1910, 1000);

        scene.setOnMouseClicked((MouseEvent event) ->
        {
            double clicked_point_x = event.getSceneX();
            double clicked_point_y = event.getSceneY();

            if (row_of_cards.getChildren().size() == 5) {
                for (Node card_as_node : row_of_cards.getChildren()) {
                    Card card_in_row = (Card) card_as_node;

                    if (card_in_row.contains_point(clicked_point_x,
                            clicked_point_y)) {
                        card_in_row.turn_card();

                        //  selected_card will point to the clicked card.
                        //  In this program, however, selected_card is not
                        //  used for any purpose.

                        selected_card = card_in_row;
                    }
                }

                if (lonesome_card != null &&
                        lonesome_card.contains_point(clicked_point_x,
                                clicked_point_y)) {
                    lonesome_card.turn_card();
                }

            }
        });

        // By eliminating the background specifications of the StackPane,
        // we can make the fill of the Scene visible.

        root_stack.setBackground(null);

        scene.setFill(Color.LAWNGREEN);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] command_line_parameters) {
        launch(command_line_parameters);
    }
}


