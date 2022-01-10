package com.pb.kopejkin.hw15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

    static class Handler implements Runnable {
        private final Socket clientSocket;
        private static final DateTimeFormatter CHANGE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        public Handler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String clientMessage;

                // цикл ожидания сообщений от клиента
                System.out.println("Ожидаем сообщений");
                while ((clientMessage = in.readLine()) != null) {
                    out.println(LocalDateTime.now().format(CHANGE_TIME_FORMAT) + " Сервер: " + clientMessage);
                    System.out.println(Thread.currentThread().getName() + " " + clientMessage);
                }

                out.close();
                in.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (Exception ex) {
                    // ignore
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        int serverPort = 1234;
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Старт сервера на порту : " + serverPort);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключился");
                threadPool.submit(new Server.Handler(clientSocket));
            } catch (IOException e) {
                System.out.println("Не могу установить соединение");
                System.exit(-1);
            }
        }
    }
}
