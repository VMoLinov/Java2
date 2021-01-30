package client;

import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;


public class ViewController {

    @FXML
    private ListView<String> userList;

    @FXML
    private TextArea chatHistory;

    @FXML
    private TextField textField;

    @FXML
    private Button sendButton;

    private Network network;

    public void setNetwork(Network network) {
        this.network = network;
    }

    @FXML
    public void initialize() {
        userList.setItems(FXCollections.observableArrayList(EchoClient.USERS_TEST_DATA));
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewController.this.sendMessage();
            }
        });
        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewController.this.sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = textField.getText();
//        appendMessage(message);
        textField.clear();

        try {
            network.getOut().writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
            EchoClient.showErrorMessage("Ошибка подключения", "Ошибка отправки сообщения", e.getMessage());
        }
    }

    public void appendMessage(String message) {
        chatHistory.appendText(message);
        chatHistory.appendText(System.lineSeparator());
    }
}
