package frequencia;

import java.util.HashMap;

public class Principal {
    public static void main(String[] args) {
        String texto = "estruturas de dados sao estruturas fundamentais para organizar dados";

        // contagem de frequência de caracteres
        System.out.println("=== Frequência de Caracteres ===");
        HashMap<Character, Integer> freqCaracteres = ContadorFrequencia.contarCaracteres(texto);
        ContadorFrequencia.exibirFrequencia(freqCaracteres);

        // contagem de frequência de palavras
        System.out.println("\n=== Frequência de Palavras ===");
        HashMap<String, Integer> freqPalavras = ContadorFrequencia.contarPalavras(texto);
        ContadorFrequencia.exibirFrequencia(freqPalavras);
    }
}
