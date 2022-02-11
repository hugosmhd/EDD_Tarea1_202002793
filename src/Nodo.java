public class Nodo {
    Object info;
    Nodo siguiente;

    public Nodo(Object info){
        this.info=info;
        this.siguiente=null;
    }

    public void setSiguiente(Nodo siguiente){
        this.siguiente=siguiente;
    }
    
    public String toString(){
        return String.valueOf(this.info);
    }    
}
