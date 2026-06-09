package mapaRomenia;

import java.util.ArrayList;

public class Principal {
  public static void main(String[] args) {
    ArrayList<String> listaVertices = new ArrayList<>();
    String arquivoMapa = "10-grafo/mapaRomenia/mapa.csv";

    Grafo.descobrirVertices(arquivoMapa, listaVertices);

    Grafo g = new Grafo(listaVertices);

    //g.mostrarVertices("Lista de vertices descoberta: ");

    Grafo.montarGrafo(arquivoMapa, g);

    g.mostrarGrafo();
  }
}
