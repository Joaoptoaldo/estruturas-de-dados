package stack001;

import java.util.Stack;

public class Pilha {
    public static void main(String[] args) {
        // Criando uma pilha de Strings
        Stack<String> pilha = new Stack<>();

        // Adicionando elementos à pilha
        pilha.push("Primeiro");
        pilha.push("Segundo");
        pilha.push("Terceiro");
        System.out.println(pilha);

        // Acessando o topo da pilha sem removê-lo
        String topo = pilha.peek();

        System.out.println("Topo da pilha: " + topo);
        
        // Removendo o elemento do topo da pilha
        String removido = pilha.pop();

        System.out.println("Elemento removido: " + removido);
        System.out.println("Pilha após remoção: " + pilha);

    }
}