package aluno;

import java.util.HashSet;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        HashSet<Aluno> alunos = new HashSet<>();
        Scanner leitor = new Scanner(System.in);

        // cadastrando alunos
        System.out.println("=== Cadastro de Alunos (HashSet) ===");
        for (int i = 0; i < 4; i++) {
            System.out.print("Digite o nome do aluno: ");
            String nome = leitor.nextLine().toUpperCase();
            System.out.print("Digite a matrícula: ");
            String matricula = leitor.nextLine();

            Aluno aluno = new Aluno(nome, matricula);

            if (alunos.add(aluno)) {
                System.out.println("Aluno cadastrado com sucesso!");
            } else {
                System.out.println("Aluno com matrícula " + matricula + " já existe! Não foi adicionado.");
            }
        }

        // exibindo todos os alunos
        System.out.println("\n=== Alunos Cadastrados ===");
        System.out.println("Total: " + alunos.size());
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        // verificando se um aluno existe
        System.out.print("\nDigite a matrícula para verificar: ");
        String matriculaBusca = leitor.nextLine();
        Aluno busca = new Aluno("BUSCA", matriculaBusca);
        System.out.println("Aluno encontrado? " + alunos.contains(busca));

        // removendo um aluno
        System.out.print("Digite a matrícula para remover: ");
        String matriculaRemover = leitor.nextLine();
        Aluno remover = new Aluno("REMOVER", matriculaRemover);
        if (alunos.remove(remover)) {
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado para remoção.");
        }

        // exibindo alunos finais
        System.out.println("\n=== Alunos Finais ===");
        System.out.println("Total: " + alunos.size());
        alunos.forEach(System.out::println);
    }
}
