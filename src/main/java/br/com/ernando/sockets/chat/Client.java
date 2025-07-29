package br.com.ernando.sockets.chat;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting client...");
        Socket socket = new Socket("localhost", 5001);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ThreadListener escuta = new ThreadListener(in);
        escuta.start();
        String input = "";
        while (true) {
            input = JOptionPane.showInputDialog(null, "Message to server", "Client", JOptionPane.INFORMATION_MESSAGE);
            out.println(input);
            System.out.println("Client: " + input);
        }
    }
}
