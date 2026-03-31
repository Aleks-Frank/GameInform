package com.example.infogames.specialMethods;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SwitchImage {

    private static final Image imageCloseDark = new Image(SwitchImage.class.getResourceAsStream("/image/close_image/button-close-dark.png"));
    private static final Image imageClose = new Image(SwitchImage.class.getResourceAsStream("/image/close_image/button-close.png"));

    public static void setCloseImage(ImageView image, Button button){
        image.setOnMouseEntered(event -> image.setImage(imageCloseDark));
    }

}
