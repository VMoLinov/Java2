package server;

import com.sun.security.ntlm.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    public static final int PORT = 8081;
    private List<ClientHandler> clients;
    private AuthService authService;

    public MyServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            authService = new BaseAuthService();
            authService.start();
            clients = new ArrayList<>();
            while (true) {
                System.out.println("Waiting connection");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                clients.add(new ClientHandler(this, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            authService.stop();
        }
    }

    public synchronized void broadcastMessage(Message message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }
}
