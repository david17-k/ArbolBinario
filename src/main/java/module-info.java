module uq.arboles {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens uq.arboles to javafx.fxml;
    exports uq.arboles;

}