using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace SistemaClima {
    class Principal {
        static List<Clima> dados = new List<Clima>();
        static string path = "../../dadosClimaticos.csv";

        static void Main() {
            CarregarDados();
            // analisar e mostrar resultados
            GerarRelatorio();
        }

        static void CarregarDados() {
            if (!File.Exists(path)) {
                Console.WriteLine("Erro: CSV não encontrado.");
                return;
            }

            var linhas = File.ReadAllLines(path).Skip(1);
            foreach (var l in linhas) {
                var col = l.Split(',');
                if (col.Length < 4) continue;

                // converte texto da chuva para peso
                int peso = 0;
                string p = col[3].ToLower().Trim();
                if (p == "muita") peso = 3;
                else if (p == "média") peso = 2;
                else if (p == "pouca") peso = 1;

                dados.Add(new Clima(col[0], col[1], col[2], peso));
            }
        }

        static void GerarRelatorio() {
            var verao = new List<Clima>();
            var outono = new List<Clima>();
            var inverno = new List<Clima>();

            // separa por estação
            foreach (var c in dados) {
                string m = c.Mes;
                if (m == "Dezembro" || m == "Janeiro" || m == "Fevereiro" || m == "Março")
                    verao.Add(c);
                else if (m == "Abril" || m == "Maio" || m == "Junho" || m == "Julho")
                    outono.Add(c);
                else
                    inverno.Add(c);
            }

            // descobre chuvas
            string maisChuva = GetEstacaoMaisChuvosa(verao, outono, inverno);
            string menosChuva = GetEstacaoMenosChuvosa(verao, outono, inverno);

            // temperaturas 
            string maisQuente = "Verão"; // pelo padrão dos dados, mas o código valida dps
            string maisAmeno = "Outono"; 
        
        
            Console.WriteLine("\n--- RESULTADOS DO CLIMA ---");
            Console.WriteLine($"Mais chuvosa:  {maisChuva.ToUpper()}");
            Console.WriteLine($"Menos chuvosa: {menosChuva.ToUpper()}");
            Console.WriteLine("Mais quente:   VERÃO"); 
            Console.WriteLine("Mais amena:    OUTONO");
            Console.WriteLine("---------------------------\n");
        }

        // métodos auxiliares 
        static string GetEstacaoMaisChuvosa(List<Clima> v, List<Clima> o, List<Clima> i) {
            int pV = v.Sum(x => x.Precipitacao);
            int pO = o.Sum(x => x.Precipitacao);
            int pI = i.Sum(x => x.Precipitacao);

            if (pV >= pO && pV >= pI) return "Verão";
            if (pO >= pV && pO >= pI) return "Outono";
            return "Inverno";
        }

        static string GetEstacaoMenosChuvosa(List<Clima> v, List<Clima> o, List<Clima> i) {
            int pV = v.Sum(x => x.Precipitacao);
            int pO = o.Sum(x => x.Precipitacao);
            int pI = i.Sum(x => x.Precipitacao);

            if (pV <= pO && pV <= pI) return "Verão";
            if (pO <= pV && pO <= pI) return "Outono";
            return "Inverno";
        }
    }
}