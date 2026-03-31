#include <iostream>
#include "fila.h"

using namespace std;

int main() {
    Fila* fila = criar_fila();
    
    cout << "--- DEMO FILA (FIFO) ---" << endl;
    
    // Enfileirar (adiciona no tras)
    enfileirar(fila, 10);
    enfileirar(fila, 20);
    enfileirar(fila, 30);
    exibir_fila(fila);  // 10 20 30
    
    cout << "Proximo frente: " << proximo_frente(fila) << endl;  // 10
    
    desenfileirar(fila);
    exibir_fila(fila);  // 20 30
    
    cout << "Tamanho: " << fila->tamanho << endl;
    cout << "Vazia? " << (fila_vazia(fila) ? "Sim" : "Nao") << endl;
    
    destruir_fila(fila);
    return 0;
}

