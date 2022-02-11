public class App {
    public static void main(String[] args) throws Exception {
        ListaSimple ls = new ListaSimple();
        ls.insertarAlFinal("2");
        ls.insertarAlFinal("0");
        ls.insertarAlFinal("2");
        ls.insertarAlFinal("0");
        ls.insertarAlFinal("0");
        ls.insertarAlFinal("2");
        ls.insertarAlFinal("7");
        ls.insertarAlFinal("9");
        ls.insertarAlFinal("3");
        ls.dibujarGraphviz();
        ls.abrirarchivo("grafica.png");
    }
}
