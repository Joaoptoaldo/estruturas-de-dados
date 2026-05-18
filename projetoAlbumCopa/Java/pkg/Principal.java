package pkg;

import java.text.Normalizer;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        // inicia as listas carregando dos arquivos CSV
        List<Figura> listaRepetidas = GerenciadorArquivo.carregar("figuras_repetidas_pessoais.csv");
        List<Figura> listaDesejadas = GerenciadorArquivo.carregar("figuras_desejadas_pessoais.csv");

        String opcao = "";

        //     MENU:

        // 1 - Cadastrar figuras repetidas pessoais (persistidas em arquivo csv figuras_repetidas_pessoais.csv e adicionadas na ListaRepetidasPessoais)
        // 2 - Listar figuras repetidas pessoais (mostrar a lista respectiva)
        // 3 - Cadastrar figuras desejadas pessoais (persistidas em arquivo csv figuras_desejadas_pessoais.csv e adicionadas na ListaDesejadasPessoais)
        // 4 - Listar figuras desejadas pessoais (mostrar a lista respectiva)
        // 5 - Carregar figuras repetidas OUTRO (carregar o arquivo, listar as figuras e mostrar as figuras que dão match com ListaDesejadasPessoais)
        // 6 - Carregar figuras desejadas OUTRO (carregar o arquivo, listar as figuras e mostrar as figuras que dão match com ListaRepetidasPessoais)
        // 7 - Sair

        do {
            System.out.println("\n--- ÁLBUM COPA 2026 ---");
            System.out.println("1 - Cadastrar repetida");
            System.out.println("2 - Listar minhas repetidas");
            System.out.println("3 - Cadastrar desejada");
            System.out.println("4 - Listar minhas desejadas");
            System.out.println("5 - Match: O que o OUTRO tem que eu quero?");
            System.out.println("6 - Match: O que eu tenho que o OUTRO quer?");
            System.out.println("7 - Sair");
            opcao = teclado.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarFigurinha(teclado, listaRepetidas, "figuras_repetidas_pessoais.csv");
                    break;
                case "2":
                    listarFiguras(listaRepetidas, "MINHAS REPETIDAS");
                    break;
                case "3":
                    cadastrarFigurinha(teclado, listaDesejadas, "figuras_desejadas_pessoais.csv");
                    break;
                case "4":
                    listarFiguras(listaDesejadas, "MINHAS DESEJADAS");
                    break;
                case "5":
                    verificarMatchEntrada(teclado, listaDesejadas);
                    break;
                case "6":
                    verificarMatchEntrada(teclado, listaRepetidas);
                    break;
                case "7":
                    System.out.println("Fim do programa");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (!opcao.equals("7"));
    }

    // MÉTODOS AUXILIARES 

    /**
     * método auxiliar para ler inteiros de forma segura do teclado
     * @param teclado - Scanner para ler a entrada do usuário
     * @param rotulo - rótulo (texto de instrução) a ser impresso
     * @return - o número inteiro válido digitado
     */
    private static int lerInteiro(Scanner teclado, String rotulo) {
        while (true) {
            System.out.print(rotulo);
            try {
                return Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite um número inteiro válido");
            }
        }
    }

    /**
     * método para cadastrar uma nova figurinha, adicionando na lista e salvando no arquivo CSV
     * @param teclado - Scanner para ler a entrada do usuário
     * @param lista - lista onde a nova figura será adicionada
     * @param arquivo - nome do arquivo CSV onde a figura será salva
     */
    public static void cadastrarFigurinha(Scanner teclado, List<Figura> lista, String arquivo) {
        System.out.print("Seleção: ");
        String selecao = teclado.nextLine();
        
        int numero = lerInteiro(teclado, "Número: ");
        
        System.out.print("Descrição: ");
        String desc = teclado.nextLine();
        
        int qtd = lerInteiro(teclado, "Quantidade: ");
        
        System.out.print("É rara? (true/false): ");
        boolean rara = Boolean.parseBoolean(teclado.nextLine());

        // criando a nova figura e adicionando na lista
        Figura nova = new Figura(selecao, numero, desc, qtd, rara);
        lista.add(nova);
        
        // salvando logo após cadastrar
        GerenciadorArquivo.salvar(arquivo, lista);
        System.out.println("Figurinha salva");
    }

    /**
     * método para listar as figuras de uma lista, mostrando um título antes da listagem
     * @param lista - lista de figuras a ser listada
     * @param titulo - título a ser mostrado antes da listagem
     */
    public static void listarFiguras(List<Figura> lista, String titulo) {
        System.out.println("\n--- " + titulo + " ---");
        if (lista.isEmpty()) {
            System.out.println("Lista vazia");
        } else {
            // aqui entra o método toString() da classe Figura para mostrar as informações de cada figura
            for (Figura f : lista) {
                System.out.println(f);
            }
        }
    }

    /**
     * método para verificar figuras que dão match entre a entrada do outro e a lista atual
     * @param teclado - Scanner para ler o caminho do arquivo
     * @param listaComparacao - lista para comparação (desejadas ou repetidas)
     */
    public static void verificarMatchEntrada(Scanner teclado, List<Figura> listaComparacao) {
        System.out.print("Nome do arquivo CSV: ");
        String caminhoArquivo = teclado.nextLine();
        
        // carrega as figuras do outro
        List<Figura> listaOutro = GerenciadorArquivo.carregar(caminhoArquivo);
        
        if (listaOutro.isEmpty()) {
            System.out.println("Nenhuma figura carregada do arquivo");
            return;
        }

        // listar as figuras carregadas do outro
        listarFiguras(listaOutro, "FIGURAS CARREGADAS DO OUTRO");
        
        // mostra matches (normaliza strings e aceita match por seleção+numero OU seleção+descrição)
        System.out.println("\n--- MATCHES ENCONTRADOS ---");
        boolean encontrouMatch = false;

        // cria um conjunto de chaves para minhas figuras: "selNorm|num" e "selNorm|descNorm"
        Set<String> minhasChaves = new HashSet<>();
        for (Figura minha : listaComparacao) {
            String selNorm = normalize(minha.getNomeSelecao());
            String descNorm = normalize(minha.getDescricao());
            minhasChaves.add(selNorm + "|" + minha.getNumeroFigura());
            minhasChaves.add(selNorm + "|desc:" + descNorm);
        }
    
        for (Figura outro : listaOutro) {
            String selNormOutro = normalize(outro.getNomeSelecao());
            String descNormOutro = normalize(outro.getDescricao());
            String chaveNum = selNormOutro + "|" + outro.getNumeroFigura();
            String chaveDesc = selNormOutro + "|desc:" + descNormOutro;

            if (minhasChaves.contains(chaveNum) || minhasChaves.contains(chaveDesc)) {
                System.out.println(outro.getNomeSelecao() + " #" + outro.getNumeroFigura() + " - " + outro.getDescricao() + (outro.isRaridade() ? " [RARA]" : "") + " (Qtd: " + outro.getQuantidade() + ")");
                encontrouMatch = true;
            }
        }

        if (!encontrouMatch) {
            System.out.println("Nenhum match encontrado");
        }
    }

    /**
     * método para normalizar strings, removendo acentos, convertendo para minúsculas e removendo espaços extras
     * @param s - string a ser normalizada
     * @return string normalizada 
     */
    private static String normalize(String s) {
        if (s == null) return "";
        String n = Normalizer.normalize(s, Normalizer.Form.NFD);
        n = n.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        n = n.trim().toLowerCase().replaceAll("\\s+", " ");
        return n;
    }
}