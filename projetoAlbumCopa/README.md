## Sistema desenvolvido para implementar conceitos de **Estruturas de Dados**, focado na gestão e cruzamento de dados (match) para troca de figurinhas da Copa do Mundo de 2026. O projeto aplica conceitos de persistência em arquivos, manipulação de coleções dinâmicas e lógica de conjuntos.

### Tecnologias e Conceitos Utilizados

*   **Linguagem:** Java 17+
*   **Paradigma:** Orientação a Objetos (Encapsulamento, Polimorfismo e Composição).
*   **Estruturas de Dados:** `ArrayList` (Lista Linear Dinâmica).
*   **Persistência:** Manipulação de arquivos CSV via `java.nio.file` (NIO.2) e `BufferedReader/PrintWriter`.
*   **Algoritmos:** Busca linear e interseção de listas para lógica de trocas.



O projeto utiliza uma estrutura simplificada com um único pacote `pkg`:

*   **`pkg`**: Pacote contendo todas as classes principais:
    *   `Figura.java` - POJO (Plain Old Java Object) que representa a entidade figurinha com atributos e comportamentos.
    *   `GerenciadorArquivo.java` - Responsável pela persistência em arquivos CSV (leitura e escrita).
    *   `Principal.java` - Classe com método `main()` que gerencia a interface de console e fluxo do programa.

**Estrutura de diretórios:**
```
projetoAlbumCopa/
├── Java/
│   └── pkg/
│       ├── Figura.java
│       ├── GerenciadorArquivo.java
│       └── Principal.java
├── Data/
│   ├── figuras_repetidas_pessoais.csv
│   └── figuras_desejadas_pessoais.csv
└── README.md
```

### Funcionalidades

1.  **Gestão Pessoal:** Cadastro e listagem de figurinhas repetidas e desejadas.
2.  **Persistência Automática:** Os dados são salvos em arquivos `.csv` na pasta `/Data` a cada alteração.
3.  **Lógica de Match (Interseção):**
    *   **Match de Entrada:** O sistema lê as repetidas de um terceiro e filtra apenas as que você deseja.
    *   **Match de Saída:** O sistema lê as desejadas de um terceiro e mostra quais das suas repetidas podem interessar a ele.


### Formato do CSV

Os arquivos são salvos utilizando o separador `;` (ponto e vírgula) seguindo o padrão:
`selecao;numero;descricao;quantidade;raridade`

---

### Decisões Técnicas (Notas de Estudo)

*   **Por que ArrayList?** Escolhida pela facilidade de iteração e busca sequencial, ideal para conjuntos de dados de tamanho moderado onde o acesso por índice não é a prioridade, mas sim a busca por atributos específicos.
*   **Equals & HashCode:** Sobrescritos na classe `Figura` para garantir que o método `lista.contains()` identifique figurinhas iguais baseando-se apenas na *Seleção* e no *Número*, ignorando a raridade ou descrição na hora do match.
*   **Robustez:** Implementado `try-with-resources` para garantir que os fluxos de arquivos sejam fechados corretamente, evitando vazamento de memória (*memory leaks*).

### Como compilar e executar

Para evitar qualquer erro nos caminhos dos arquivos CSV, **sempre execute o programa a partir da raiz do projeto (`projetoAlbumCopa`)**.

#### 1) Compilação

**No Windows (PowerShell / CMD):**
```powershell
javac Java\pkg\*.java
```

**No Linux / macOS (Terminal):**
```bash
javac Java/pkg/*.java
```

#### 2) Execução

**No Windows (PowerShell / CMD):**
```powershell
java -cp Java pkg.Principal
```

**No Linux / macOS (Terminal):**
```bash
java -cp Java pkg.Principal
```

#### 3) Executar com entrada simulada (redirecionamento):
```powershell
java -cp Java pkg.Principal < run_inputs.txt
```

---

### Exemplos de uso

- **Listar minhas repetidas:** escolha `2` no menu.
- **Testar match com um arquivo de terceiro:** escolha `5` ou `6` no menu.
  - O sistema solicitará o nome do arquivo. Digite apenas o nome do arquivo de dados localizado na pasta `projetoAlbumCopa/Data` (ex.: `outro_desejadas.csv` ou `outro_repetidas.csv`) ou o caminho absoluto.

**Nota sobre a pasta `Data`:**
- Este repositório usa uma única pasta `Data` na raiz do projeto: `projetoAlbumCopa/Data`.
- Ao executar o programa a partir da raiz do projeto (`projetoAlbumCopa`), o `GerenciadorArquivo` sempre localizará corretamente os arquivos CSV na pasta de dados.


### Observações sobre o comportamento de match

- O sistema tenta identificar matches primariamente por **Seleção + Número** (quando ambos coincidem exatamente).
- Para ser mais tolerante a discrepâncias nos números ou formatações dos nomes, o programa também faz uma comparação adicional por **Seleção + Descrição** (nome do jogador), usando normalização básica (remoção de acentos, trimming e comparação case-insensitive). Isso ajuda a encontrar matches quando os números divergirem ou houver diferenças de caixa/acentuação.


### Estrutura de Dados Utilizadas

- **ArrayList<Figura>:** Armazena a coleção de figurinhas
- **CSV:** Formato de persistência dos dados (separador `;`)
- **Equals/HashCode:** Implementado customizado para comparação de figurinhas por seleção e número