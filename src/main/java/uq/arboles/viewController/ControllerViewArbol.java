package uq.arboles.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import uq.arboles.Controller.ArbolBinario;
import uq.arboles.Controller.Nodo;
import javafx.scene.paint.Color;

import java.awt.*;

public class ControllerViewArbol {

    private ArbolBinario arbolBinario=new ArbolBinario();

    @FXML
    private Button bttAgregar;

    @FXML
    private Button bttAltura;

    @FXML
    private Button bttAmplitud;

    @FXML
    private Button bttBorrarArbol;

    @FXML
    private Button bttBuscar;

    @FXML
    private Button bttContarHojas;

    @FXML
    private Button bttEliminarDato;

    @FXML
    private Button bttMayor;

    @FXML
    private Button bttNodoMenor;

    @FXML
    private Button bttObtenerMenor;

    @FXML
    private Button bttObtenerPeso;

    @FXML
    private Button bttObtenrNivel;

    @FXML
    private MenuButton bttRecorree;

    @FXML
    private TextField txtAgregarN;

    @FXML
    private TextField txtBuscar;

    @FXML
    private TextField txtDatoB;
    @FXML
    private AnchorPane paneArbol;

    private static final double RADIO = 20;
    private static final double V_GAP = 60;

    @FXML
    void initialize(){


    }



    public void agregar(ActionEvent event){
        arbolBinario.agregarDato(Integer.parseInt(txtAgregarN.getText()));
        arbolBinario.mostrar();
        dibujarArbol();
    }

    private void dibujarArbol() {
        paneArbol.getChildren().clear(); // limpia dibujo anterior
        Nodo raiz = arbolBinario.getArbol();
        if (raiz != null) {
            dibujarNodo(raiz, paneArbol.getWidth() / 2, RADIO + 10, paneArbol.getWidth() / 4);
        }
    }

    private void dibujarNodo(Nodo nodo, double x, double y, double offsetX) {
        // Dibuja enlace con hijo izquierdo
        if (nodo.getIzquierda() != null) {
            double childX = x - offsetX;
            double childY = y + V_GAP;
            Line linea = new Line(x, y, childX, childY);
            paneArbol.getChildren().add(linea);
            dibujarNodo(nodo.getIzquierda(), childX, childY, offsetX / 2);
        }

        // Dibuja enlace con hijo derecho
        if (nodo.getDerecha() != null) {
            double childX = x + offsetX;
            double childY = y + V_GAP;
            Line linea = new Line(x, y, childX, childY);
            paneArbol.getChildren().add(linea);
            dibujarNodo(nodo.getDerecha(), childX, childY, offsetX / 2);
        }

        // Dibuja nodo (círculo + texto)
        Circle circle = new Circle(x, y, RADIO);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        Text text = new Text(x - 7, y + 5, String.valueOf(nodo.getDato()));
        paneArbol.getChildren().addAll(circle, text);
    }





}
