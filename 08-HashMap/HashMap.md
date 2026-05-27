# HashMap

## Introdução

O `HashMap` é uma estrutura de dados que armazena pares **chave-valor** (key-value), permitindo acesso, inserção e remoção em tempo médio **O(1)**. Internamente, utiliza uma **tabela hash** para mapear cada chave a uma posição no array por meio de uma função de hash.

## Como funciona

1. Uma **função de hash** converte a chave em um índice inteiro.
2. O valor é armazenado na posição correspondente ao índice calculado.
3. Quando duas chaves produzem o mesmo índice (colisão), o HashMap resolve utilizando **encadeamento** (lista ligada ou árvore) ou **endereçamento aberto**.

## Características

| Característica | Descrição |
|---|---|
| **Chaves únicas** | Cada chave aparece no máximo uma vez. Inserir com chave existente sobrescreve o valor anterior. |
| **Permite `null`** | Aceita uma chave `null` e múltiplos valores `null`. |
| **Sem ordenação** | Não garante nenhuma ordem de iteração. |
| **Não sincronizado** | Não é thread-safe por padrão. Para uso concorrente, prefira `ConcurrentHashMap`. |

## Complexidade

| Operação | Caso Médio | Pior Caso |
|---|---|---|
| `put(key, value)` | O(1) | O(n) |
| `get(key)` | O(1) | O(n) |
| `remove(key)` | O(1) | O(n) |
| `containsKey(key)` | O(1) | O(n) |
| `containsValue(value)` | O(n) | O(n) |

> O pior caso O(n) ocorre quando muitas chaves colidem no mesmo bucket, degradando a tabela.

## Principais métodos

| Método | Descrição |
|---|---|
| `put(K key, V value)` | Insere ou atualiza um par chave-valor. |
| `get(Object key)` | Retorna o valor associado à chave, ou `null`. |
| `remove(Object key)` | Remove o par pela chave. |
| `containsKey(Object key)` | Verifica se a chave existe. |
| `containsValue(Object value)` | Verifica se o valor existe. |
| `keySet()` | Retorna o conjunto de chaves. |
| `values()` | Retorna a coleção de valores. |
| `entrySet()` | Retorna o conjunto de pares chave-valor (`Map.Entry`). |
| `size()` | Retorna o número de pares. |
| `isEmpty()` | Verifica se o mapa está vazio. |
| `clear()` | Remove todos os pares. |
| `getOrDefault(K key, V defaultValue)` | Retorna o valor ou um padrão se a chave não existir. |
| `putIfAbsent(K key, V value)` | Insere somente se a chave ainda não existir. |

## Exemplo básico

```java
import java.util.HashMap;

public class ExemploHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> notas = new HashMap<>();

        // Inserindo pares chave-valor
        notas.put("João", 85);
        notas.put("Maria", 92);
        notas.put("Pedro", 78);

        // Acessando um valor pela chave
        System.out.println("Nota de Maria: " + notas.get("Maria")); // 92

        // Verificando existência
        System.out.println("Contém João? " + notas.containsKey("João")); // true

        // Iterando sobre os pares
        for (var entry : notas.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Removendo
        notas.remove("Pedro");
        System.out.println("Tamanho após remoção: " + notas.size()); // 2
    }
}
```

## Quando usar HashMap

- Quando precisar de **busca rápida por chave** (ex.: cache, dicionário, contagem de frequência).
- Quando a **ordem de iteração não importa**.
- Quando as chaves implementarem corretamente `hashCode()` e `equals()`.

## HashMap vs outras implementações de Map

| Estrutura | Ordenação | Thread-safe | Aceita `null` |
|---|---|---|---|
| `HashMap` | Nenhuma | Não | Sim |
| `LinkedHashMap` | Ordem de inserção | Não | Sim |
| `TreeMap` | Ordem natural/comparador | Não | Não (chave) |
| `ConcurrentHashMap` | Nenhuma | Sim | Não |
| `Hashtable` | Nenhuma | Sim | Não |
