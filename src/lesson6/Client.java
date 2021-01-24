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
