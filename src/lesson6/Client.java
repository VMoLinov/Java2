package lesson6;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8081);
        Scanner scanner = new Scanner(System.in);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        if (socket.isConnected()) System.out.println("Connected to server");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String inputMessage;
                while (!socket.isClosed()) {
                    try {
                        inputMessage = in.readUTF();
                        System.out.println(inputMessage);
                        if ("\\close".equals(inputMessage)) {
                            System.out.println("Server closed connection");
                            socket.close();
                            break;
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
                            socket.close();
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
