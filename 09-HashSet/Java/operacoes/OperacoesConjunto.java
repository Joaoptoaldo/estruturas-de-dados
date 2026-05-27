package operacoes;

import java.util.HashSet;

public class OperacoesConjunto {
    /**
     * retorna a união de dois conjuntos (A ∪ B).
     * @param conjuntoA - primeiro conjunto
     * @param conjuntoB - segundo conjunto
     * @return novo HashSet com todos os elementos de A e B
     */
    public static <T> HashSet<T> uniao(HashSet<T> conjuntoA, HashSet<T> conjuntoB) {
        HashSet<T> resultado = new HashSet<>(conjuntoA);
        resultado.addAll(conjuntoB);
        return resultado;
    }

    /**
     * retorna a interseção de dois conjuntos (A ∩ B).
     * @param conjuntoA - primeiro conjunto
     * @param conjuntoB - segundo conjunto
     * @return novo HashSet com os elementos comuns a A e B
     */
    public static <T> HashSet<T> intersecao(HashSet<T> conjuntoA, HashSet<T> conjuntoB) {
        HashSet<T> resultado = new HashSet<>(conjuntoA);
        resultado.retainAll(conjuntoB);
        return resultado;
    }

    /**
     * retorna a diferença entre dois conjuntos (A - B).
     * @param conjuntoA - primeiro conjunto
     * @param conjuntoB - segundo conjunto
     * @return novo HashSet com os elementos que estão em A mas não em B
     */
    public static <T> HashSet<T> diferenca(HashSet<T> conjuntoA, HashSet<T> conjuntoB) {
        HashSet<T> resultado = new HashSet<>(conjuntoA);
        resultado.removeAll(conjuntoB);
        return resultado;
    }

    /**
     * verifica se conjuntoA é subconjunto de conjuntoB (A ⊆ B).
     * @param conjuntoA - possível subconjunto
     * @param conjuntoB - conjunto a ser verificado
     * @return true se todos os elementos de A estão em B
     */
    public static <T> boolean ehSubconjunto(HashSet<T> conjuntoA, HashSet<T> conjuntoB) {
        return conjuntoB.containsAll(conjuntoA);
    }

    /**
     * exibe os elementos de um conjunto.
     * @param nome - nome do conjunto para exibição
     * @param conjunto - o HashSet a ser exibido
     */
    public static <T> void exibirConjunto(String nome, HashSet<T> conjunto) {
        System.out.println(nome + " = " + conjunto);
        System.out.println("Tamanho: " + conjunto.size());
    }
}
