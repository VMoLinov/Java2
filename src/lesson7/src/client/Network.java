package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network {

    public static final int SERVER_PORT = 8189;
    public static final String SERVER_HOST = "localhost";

    public final int PORT;
    public final String HOST;


    public Network() {
        this(SERVER_HOST, SERVER_PORT);
    }

    public Network(String serverHost, int serverPort) {
        this.HOST = serverHost;
        this.PORT = serverPort;
    }

    public boolean connect() {
        try {
            Socket socket = new Socket("localhost", 8189);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            return true;
        } catch (IOException e) {
            System.out.println("Соединение не было установлено");
            e.printStackTrace();
            return false;
        }
    }
}
