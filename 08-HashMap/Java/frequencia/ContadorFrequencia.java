package frequencia;

import java.util.HashMap;

public class ContadorFrequencia {
    /**
     * conta a frequência de cada caractere em uma string.
     * @param texto - a string a ser analisada
     * @return HashMap com cada caractere e sua frequência
     */
    public static HashMap<Character, Integer> contarCaracteres(String texto) {
        HashMap<Character, Integer> frequencia = new HashMap<>();
        for (char c : texto.toCharArray()) {
            frequencia.put(c, frequencia.getOrDefault(c, 0) + 1);
        }
        return frequencia;
    }

    /**
     * conta a frequência de cada palavra em uma string.
     * @param texto - a string a ser analisada
     * @return HashMap com cada palavra e sua frequência
     */
    public static HashMap<String, Integer> contarPalavras(String texto) {
        HashMap<String, Integer> frequencia = new HashMap<>();
        String[] palavras = texto.toLowerCase().split("\\s+");
        for (String palavra : palavras) {
            frequencia.put(palavra, frequencia.getOrDefault(palavra, 0) + 1);
        }
        return frequencia;
    }

    /**
     * exibe o mapa de frequência formatado.
     * @param mapa - o HashMap a ser exibido
     */
    public static <K, V> void exibirFrequencia(HashMap<K, V> mapa) {
        for (var entry : mapa.entrySet()) {
            System.out.println("'" + entry.getKey() + "' -> " + entry.getValue());
        }
        System.out.println("------------------------------");
        System.out.println("Total de elementos distintos: " + mapa.size());
    }
}
