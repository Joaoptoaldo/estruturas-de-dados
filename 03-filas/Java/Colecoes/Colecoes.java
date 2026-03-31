package Colecoes;

// 1 - ficha normal -> sua ficha é 1 a 500           
// 2 - ficha prioritaria -> sua ficha é 501 a 1000
// 3 - chamar ficha 
// 4 - proxima ficha
// 5 - sair
//opcao;


import java.util.LinkedList;
import java.util.Queue;

public class Colecoes {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        fila.add("Ficha 1");
        fila.add("Ficha 2");
        fila.add("Ficha 3");
        fila.add("Ficha 4");

        System.out.println("Fila: " + fila);

        String proximaFicha = fila.peek();

        System.out.println("Próxima ficha a ser chamada: " + proximaFicha);
    }
}
