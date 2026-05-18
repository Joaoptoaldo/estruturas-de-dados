import java.util.TreeSet;

public class Arvore {
  public static void main(String[] args){
    TreeSet<Integer> arvore = new TreeSet<>();

    arvore.add(5);
    arvore.add(10);
    arvore.add(15);
    arvore.add(7);
    arvore.add(20);
    arvore.add(25);
    arvore.add(3);
    arvore.add(30);

    // a estrutura do TreeSet é baseada em uma árvore binária de busca, onde os elementos são organizados de forma ordenada
    System.out.println("Elementos da árvore: " + arvore);
    System.out.println("\n");

    for (Integer elemento : arvore) {
      // a ordem de impressão será do menor para o maior, pois o TreeSet mantém os elementos ordenados
      System.out.println("Elemento: " + elemento);
    }

    if (arvore.contains(10)) {
      System.out.println("\nA árvore contém o elemento 10");

      arvore.remove(10);// a remoção do elemento 10 é feita de forma eficiente, mantendo a estrutura da árvore balanceada

      System.out.println("Elemento 10 removido. Elementos atuais da árvore: " + arvore);
    } else {
      System.out.println("\nA árvore não contém o elemento 10");
    }
  }
}
