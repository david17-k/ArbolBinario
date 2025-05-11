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
import  javafx.scene.control.MenuItem;

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
    private TextField txtAgregarN;

    @FXML
    private TextField txtBuscar;

    @FXML
    private TextField txtDatoB;
    @FXML
    private AnchorPane paneArbol;
    @FXML
    private MenuButton bttRecorrer;


    @FXML
    private TextField imprimirResultado;

    private static final double RADIO = 20;
    private static final double V_GAP = 60;

    @FXML
    void initialize(){
    configurarBoton();


    }



    public void agregar(ActionEvent event){
        arbolBinario.agregarDato(Integer.parseInt(txtAgregarN.getText()));
        dibujarArbol();
        limpiar();
    }

    public void buscar(ActionEvent event){
        limpiarConsola();
        imprimirResultado.setText(arbolBinario.verificar(Integer.parseInt(txtBuscar.getText())));
    }

    public void recorrerArbol(ActionEvent event){
    }
    private void configurarBoton(){
        MenuItem I=new MenuItem("Preorden");
        MenuItem I1 = new MenuItem("Inorden");
        MenuItem I2=new MenuItem("PostOrden");
        bttRecorrer.getItems().addAll(I,I1,I2);
        I.setOnAction(event -> { imprimirResultado.setText(arbolBinario.mostrar());});
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

    private void limpiar(){
        txtAgregarN.setText("");
    }
    private void limpiarConsola(){
        imprimirResultado.setText("");
    }







}
