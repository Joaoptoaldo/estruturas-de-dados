#ifndef FILA_H
#define FILA_H

typedef struct No {
    int valor;
    struct No* proximo;
} No;

typedef struct Fila {
    No* frente;
    No* tras;
    int tamanho;
} Fila;

Fila* criar_fila();
int enfileirar(Fila* fila, int valor);
int desenfileirar(Fila* fila);
int proximo_frente(Fila* fila);
int fila_vazia(Fila* fila);
void exibir_fila(Fila* fila);
void destruir_fila(Fila* fila);

#endif

