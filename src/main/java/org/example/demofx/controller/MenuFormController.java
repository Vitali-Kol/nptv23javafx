package org.example.demofx.controller;

import org.example.demofx.tools.SpringFXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.nptv23javafx.DemoFxApplication;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MenuFormController {

    @FXML
    private VBox vbMenuFormRoot;

    private final SpringFXMLLoader springFXMLLoader;

    public MenuFormController(SpringFXMLLoader springFXMLLoader) {
        this.springFXMLLoader = springFXMLLoader;
    }

    @FXML
    public void showBookForm(ActionEvent event) throws IOException {
        // Изменили путь на "/newbook/NewBookForm.fxml"
        FXMLLoader fxmlLoader = springFXMLLoader.load("/newbook/NewBookForm.fxml");
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Добавить книгу");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(getPrimaryStage());
        stage.showAndWait();
    }

    @FXML
    public void showAuthorForm(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = springFXMLLoader.load("/author/AuthorForm.fxml");
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Добавить автора");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(getPrimaryStage());
        stage.showAndWait();
    }

    private Stage getPrimaryStage() {
        return (Stage) vbMenuFormRoot.getScene().getWindow();
    }
}
