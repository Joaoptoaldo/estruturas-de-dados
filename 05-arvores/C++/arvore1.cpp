#include <iostream>
#include <cstdlib>
 
using namespace std;
 
typedef struct no {
    int valor;
    struct no  *esq;
    struct no *dir;
} Arvore;
 
// metodo inserir recursivo em arvore binaria de pesquisa = ORDENADO
Arvore *inserir(int valor, Arvore *raiz) {
    if (raiz) {
        if (valor < raiz->valor) { //ir para esquerda
            raiz->esq = inserir(valor, raiz->esq);
        } else { //ir para direita
            raiz->dir = inserir(valor, raiz->dir);
        }
        return raiz;
    } else {
        Arvore *novo;
        novo = (Arvore *)malloc(sizeof(Arvore));
        novo->valor = valor;
        novo->esq = NULL;
        novo->dir = NULL;
        return novo;
    }
}
 
void red(Arvore *raiz) {
    if (raiz) {
        cout << raiz->valor << "\t";
        red(raiz->esq);
        red(raiz->dir);
    }
}
 
void erd(Arvore *raiz) {
    if (raiz) {
        erd(raiz->esq);
        cout << raiz->valor << "\t";
        erd(raiz->dir);
    }
}
 
void edr(Arvore *raiz) {
    if (raiz) {
        edr(raiz->esq);
        edr(raiz->dir);
        cout << raiz->valor << "\t";
    }
}
 
int main() {
    Arvore *raiz = NULL;
    raiz = inserir(100,raiz);
    raiz = inserir(50,raiz);
    raiz = inserir(150,raiz);
    //red(raiz);
    //erd(raiz);
    edr(raiz);
 
 
    return 1;
}