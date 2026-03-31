#include <iostream>
#include "colecao.cpp"

using namespace std;

int main(){
    Celula* lista = nullptr;

    lista = inserir(10, lista);
    lista = inserir(20, lista);
    lista = inserir(30, lista);

    exibir(lista);
    contar(lista);

    return 0;
}