package uq.arboles.Controller;

public class ArbolBinario {

    private Nodo arbol;
    private int tamaño;

    public void agregarDato(int numero){// 30 45 20
        Nodo aux=new Nodo(numero);
        if(isVerificar()){
            arbol=aux;
        }else{
           Nodo n=aux;
           while (n!=null){
               if(n.getDato()>aux.getDato()){
                   n=n.getDerecha();
               }else{
                   n=n.getIzquierda();
               }

            }
        }
    }

    private boolean isVerificar() {
        return arbol==null;
    }
}
