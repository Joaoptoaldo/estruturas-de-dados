# Grafos / Graphs

## Definição

Um grafo é uma estrutura de dados formada por um conjunto de vértices (ou nós) e um conjunto de arestas (ou ligações) que conectam pares de vértices. Grafos podem ser direcionados (arestas com sentido) ou não direcionados.

## Representação

As representações mais comuns são:

- **Lista de adjacência**: para cada vértice armazena-se a lista de vizinhos. É eficiente em grafos esparsos.
- **Matriz de adjacência**: matriz quadrada em que a entrada (i, j) indica a existência (ou peso) da aresta entre i e j. Útil em grafos densos.
- **Lista de arestas**: lista de todos os pares de vértices que formam arestas. Simples e útil para alguns algoritmos (ex.: Kruskal).

## Tipos de grafos

- **Grafo simples**: sem laços e sem múltiplas arestas entre o mesmo par de vértices.
- **Multigrafo**: permite múltiplas arestas entre os mesmos vértices.
- **Direcionado**: arestas têm orientação (u → v é diferente de v → u).
- **Não direcionado**: arestas sem orientação.
- **Ponderado**: arestas com pesos ou custos.
- **Não ponderado**: arestas sem peso.
- **Conexo**: existe um caminho entre qualquer par de vértices (em grafos não direcionados).
- **Desconexo**: não é conexo.
- **Cíclico / Acíclico**: presença ou ausência de ciclos.
- **Bipartido**: vértices divididos em dois conjuntos sem arestas internas a cada conjunto.
- **Completo**: existe aresta entre todo par de vértices.
- **Planar**: pode ser desenhado no plano sem cruzamento de arestas.
- **DAG (Directed Acyclic Graph)**: grafo direcionado sem ciclos, usado para representar dependências.
- **Árvore**: grafo acíclico e conexo (equivalente a uma DAG especial quando direcionado).

## Aplicações

- Redes de computadores
- Redes sociais (modelagem de conexões entre pessoas)
- Roteamento e navegação (mapas, GPS)
- Análise e mineração de dados
- Biologia computacional (redes de interação)
- Otimização e logística
- Inteligência artificial (busca, planejamento)

## Algoritmos importantes

- **Busca em largura (BFS)**: percorre o grafo por camadas.
- **Busca em profundidade (DFS)**: percorre o grafo em profundidade.
- **Dijkstra**: caminhos mínimos em grafos com arestas não-negativas.
- **Bellman–Ford**: caminhos mínimos com possibilidade de pesos negativos.
- **Floyd–Warshall**: caminhos mínimos entre todos os pares.
- **Prim**: árvore geradora mínima (grafo conexo e ponderado).
- **Kruskal**: árvore geradora mínima usando união de conjuntos.
- **Tarjan**: componentes fortemente conectados e ordenação topológica auxiliar.
- **Kosaraju**: componentes fortemente conectados (alternativa a Tarjan).
- **Ford–Fulkerson / Edmonds–Karp**: fluxo máximo em redes de fluxo.
- **A***: busca de caminho ótimo guiada por heurística.

## Observações

- A escolha da representação depende da densidade do grafo e das operações necessárias (ex.: consulta de vizinhos vs. verificação rápida de existência de aresta).
- Muitas operações em grafos têm variações otimizadas (por exemplo, Dijkstra com heap, A* com heurísticas admissíveis, criação de índices, uso de algoritmos concorrentes).
