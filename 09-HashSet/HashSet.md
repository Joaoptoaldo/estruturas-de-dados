# HashSet

## Introdução

O `HashSet` é uma estrutura de dados que armazena **elementos únicos** (sem duplicatas), sem garantir nenhuma ordem de iteração. Internamente, o `HashSet` utiliza um `HashMap` para armazenar os elementos — cada elemento do conjunto é armazenado como uma **chave** do mapa, com um valor constante fictício.

## Como funciona

1. Ao adicionar um elemento, o `HashSet` calcula o **hashCode** do objeto.
2. O hash determina o **bucket** (posição) onde o elemento será armazenado.
3. Se já existir um elemento com o mesmo hash e `equals()` retornar `true`, o elemento **não** é adicionado (sem duplicatas).

## Características

| Característica | Descrição |
|---|---|
| **Elementos únicos** | Não permite duplicatas. A unicidade é determinada por `hashCode()` e `equals()`. |
| **Permite `null`** | Aceita no máximo um elemento `null`. |
| **Sem ordenação** | Não garante nenhuma ordem de iteração. |
| **Não sincronizado** | Não é thread-safe por padrão. |

## Complexidade

| Operação | Caso Médio | Pior Caso |
|---|---|---|
| `add(element)` | O(1) | O(n) |
| `remove(element)` | O(1) | O(n) |
| `contains(element)` | O(1) | O(n) |
| `size()` | O(1) | O(1) |

> O pior caso O(n) ocorre quando muitos elementos colidem no mesmo bucket.

## Principais métodos

| Método | Descrição |
|---|---|
| `add(E e)` | Adiciona o elemento se ele ainda não existir no conjunto. |
| `remove(Object o)` | Remove o elemento especificado. |
| `contains(Object o)` | Verifica se o elemento está no conjunto. |
| `size()` | Retorna o número de elementos. |
| `isEmpty()` | Verifica se o conjunto está vazio. |
| `clear()` | Remove todos os elementos. |
| `iterator()` | Retorna um iterador sobre os elementos. |
| `toArray()` | Converte o conjunto em um array. |

## Exemplo básico

```java
import java.util.HashSet;

public class ExemploHashSet {
    public static void main(String[] args) {
        HashSet<String> frutas = new HashSet<>();

        // Adicionando elementos
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Laranja");
        frutas.add("Maçã"); // duplicata — não será adicionada

        System.out.println("Tamanho: " + frutas.size()); // 3

        // Verificando existência
        System.out.println("Contém Banana? " + frutas.contains("Banana")); // true

        // Iterando
        for (String fruta : frutas) {
            System.out.println(fruta);
        }

        // Removendo
        frutas.remove("Laranja");
        System.out.println("Após remoção: " + frutas);
    }
}
```

## Importância de hashCode() e equals()

Para que o `HashSet` funcione corretamente com objetos personalizados, é **obrigatório** sobrescrever os métodos `hashCode()` e `equals()`. Caso contrário, dois objetos com os mesmos dados serão tratados como diferentes.

```java
public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto outro = (Produto) obj;
        return nome.equals(outro.nome);
    }

    @Override
    public String toString() {
        return "Produto{nome='" + nome + "', preco=" + preco + "}";
    }
}
```

## Quando usar HashSet

- Quando precisar garantir **unicidade de elementos**.
- Quando precisar de **verificação rápida de pertencimento** (`contains`).
- Quando a **ordem não importa**.

## HashSet vs outras implementações de Set

| Estrutura | Ordenação | Duplicatas | Thread-safe |
|---|---|---|---|
| `HashSet` | Nenhuma | Não | Não |
| `LinkedHashSet` | Ordem de inserção | Não | Não |
| `TreeSet` | Ordem natural/comparador | Não | Não |
| `CopyOnWriteArraySet` | Ordem de inserção | Não | Sim |
