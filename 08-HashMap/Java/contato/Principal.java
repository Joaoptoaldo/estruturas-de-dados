package contato;

import java.util.HashMap;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // HashMap que mapeia o nome do contato ao objeto Contato
        HashMap<String, Contato> agenda = new HashMap<>();
        Scanner leitor = new Scanner(System.in);

        // inserindo contatos na agenda
        System.out.println("=== Cadastro de Contatos ===");
        for (int i = 0; i < 3; i++) {
            System.out.print("Digite o nome do contato: ");
            String nome = leitor.nextLine();
            System.out.print("Digite o telefone: ");
            String telefone = leitor.nextLine();

            Contato contato = new Contato(nome, telefone);

            if (agenda.containsKey(nome)) {
                System.out.println("Contato já existe! Atualizando telefone...");
            }
            agenda.put(nome, contato);
        }

        // exibindo todos os contatos
        System.out.println("\n=== Agenda ===");
        for (var entry : agenda.entrySet()) {
            System.out.println("Chave: " + entry.getKey() + " -> " + entry.getValue());
        }

        // buscando um contato
        System.out.print("\nDigite o nome para buscar: ");
        String busca = leitor.nextLine();
        Contato encontrado = agenda.getOrDefault(busca, null);
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado);
        } else {
            System.out.println("Contato não encontrado.");
        }

        // removendo um contato
        System.out.print("Digite o nome para remover: ");
        String remover = leitor.nextLine();
        if (agenda.remove(remover) != null) {
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado para remoção.");
        }

        // exibindo agenda final
        System.out.println("\n=== Agenda Final ===");
        System.out.println("Total de contatos: " + agenda.size());
        agenda.values().forEach(System.out::println);
    }
}
