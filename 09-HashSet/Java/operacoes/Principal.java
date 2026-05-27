package operacoes;

import java.util.HashSet;

public class Principal {
    public static void main(String[] args) {
        // Criando dois conjuntos de disciplinas
        HashSet<String> disciplinasJoao = new HashSet<>();
        disciplinasJoao.add("Estrutura de Dados");
        disciplinasJoao.add("Banco de Dados");
        disciplinasJoao.add("Programação Web");
        disciplinasJoao.add("Algoritmos");

        HashSet<String> disciplinasMaria = new HashSet<>();
        disciplinasMaria.add("Estrutura de Dados");
        disciplinasMaria.add("Redes de Computadores");
        disciplinasMaria.add("Algoritmos");
        disciplinasMaria.add("Sistemas Operacionais");

        // Exibindo os conjuntos
        System.out.println("=== Conjuntos de Disciplinas ===");
        OperacoesConjunto.exibirConjunto("Disciplinas de João", disciplinasJoao);
        OperacoesConjunto.exibirConjunto("Disciplinas de Maria", disciplinasMaria);

        // União: todas as disciplinas
        System.out.println("\n=== União (A ∪ B) ===");
        HashSet<String> uniao = OperacoesConjunto.uniao(disciplinasJoao, disciplinasMaria);
        OperacoesConjunto.exibirConjunto("Todas as disciplinas", uniao);

        // Interseção: disciplinas em comum
        System.out.println("\n=== Interseção (A ∩ B) ===");
        HashSet<String> intersecao = OperacoesConjunto.intersecao(disciplinasJoao, disciplinasMaria);
        OperacoesConjunto.exibirConjunto("Disciplinas em comum", intersecao);

        // Diferença: disciplinas exclusivas de João
        System.out.println("\n=== Diferença (A - B) ===");
        HashSet<String> diferenca = OperacoesConjunto.diferenca(disciplinasJoao, disciplinasMaria);
        OperacoesConjunto.exibirConjunto("Exclusivas de João", diferenca);

        // Subconjunto
        System.out.println("\n=== Verificação de Subconjunto ===");
        System.out.println("Interseção é subconjunto de João? " +
            OperacoesConjunto.ehSubconjunto(intersecao, disciplinasJoao));
    }
}
