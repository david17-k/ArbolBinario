package uq.arboles.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import uq.arboles.Controller.ArbolBinario;

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



    public void agregar(ActionEvent event){
        arbolBinario.agregarDato(Integer.parseInt(txtAgregarN.getText()));
    }





}
