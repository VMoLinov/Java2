package client;

import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class ViewController {

    @FXML
    ListView userList;

    @FXML
    TextArea chatHistory;

    @FXML
    TextField textField;

    @FXML
    Button sendButton;


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
        appendMessage(message);
        textField.clear();
    }

    private void appendMessage(String message) {
        chatHistory.appendText(message);
        chatHistory.appendText(System.lineSeparator());
    }
}
