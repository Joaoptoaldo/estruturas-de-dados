#include<iostream>

using namespace std;

typedef struct No{
    int valor;
    No* proximo;
}Celula;

// metodo para inserir um elemento no inicio da lista
Celula * inserir(int valor, Celula * lista){
    Celula * novo = new Celula;
    novo = (Celula*)malloc(sizeof(Celula));

    novo->valor = valor;
    novo->proximo = lista;

    return novo;
}

// metodo para contar a quantidade de elementos da lista
void contar(Celula * lista){
    Celula * atual = lista;
    int contador = 0;

    while(atual != nullptr){
        contador++;
        atual = atual->proximo;
    }

    cout << "Quantidade de elementos: " << contador << endl;
}

// metodo para exibir os elementos da lista
void exibir(Celula * lista){
    Celula * atual = lista;

    while(atual != nullptr){
        cout << atual->valor << " ";
        atual = atual->proximo;
    }
    cout << endl;
}

// metodo para remover um elemento da lista
Celula * remover(int valor, Celula * lista){
    if(!lista) return lista;

    Celula * atual = lista;

    for(Celula * anterior = nullptr; atual != nullptr; anterior = atual, atual = atual->proximo){
        if(atual->valor == valor){
            if(anterior) anterior->proximo = atual->proximo;
            else lista = atual->proximo;

            free(atual);
            return lista;
        }
    }
}


// Celula * remover(int valor, Celula * lista){
//     Celula * atual = lista;
//     Celula * anterior = nullptr;

//     while(atual != nullptr){
//         if(atual->valor == valor){
//             if(anterior == nullptr){
//                 lista = atual->proximo;
//             } else {
//                 anterior->proximo = atual->proximo;
//             }
//             free(atual);
//             return lista;
//         }
//         anterior = atual;
//         atual = atual->proximo;
//     }
//     return lista;
// }

// Celula* criarNo(int valor){
//     Celula* novo = new Celula;
//     novo->valor = valor;
//     novo->proximo = nullptr;
//     return novo;
// }