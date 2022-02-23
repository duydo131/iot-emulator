module com.example.iot {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires amqp.client;
    requires java.sql;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;

    opens com.example.iot to javafx.fxml;
    exports com.example.iot;
}