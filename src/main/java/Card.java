package main.java;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card extends ImageView {
    int card_rank;
    int card_suit;

    Image card_faceup_image;

    //  face-up   =  card suit and rank are visible
    //  face-down =  card suit and rank are not visible

    //  boolean  this_card_is_face_up  =  false ;

    //  The following static data fields can be accessed from
    //  other classes by writing Card.HEARTS, Card.DIAMONDS, etc.

    public static final int HEARTS = 1;
    public static final int DIAMONDS = 2;
    public static final int SPADES = 3;
    public static final int CLUBS = 4;

    public static final int CARD_WIDTH = 150;
    public static final int CARD_HEIGHT = 215;

    public Card(int given_card_rank,
                int given_card_suit) {
        card_rank = given_card_rank;
        card_suit = given_card_suit;

        // A reference to an Image object will be retrieved by using
        // a string as a key. For example, with the string "spades1" the
        // image of the Ace of Spades is found.

        if (card_suit == HEARTS) {
            card_faceup_image = ImageStore.card_face_images.get("hearts" + card_rank);
        } else if (card_suit == DIAMONDS) {
            card_faceup_image = ImageStore.card_face_images.get("diamonds" + card_rank);
        } else if (card_suit == SPADES) {
            card_faceup_image = ImageStore.card_face_images.get("spades" + card_rank);
        } else if (card_suit == CLUBS) {
            card_faceup_image = ImageStore.card_face_images.get("clubs" + card_rank);
        }

        setImage(ImageStore.card_back_image); // Initially the card is face-down
    }

    public int get_rank() {
        return card_rank;
    }

    public int get_suit() {
        return card_suit;
    }

    public void turn_card() {
        if (getImage() == card_faceup_image) {
            setImage(ImageStore.card_back_image);
        } else {
            setImage(card_faceup_image);
        }
    }

    public void turn_card_face_up() {
        setImage(card_faceup_image);
    }

    public void turn_card_face_down() {
        setImage(ImageStore.card_back_image);
    }

    public boolean card_is_face_up() {
        return (getImage() == card_faceup_image);
    }

    public boolean card_is_face_down() {
        return (getImage() != card_faceup_image);
    }

    public void set_card_position(double given_position_x,
                                  double given_position_y) {
        setX(given_position_x);
        setY(given_position_y);
    }

    public double get_card_position_x() {
        return getX();
    }

    public double get_card_position_y() {
        return getY();
    }

    public String get_suit_as_string() {
        String string_to_return = "";

        switch (card_suit) {
            case HEARTS:
                string_to_return = "Hearts";
                break;
            case DIAMONDS:
                string_to_return = "Diamonds";
                break;
            case SPADES:
                string_to_return = "Spades";
                break;
            case CLUBS:
                string_to_return = "Clubs";
                break;
            default:
                string_to_return = "Program error!!!";
        }

        return string_to_return;
    }

    // With the following methods it is possible to compare
    // "this" card to anohter card.

    // Making general comparisons between cards is somewhat
    // difficult as different card games value cards in
    // different ways. All the following methods are not
    // suitable for all card games. One known problem is that
    // an Ace is considered the smallest card by the methods.

    public boolean belongs_to_suit_of(Card another_card) {
        return (card_suit == another_card.card_suit);
    }

    public boolean does_not_belong_to_suit_of(Card another_card) {
        return (card_suit != another_card.card_suit);
    }

    public boolean is_smaller_than(Card another_card) {
        return (card_rank < another_card.card_rank);
    }

    public boolean is_greater_than(Card another_card) {
        return (card_rank > another_card.card_rank);
    }

    public boolean has_equal_rank_as(Card another_card) {
        return (card_rank == another_card.card_rank);
    }

    public boolean has_different_rank_as(Card another_card) {
        return (card_rank != another_card.card_rank);
    }

    public boolean contains_point(double given_point_x,
                                  double given_point_y) {
        // We'll think here that if a Card's position is ( 0, 0 )
        // then no real position has been set, i.e., the Card
        // has not yet been put to the 'table'.

        return (getX() != 0 && getY() != 0 &&
                given_point_x >= getX() &&
                given_point_x <= getX() + CARD_WIDTH &&
                given_point_y >= getY() &&
                given_point_y <= getY() + CARD_HEIGHT);
    }
}



