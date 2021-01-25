package server;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private Socket socket;
    private MyServer myServer;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public ClientHandler(MyServer myServer, Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    authentication();
                    readMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void authentication() {
        while (true) {
            try {
                Message message = new Gson().fromJson(dataInputStream.readUTF(), Message.class)
                if (!message.getMessage().startsWith("/auth")) {
                    continue;
                }
                String[] parts = message.getMessage().split("\\s");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readMessage() throws IOException {
        while (true) {
            Message message = new Gson().fromJson(dataInputStream.readUTF(), Message.class);
            myServer.broadcastMessage(message);
        }
    }

    public void sendMessage(Message message) {
        try {
            dataOutputStream.writeUTF(new Gson().toJson(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
