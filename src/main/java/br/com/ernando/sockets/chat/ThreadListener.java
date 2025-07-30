package br.com.ernando.sockets.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

public class ThreadListener extends Thread {
    Logger logger = Logger.getLogger(ThreadListener.class.getName());
    private final BufferedReader in;

    public ThreadListener(BufferedReader in){
        this.in = in;
    }

    @Override
    public void run() {
        String input;
        try {
          while ((input = in.readLine()) != null) {
              logger.info("Recebi: {}", input);
          }
        } catch (IOException e) {
            logger.info("Erro ao ler os dados recebidos.");
        }
    }
}
