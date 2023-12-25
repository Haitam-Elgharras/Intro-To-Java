module com.example.chat_client {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chat_client to javafx.fxml;
    exports com.example.chat_client;
}