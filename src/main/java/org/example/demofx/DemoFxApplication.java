package org.example.nptv23javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.demofx.tools.SpringFXMLLoader;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "org.example.nptv23javafx",
        "org.example.demofx.controller",
        "org.example.demofx.tools"
})
public class DemoFxApplication extends Application {

    // Сделаем поле статическим
    public static Stage primaryStage;

    private ConfigurableApplicationContext springContext;
    private Parent rootNode;

    public static void main(String[] args) {
        Application.launch(DemoFxApplication.class, args);
    }

    @Override
    public void init() throws Exception {
        springContext = new SpringApplicationBuilder(DemoFxApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));

        SpringFXMLLoader springFXMLLoader = springContext.getBean(SpringFXMLLoader.class);
        FXMLLoader fxmlLoader = springFXMLLoader.load("/main/mainForm.fxml");
        rootNode = fxmlLoader.load();
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Присваиваем статическое поле
        primaryStage = stage;
        Scene scene = new Scene(rootNode, 600, 400);
        stage.setScene(scene);
        stage.setTitle("nptv23javafx библиотека");
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        springContext.close();
        Platform.exit();
    }
}
