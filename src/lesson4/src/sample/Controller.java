package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML
    private TextArea chat;

    @FXML
    private TextField input;

    @FXML
    private Button enter;

    @FXML
    private Button close;

    @FXML
    void pressButton() {
        String message = input.getText();
        input.clear();
        if (!message.isBlank()) {
            chat.setText(chat.getText() + "user: " + message + "\n");
            chat.setScrollTop(Double.MAX_VALUE);
        }
    }

    @FXML
    void exit() {
        System.exit(0);
    }

}
