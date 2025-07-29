package br.com.ernando.sockets.chat;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting server...");
        ServerSocket serverSocket = new ServerSocket(5001);
        Socket socketClient = serverSocket.accept();
        PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        ThreadListener listener = new ThreadListener(in);
        listener.start();
        String input;
        while (true) {
            input = JOptionPane.showInputDialog(null, "Messagem to client", "Server", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Server:" + input);
            out.println(input);
        }
    }
}
