package com.example.chat_client;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class ChatApp extends Application {
    private static Socket socket;
    private static PrintWriter printWriter;
    private static BufferedReader bufferedReader;

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();

        Label labelMsg = new Label("Message");
        TextField textFieldMsg = new TextField();
        Label labelDest = new Label("Destination");
        TextField textFieldDest = new TextField();






        ObservableList<String> msgData = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<>(msgData);
        VBox box =new VBox(listView);
        box.setPadding(new Insets(10));

        Button buttonSend = new Button("Send");
        buttonSend.setOnAction(e -> {
            String msg = textFieldMsg.getText();
            String dest = textFieldDest.getText();
            printWriter.println(dest + "=>" + msg);
            msgData.add("Me: " + msg);

        });
        HBox hBox = new HBox(labelMsg, textFieldMsg, labelDest, textFieldDest, buttonSend);
        hBox.setSpacing(20);
        root.setBottom(hBox);

        Runnable runnable = () -> {
            try {
                String msg;
                while ((msg = bufferedReader.readLine()) != null) {
                    msgData.add("Him: " + msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        new Thread(runnable).start();



        root.setCenter(listView);

        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        try {
             socket = new Socket("localhost", 8080);

            OutputStream outputStream = socket.getOutputStream();
             printWriter = new PrintWriter(outputStream, true);

            InputStream inputStream = socket.getInputStream();
            // char by char depending on byte by byte from the getInputStream
            InputStreamReader is = new InputStreamReader(inputStream);
            // line by line depending on the input stream reader
             bufferedReader = new BufferedReader(is);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        launch();
    }
}