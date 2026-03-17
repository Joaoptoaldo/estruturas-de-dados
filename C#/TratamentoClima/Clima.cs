using System;

namespace SistemaClima {
    public class Clima {
        public string Ano { get; set; }
        public string Mes { get; set; }
        public string Temperatura { get; set; }
        public int Precipitacao { get; set; }

        // construtor que recebe os dados do CSV, convertendo a chuva para um peso numérico
        public Clima(string ano, string mes, string temp, int chuva) {
            Ano = ano;
            Mes = mes;
            Temperatura = temp;
            Precipitacao = chuva;
        }

        // // reescreve o toString (__str__) para mostrar os dados 
        public override string ToString() {
            // conversão simples para o print
            string txtChuva = "nada";
            if (Precipitacao == 3) txtChuva = "muita";
            else if (Precipitacao == 2) txtChuva = "média";
            else if (Precipitacao == 1) txtChuva = "pouca";

            return $"[{Ano} | {Mes}] Temp: {Temperatura}, Chuva: {txtChuva}";
        }

        // reescreve o Equals para comparar apenas Ano e Mes, ignorando temperatura e chuva
        public override bool Equals(object? obj) {
            if (obj is Clima c) {
                return Ano == c.Ano && Mes == c.Mes;
            }
            return false;
        }

        public override int GetHashCode() => HashCode.Combine(Ano, Mes);
    }
}