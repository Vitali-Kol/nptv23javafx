package org.example.demofx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class NewBookController {

    @FXML
    private VBox vbNewBookFormRoot;

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorsField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField quantityField;

    @FXML
    private TextField inStockField;

    /**
     * Метод, вызываемый при нажатии на кнопку "Добавить".
     * Здесь можно реализовать логику сохранения книги.
     */
    @FXML
    public void create() {
        // Получаем данные из полей формы
        String title = titleField.getText();
        String authors = authorsField.getText();
        String year = yearField.getText();
        String quantity = quantityField.getText();
        String inStock = inStockField.getText();

        // Здесь можно добавить вызов сервиса для сохранения книги в базу данных

        // После обработки закрываем окно, возвращаясь к главной форме
        Stage stage = (Stage) vbNewBookFormRoot.getScene().getWindow();
        stage.close();
    }
}
