package stack002;

import java.util.Scanner;
import java.util.Stack;

public class Pilha {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Stack<Integer> pilha = new Stack<>();
        int opcao;

        System.out.println("Exemplo simples de Pilha com inteiros");
        System.out.println("1. Empilhar (push)");
        System.out.println("2. Desempilhar (pop)");
        System.out.println("3. Ver topo (peek)");
        System.out.println("4. Ver tamanho");
        System.out.println("5. Ver se está vazia");
        System.out.println("0. Sair");
        

        do {
            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número para empilhar: ");
                    pilha.push(leitor.nextInt());
                    System.out.println("Número empilhado. Pilha: " + pilha);
                    break;
                case 2:
                    if (!pilha.isEmpty()) {
                        int removido = pilha.pop();
                        System.out.println("Número desempilhado: " + removido + ". Pilha: " + pilha);
                    } else {
                        System.out.println("Pilha vazia!");
                    }
                    break;
                case 3:
                    if (!pilha.isEmpty()) {
                        System.out.println("Topo: " + pilha.peek());
                    } else {
                        System.out.println("Pilha vazia!");
                    }
                    break;
                case 4:
                    System.out.println("Tamanho da pilha: " + pilha.size());
                    break;
                case 5:
                    System.out.println("Pilha " + (pilha.isEmpty() ? "vazia" : "não vazia"));
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        leitor.close();
    }
}
