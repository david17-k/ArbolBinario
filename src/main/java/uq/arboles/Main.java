package uq.arboles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uq.arboles.viewController.ControllerViewArbol;

import java.io.IOException;

public class Main extends Application {

        private Stage primaryStage;

        @Override
        public void start(Stage stage) throws Exception {
            this.primaryStage = stage;
            this.primaryStage.setTitle("Ventana Principal");
            this.mostrarVentanaPrincipal();



        }

        private void mostrarVentanaPrincipal() {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("arbolBinario.fxml"));
                AnchorPane rootLayout = (AnchorPane)loader.load();
                ControllerViewArbol selectViewController = (ControllerViewArbol) loader.getController();
                Scene scene = new Scene(rootLayout);
                this.primaryStage.setScene(scene);
                this.primaryStage.show();
            } catch (IOException var5) {
                var5.printStackTrace();
            }

        }

        public static void main(String[] args) {
            launch(new String[0]);
        }
    }


