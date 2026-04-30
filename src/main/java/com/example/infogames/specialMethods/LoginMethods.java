package com.example.infogames.specialMethods;

import com.example.infogames.globalEntity.GlobalJSONLogin;
import com.example.infogames.listView.ListMessage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Objects;

public class LoginMethods {
    public static void saveInfoToLogin(Button button, String path,
                                                   TextField inputLogin,
                                                   TextField inputPassword,
                                                   Label labelError){
        button.setOnAction(event -> {
            if(Objects.equals(inputLogin.getText(), "") || Objects.equals(inputPassword.getText(), "")){
                labelError.setText(ListMessage.formNotFull);
                labelError.setVisible(true);
            } else {
                GlobalJSONLogin.globalLogin.setLogin(inputLogin.getText());
                GlobalJSONLogin.globalLogin.setPassword(inputPassword.getText());
                GlobalJSONLogin.sendJSON(button, path, labelError);
            }
        });
    }
}
