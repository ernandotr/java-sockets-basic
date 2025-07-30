package br.com.ernando.sockets.chat;

import javax.swing.*;

import jline3.terminal.src.main.java.org.jline.utils.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Server.class.getName());
        logger.info("Starting server...");
        ServerSocket serverSocket = new ServerSocket(5001);
        Socket socketClient = serverSocket.accept();
        PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        ThreadListener listener = new ThreadListener(in);
        listener.start();
        String input;
        while (true) {
            input = JOptionPane.showInputDialog(null, "Messagem to client", "Server", JOptionPane.INFORMATION_MESSAGE);
            logger.info("Server: {}", input);
            out.println(input);
        }
    }
}
