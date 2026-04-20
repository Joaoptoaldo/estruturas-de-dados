import random

def exibir_lista(lista, n):
    for i in  range(0,len(lista)):
        print(lista[i])
        
def exibir_lista_r(lista, n):
    if (n >= 1):
        exibir_lista_r(lista, n-1)
        print(lista[n-1]) #esta sendo executado no desempilhamento

def popular_lista_r(lista, qtd): #sem recursão
    for i in range(0, qtd):
        lista.append(random.randint(0, 100))

def popular_lista_r(lista, qtd): #com recursão
    if (qtd > 1):
        lista.append(random.randint(0, 100))
        popular_lista_r(lista, qtd-1)
        print(lista, qtd-1)
        
def exibir_pares_r(lista, n):
    if (n >= 1):
        exibir_pares_r(lista, n-1)
        if (lista[n-1] % 2 == 0):
            print(lista[n-1]) #esta sendo executado no desempilhamento

lista = [10, 20, 30, 40, 50]
popular_lista_r(lista, 5) #de forma recursiva 
exibir_lista(lista, len(lista)) 
exibir_pares_r(lista, len(lista))