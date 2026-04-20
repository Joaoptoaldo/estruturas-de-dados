using System;
using System.Collections.Generic;

namespace ListasSimples
{
    class Program
    {
        static void Main(string[] args)
        {
            // Exemplo simples de lista de inteiros
            List<int> numeros = new List<int>();
            
            // Adicionando elementos manualmente
            numeros.Add(5);
            numeros.Add(10);
            numeros.Add(15);
            numeros.Add(20);

            Console.WriteLine("Elementos da lista:");
            for (int i = 0; i < numeros.Count; i++)
            {
                Console.WriteLine($"Posição {i}: {numeros[i]}");
            }

            // Removendo um elemento
            numeros.Remove(10);
            Console.WriteLine("\nApós remover o número 10:");
            foreach (int n in numeros)
            {
                Console.WriteLine(n);
            }

            // Procurando um elemento
            int busca = 15;
            if (numeros.Contains(busca))
            {
                Console.WriteLine($"\nA lista contém o número {busca}.");
            }
            else
            {
                Console.WriteLine($"\nO número {busca} não está na lista.");
            }
        }
    }
}
