package uq.arboles.Controller;

public class ArbolBinario {

    private Nodo arbol;
    private int tamaño;

    public Nodo getArbol() {
        return arbol;
    }

    public void setArbol(Nodo arbol) {
        this.arbol = arbol;
    }

    public void agregarDato(int numero){// 30 45 20 50
        Nodo aux=new Nodo(numero);
        if(isVerificar()){
            arbol=aux;
        }else{
           Nodo n=arbol;
           Nodo padre = null;
            while (n!=null){
                padre=n;
                if(numero>n.getDato()){
                    n=n.getDerecha();
                }else{
                    n=n.getIzquierda();
                }
            }
            if(numero< padre.getDato()){
                padre.setIzquierda(aux);
            }else{
               padre.setDerecha(aux);
            }
        }
    }

    public void mostrar(){
        recorrer(arbol);
    }

    public void recorrer(Nodo n){
        if(n!=null){
            recorrer(n.getIzquierda());
            System.out.println("Nodo "+ n.getDato() );
            recorrer(n.getDerecha());
        }

    }

    public String verificar(int buscar){
        if(buscarNumero(buscar,arbol)){
            return "Si esta";
        }else{
            return "No esta";
        }
    }

    public boolean buscarNumero(int buscar,Nodo aux){
        if(aux!=null){
            if(buscar==aux.getDato()){
                return true;
            }
            if (buscar>aux.getDato()) {
               return buscarNumero(buscar,aux.getDerecha());
            }else{
                return buscarNumero(buscar,aux.getIzquierda());
            }
        }else{
             return false;
        }

    }

    public void recorrerInorden(Nodo n){
        if(n!=null){

        }


    }



    private boolean isVerificar() {
        return arbol==null;
    }


}
