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
    private TextField txtNivel;





    @FXML
    private TextField imprimirResultado;



    private static final double RADIO = 20;
    private static final double V_GAP = 60;

    @FXML
    void initialize(){
    configurarBoton();


    }

    public void obtenerAltura(ActionEvent event){
        String m= String.valueOf(arbolBinario.altura());
        imprimirResultado.setText("Altura del arbol "+ m);
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


    private void configurarBoton(){
        MenuItem preordenItem = new MenuItem("Preorden");
        MenuItem inordenItem = new MenuItem("Inorden");
        MenuItem postordenItem = new MenuItem("Postorden");

        bttRecorrer.getItems().addAll(preordenItem, inordenItem, postordenItem);


        preordenItem.setOnAction(event -> {
            String resultado = String.valueOf(arbolBinario.mostrarPreOrden());
            imprimirResultado.setText("Preorden: " + resultado);
        });

        inordenItem.setOnAction(event -> {
            String resultado = arbolBinario.mostrarInorden().toString();
            imprimirResultado.setText("Inorden: " + resultado);
        });

        postordenItem.setOnAction(event -> {
            String resultado = arbolBinario.mostrarPostOrden().toString();
            imprimirResultado.setText("Postorden: " + resultado);
        });
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

    public void borrarArbol(ActionEvent event){
        arbolBinario.borrarArbol();
        paneArbol.getChildren().clear();
    }

    public void isEmpty(ActionEvent event){
        String mensaje="";
        if(arbolBinario.isEmpty()){
             mensaje="Arbol vacio";
            imprimirResultado.setText(mensaje);
        }else{
            mensaje="Arbol con datos";
            imprimirResultado.setText(mensaje);
        }
    }

    public void contarHojas(ActionEvent event){
        String m= String.valueOf(arbolBinario.hojas());
        imprimirResultado.setText(m);
    }

    public void borrarDato(ActionEvent event){
        int borrar= Integer.parseInt(txtDatoB.getText());
        arbolBinario.borrarDato(borrar);
    }

    public void obtenerPeso(ActionEvent event){
        String m= String.valueOf(arbolBinario.peso());
        imprimirResultado.setText(m);
    }

    public void obtenerNivel(ActionEvent event){
        int valor= Integer.parseInt(txtNivel.getText());
        String m= String.valueOf(arbolBinario.nivel(valor));
        imprimirResultado.setText(m);
    }

    public void imprimirAmplitud(ActionEvent event){
        String m= String.valueOf(arbolBinario.amplitud());
        imprimirResultado.setText(m);
    }

    public void obtenerMayor(ActionEvent event){
        String m= String.valueOf(arbolBinario.mayor());
        imprimirResultado.setText(m);
    }

    public void obtenerMenor(ActionEvent event){
        String m= String.valueOf(arbolBinario.menor());
        imprimirResultado.setText(m);
    }







}
