module uq.arboles {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens uq.arboles to javafx.fxml;
    exports uq.arboles;

    opens uq.arboles.viewController to javafx.fxml;
    exports uq.arboles.viewController;

}