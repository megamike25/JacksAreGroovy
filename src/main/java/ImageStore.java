package main.java;

import javafx.scene.image.Image;

import java.util.HashMap;

public class ImageStore {

    static Image card_back_image ;

    static HashMap<String, Image> card_face_images ;

    static void loadImages(){

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


        ImageStore.card_face_images = new HashMap<>();

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

    }

}
