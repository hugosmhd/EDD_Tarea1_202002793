import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ListaSimple {
    Nodo primero;
    Nodo ultimo;

    public ListaSimple() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean estaVacia() {
        return primero==null;
    }

    public void insertarAlFinal(Object data) {
        Nodo nuevo = new Nodo(data);
        if (estaVacia()) {
            this.primero = nuevo;
            this.ultimo = nuevo;
        } else {
            this.ultimo.setSiguiente(nuevo);
            this.ultimo = nuevo;
        }
    }

    public void visualizar(){
        Nodo actual= this.primero;

        while( actual!= null){
            if (actual.siguiente==null) System.out.print(actual.toString());
            else System.out.println(actual.toString());
            actual=actual.siguiente;
        }
            
    }
    
    public String codigoGraphviz() {
        StringBuilder dot = new StringBuilder();
        dot.append("digraph G { \n");
        dot.append("node[shape=box, color=red];\n");
        
        String nombresNodos = "";
        String conexiones = "";
        Nodo actual= this.primero;
        while( actual!= null){
            nombresNodos += "nodo" + actual.hashCode() + "[label=\"" +  actual.toString() + "\"]" + "\n";
            if (actual.siguiente != null)            
                conexiones += String.format("nodo%d -> nodo%d;\n", actual.hashCode(), actual.siguiente.hashCode());
            actual=actual.siguiente;
        }
        
        dot.append(nombresNodos);
        dot.append(conexiones);
        dot.append("rankdir=LR;\n");
        dot.append("} \n");    
        
        return dot.toString();
    }
    
    private void escribirArchivo(String ruta, String contenido) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try {
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);
            pw.write(contenido);
            pw.close();
            fichero.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if(pw != null) {
                pw.close();
            }            
        }
    }
    
    public void dibujarGraphviz() {
        try {
            escribirArchivo("archivo.dot", codigoGraphviz());
            ProcessBuilder proceso;
            proceso = new ProcessBuilder("dot","-Tpng","-o","grafica.png","archivo.dot");
            proceso.redirectErrorStream(true);
            proceso.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void abrirarchivo(String archivo){
        try {

            File objetofile = new File (archivo);
            Desktop.getDesktop().open(objetofile);

        }catch (IOException ex) {
            System.out.println(ex);

        }

    } 
}
