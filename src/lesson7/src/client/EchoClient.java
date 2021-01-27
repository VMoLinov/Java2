package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class EchoClient extends Application {

    public static final List<String> USERS_TEST_DATA = List.of("Boris", "Martin", "Gandalf");

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(EchoClient.class.getResource("view.fxml"));
        Parent root = loader.load();

        Socket socket = new Socket("localhost", 8189);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        primaryStage.setTitle("Messenger");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Network network = new Network();
        if (!network.connect()) {
            System.out.println("Ошибка подключения к серверу");
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}
