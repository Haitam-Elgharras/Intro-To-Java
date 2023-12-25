package com.example.chat_server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
public static void main(String[] args) {

    try {
        Map<String, Socket> users = new HashMap<>();

        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            users.put("", socket);
            ChatThread chatThread = new ChatThread(socket, users);
            Thread thread = new Thread(chatThread);
            thread.start();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
