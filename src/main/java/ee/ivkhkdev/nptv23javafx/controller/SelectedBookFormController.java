package ee.ivkhkdev.nptv23javafx.controller;

import ee.ivkhkdev.nptv23javafx.model.entity.Book;
import org.springframework.stereotype.Component; // Важно, чтобы Spring видел этот класс
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.stream.Collectors;

@Component
public class SelectedBookFormController {

    @FXML
    private Label titleLabel;

    @FXML
    private Label authorsLabel;

    @FXML
    private Label publicationYearLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label countLabel;

    @FXML
    private Button readBookButton;

    @FXML
    private Button returnBookButton;

    private Book selectedBook;

    /**
     * Метод вызывается извне (FormService), чтобы передать выбранную книгу.
     */
    public void setBook(Book book) {
        this.selectedBook = book;
        if (book != null) {
            // Название
            titleLabel.setText(book.getTitle());
            // Авторы
            String authorsStr = book.getAuthors().stream()
                    .map(a -> a.getFirstname() + " " + a.getLastname())
                    .collect(Collectors.joining(", "));
            authorsLabel.setText(authorsStr);
            // Год, количество, в наличии
            publicationYearLabel.setText(String.valueOf(book.getPublicationYear()));
            quantityLabel.setText(String.valueOf(book.getQuantity()));
            countLabel.setText(String.valueOf(book.getCount()));
        }
    }

    @FXML
    private void handleReadBook() {
        if (selectedBook != null) {
            System.out.println("Читать книгу: " + selectedBook.getTitle());
            // Здесь ваша логика (открытие текста, PDF и т.п.)
        }
    }

    @FXML
    private void handleReturnBook() {
        if (selectedBook != null) {
            System.out.println("Вернуть книгу: " + selectedBook.getTitle());
            // Логика возврата (например, увеличить count и сохранить в БД)
        }
    }
}
    