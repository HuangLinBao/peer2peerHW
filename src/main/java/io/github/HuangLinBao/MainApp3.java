package io.github.HuangLinBao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class MainApp3 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/io.github.HuangLinBao/scene.fxml")));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/io.github.HuangLinBao/style.css")).toExternalForm());

        stage.setTitle("ClientChat");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) throws IOException {

//        ServerThread sv = new ServerThread("192.168.122.251");
//        sv.run();
//        ClientThread ct = new ClientThread("fuck","192.168.122.251");
//        ct.send();
//        ct.closeSocket();
        launch(args);
    }

}