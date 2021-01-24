package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8081);) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Server socket created, waiting response");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String inputMessage = null;
                    do {
                        try {
                            inputMessage = in.readUTF();
                            System.out.println(inputMessage);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } while (!"\\close".equals(inputMessage));
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String outputMessage = null;
                    do {
                        try {
                            outputMessage = scanner.nextLine();
                            out.writeUTF(outputMessage);
                            out.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } while (!"\\close".equals(outputMessage));
                }
            }).start();
        }
    }
}
