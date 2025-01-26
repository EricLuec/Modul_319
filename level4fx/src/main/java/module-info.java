module org.example.level4fx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.level4fx to javafx.fxml;
    exports org.example.level4fx;
}