module com.example.chat_server {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chat_server to javafx.fxml;
    exports com.example.chat_server;
}