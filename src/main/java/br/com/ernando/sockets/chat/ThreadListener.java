package br.com.ernando.sockets.chat;

import java.io.BufferedReader;
import java.io.IOException;

public class ThreadListener extends Thread {
    private final BufferedReader in;

    public ThreadListener(BufferedReader in){
        this.in = in;
    }

    @Override
    public void run() {
        String input;
        try {
          while ((input = in.readLine()) != null) {
              System.out.println("Recebi:"+ input);
          }
        } catch (IOException e) {
            System.err.println("Erro ao ler os dados recebidos.");
        }
    }
}
