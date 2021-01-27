package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final int SERVER_PORT = 8189;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Ожидание подключения");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Соединение установлено");
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            while (true) {
                String message = in.readUTF();
                System.out.println("Сообщение пользователя: " + message);
                if ("/exit".equals(message)) {
                    break;
                }
                out.writeUTF("Ответ от сервера: " + message.toUpperCase());
            }
            System.out.println("Сервер остановлен");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Порт уже занят");
        }
    }
}