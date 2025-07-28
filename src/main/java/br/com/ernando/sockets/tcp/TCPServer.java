package br.com.ernando.sockets.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Stating server...");
        ServerSocket serverSocket = new ServerSocket(5001);
        Socket socketClient = serverSocket.accept();
        PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        String input;
        while ((input = in.readLine()) != null) {
            System.out.println("Received " + input); 
            out.println(input);
            if(input.equalsIgnoreCase("end")){
                break;
            }
        }
        out.close();
        serverSocket.close();
        socketClient.close();
    }
}
