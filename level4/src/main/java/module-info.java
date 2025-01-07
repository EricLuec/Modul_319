module com.example.level4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.level4 to javafx.fxml;
    exports com.example.level4;
}