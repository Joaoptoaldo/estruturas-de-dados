#include <iostream>
#include "fila.h"
#include <cstdlib>

using namespace std;

Fila* criar_fila() {
    Fila* fila = (Fila*)malloc(sizeof(Fila));
    fila->frente = nullptr;
    fila->tras = nullptr;
    fila->tamanho = 0;
    return fila;
}

int enfileirar(Fila* fila, int valor) {
    No* novo = (No*)malloc(sizeof(No));
    novo->valor = valor;
    novo->proximo = nullptr;
    
    if (fila_vazia(fila)) {
        fila->frente = novo;
        fila->tras = novo;
    } else {
        fila->tras->proximo = novo;
        fila->tras = novo;
    }
    fila->tamanho++;
    return 1;
}

int desenfileirar(Fila* fila) {
    if (fila_vazia(fila)) return 0;
    
    No* temp = fila->frente;
    fila->frente = fila->frente->proximo;
    free(temp);
    fila->tamanho--;
    
    if (fila_vazia(fila)) {
        fila->tras = nullptr;
    }
    return 1;
}

int proximo_frente(Fila* fila) {
    if (fila_vazia(fila)) return -1;
    return fila->frente->valor;
}

int fila_vazia(Fila* fila) {
    return fila->tamanho == 0;
}

void exibir_fila(Fila* fila) {
    cout << "Fila (frente -> tras): ";
    No* atual = fila->frente;
    while (atual != nullptr) {
        cout << atual->valor << " ";
        atual = atual->proximo;
    }
    cout << endl;
}

void destruir_fila(Fila* fila) {
    while (!fila_vazia(fila)) {
        desenfileirar(fila);
    }
    
    free(fila);
}

