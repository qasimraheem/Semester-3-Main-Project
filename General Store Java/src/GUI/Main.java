package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Point of Sale");
        primaryStage.setScene(new Scene(root, 1368, 695));
        primaryStage.getIcons().add(new Image("file:///C:/Users/qasim/Desktop/Semester-3-Main-Project/General%20Store%20Java/src/GUI/images/icon.png"));
//        stage.getIcons().add(new Image(<yourclassname>.class.getResourceAsStream("icon.png")));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
