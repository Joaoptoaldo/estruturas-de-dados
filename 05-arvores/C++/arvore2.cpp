#include <iostream>
#include <cstdlib>
#include <ctime>
 
using namespace std;
 
typedef struct no {
    int valor;
    struct no  *esq;
    struct no *dir;
} Arvore;
 
// metodo inserir recursivo em arvore binaria de pesquisa = ORDENADO
Arvore *inserir(int valor, Arvore *raiz) {
    if (raiz) {
        // controle de replicados
        if (valor == raiz->valor) return raiz;
 
        if (valor < raiz->valor) { //ir para esquerda
            raiz->esq = inserir(valor, raiz->esq);
        } else { // ir para direita
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
 
void exibir(int nivel, Arvore *raiz) {
    if (raiz) {
        exibir(nivel + 1, raiz->dir);
 
        for (int i = 0; i < nivel; i++) {
            cout << "   ";
        }
        cout << raiz->valor << "(" << nivel << ")\n";
 
        exibir(nivel + 1, raiz->esq);
    }
}

 // metodo para contar o numero de elementos da arvore
int contar(Arvore *raiz) {
    if (raiz) {
        return 1 + contar(raiz->esq) + contar(raiz->dir);
    }
    return 0;
}
 
int main() {
    Arvore *raiz = NULL;
    srand(time(NULL));
    for (int i = 0; i < 10; i++) {
        raiz = inserir(rand() % 30, raiz);
    }
 
    exibir(0,raiz);
    cout << "Total de elementos: " << contar(raiz) << "\n";
 
    return 1;
}