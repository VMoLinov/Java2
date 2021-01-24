package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Server socket created, waiting response");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                String inputMessage;
                while (!socket.isClosed()) {
                    try {
                        inputMessage = in.readUTF();
                        System.out.println(inputMessage);
                        if ("\\close".equals(inputMessage)) {
                            System.out.println("Client close connection");
                            socket.close();
                            System.exit(0);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String outputMessage;
                while (!socket.isClosed()) {
                    try {
                        outputMessage = scanner.nextLine();
                        out.writeUTF(outputMessage);
                        out.flush();
                        if ("\\close".equals(outputMessage)) {
                            System.out.println("Connection closed");
                            System.exit(0);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
