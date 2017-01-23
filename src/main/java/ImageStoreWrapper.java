import javafx.scene.image.Image;

public class ImageStoreWrapper {

    public ImageStoreWrapper(){

        ImageStore.loadImages();
    }

    public Image getFaceImage(String imageName){
        return ImageStore.card_face_images.get(imageName);
    }

    public Image getBackImage(){
        return ImageStore.card_back_image;
    }
}
