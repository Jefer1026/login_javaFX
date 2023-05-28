module com.example.pruebafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.pruebafx to javafx.fxml;
    exports com.example.pruebafx;
}