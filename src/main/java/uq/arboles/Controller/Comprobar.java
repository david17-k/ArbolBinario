package uq.arboles.Controller;

public class Comprobar {

    public static void main(String[] args) {
        ArbolBinario arbolBinario=new ArbolBinario();
// 7, 5 , 10 ,8 ,12
        arbolBinario.agregarDato(7);
        arbolBinario.agregarDato(5);
        arbolBinario.agregarDato(10);
        arbolBinario.agregarDato(8);
        arbolBinario.agregarDato(12);
        arbolBinario.mostrar();
    }
}
