#include <iostream>
#include <ctime>
#include <cstdlib>
 
#define TAM 5
 
using namespace std;
 
void popularVetor(int vetor[], int n) {
    for (int i = 0; i < n; i++) {
        vetor[i] = rand() % 100;
    }
}
 
void popularVetorR(int vetor[], int n) {
    if (n >= 1) {
        vetor[n - 1] = rand() % 100;
        popularVetorR(vetor, n - 1);        
    }
}
 
void exibirVetor(int vetor[], int n) {
    for (int i = 0; i < n; i++) {
        cout << vetor[i] << endl;
    }
}
 
void exibirVetorR(int vetor[], int n) {
    if (n >= 1) {
        exibirVetorR(vetor, n - 1);
        cout << (n-1) << ") " << vetor[n - 1] << endl; //esta sendo executado no desempilhamento
    }
}
 
int main() {
    int vetor[TAM];
    srand(time(NULL));
 
    popularVetorR(vetor,TAM);
    exibirVetorR(vetor, TAM);
 
    return 1;
}