package client;

import com.google.gson.Gson;
import server.*;
import java.io.*;
import java.net.Socket;

public class SocketServerService implements ServerService {

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private boolean isConnected = false;
    private final String login = "ivanov";
    private final String password = "password";

    @Override
    public void openConnection() {
        try {
            socket = new Socket("localhost", MyServer.PORT);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            AuthMessage authMessage = new AuthMessage();
            authMessage.setLogin(login);
            authMessage.setPassword(password);
            dataOutputStream.writeUTF(new Gson().toJson(authMessage));

            authMessage = new Gson().fromJson(dataInputStream.readUTF(), AuthMessage.class);
            if (authMessage.isAuthenticated()) {
                isConnected = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try {
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String message) {
        Message msg = new Message();
        msg.setMessage(message);

        try {
            dataOutputStream.writeUTF(new Gson().toJson(msg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readMessages() {
        try {
            return new Gson().fromJson(dataInputStream.readUTF(), Message.class).getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isConnected() {
        return isConnected;
    }
}
