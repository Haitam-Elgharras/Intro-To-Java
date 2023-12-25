package com.example.chat_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class ChatThread implements Runnable {

    private Socket socket;
    private Map<String, Socket> users;

    public ChatThread(Socket socket, Map<String, Socket> users) {
        this.socket = socket;
        this.users = users;
    }

    private void sendMessages(String message,String reciever){
        Socket recieverSocket = users.get(reciever);
        try {
            System.out.println("receiver: " + reciever);
            System.out.println("message: " + message);
            PrintWriter printWriter = new PrintWriter(recieverSocket.getOutputStream(), true);
            printWriter.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        String username = "user"+(users.size());
        System.out.println("username: " + username);
        users.put(username, socket);

        try {
            // char by char and will be depending on byte by byte from the getInputStream
            InputStreamReader is = new InputStreamReader(socket.getInputStream());
            // line by line depending on the input stream reader
            BufferedReader bufferedReader = new BufferedReader(is);

            while (true) {
                String line = bufferedReader.readLine();
                String[] tokens = line.split("=>");

                sendMessages(tokens[1],tokens[0]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
