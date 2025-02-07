package org.example.demofx.tools;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class SpringFXMLLoader {

    private final ApplicationContext context;

    public SpringFXMLLoader(ApplicationContext context) {
        this.context = context;
    }

    public FXMLLoader load(String fxmlPath) {
        // Получаем URL ресурса
        URL location = getClass().getResource(fxmlPath);
        if (location == null) {
            throw new IllegalStateException("FXML file not found at: " + fxmlPath);
        }
        FXMLLoader loader = new FXMLLoader(location);
        loader.setControllerFactory(context::getBean);
        return loader;
    }
}
