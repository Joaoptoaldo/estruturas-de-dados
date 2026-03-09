class Gliecemia:
    def __init__(self, valor, data, hora):
        """construtor básico com os 3 atributos 

        Args:
            valor (int): de glicemia no sangue
            data (string): data da medição 
            hora (string): hora da medição
        """
        self.valor = valor
        self.data  = data
        self.hora = hora

        def __eq__(self, outro):
            if not isinstance(outro, Gliecemia):
                return False
            return self.data == outro.data and self.hora == outro.hora
        
        def __str__(self):
            return f'valor glicemia: {self.valor}, Data: {self.data}, Hora: {self.hora}'
        

        @staticmethod
        def calcular_media(lista):
            soma = 0
            for item in lista:
                soma += int(item.valor)

            return float(soma/len(lista))