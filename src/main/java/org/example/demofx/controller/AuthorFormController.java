package org.example.demofx.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class AuthorFormController {

    @FXML
    private VBox vbAuthorFormRoot;

    // Метод, вызываемый при нажатии кнопки "Добавить"
    @FXML
    private void create() {

        Stage stage = (Stage) vbAuthorFormRoot.getScene().getWindow();
        stage.close();
    }
}
