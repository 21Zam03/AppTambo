import pandas as pd
#from math import sqrt 
import numpy as np
#import matplotlib.pyplot as plt

#Obtenemos el perfil de los datos del usuario
data_usuario = pd.read_json('C:/ZamProjects2023/Tambo/Cliente - productos.json')

#Obtenemos los datos de los productos 
data_producto = pd.read_json('C:/ZamProjects2023/Tambo/Productos.json')

#Obtenemos los datos one hot de los productos
data_producto_categorica = data_producto['categoria'].tolist()

#Obtenemos los nombres de los productos
data_producto_nombres = data_producto['nombre'].tolist()

#ALGORITMO DE FACTORIZACION DE MATRICES - MACHINE LEARNING
#Creamos la matriz peso
matriz_peso = data_usuario['numero_compras'].astype(float).tolist()

#Creamos la matriz categorica usando la tecnica one hot
matriz_categorica = data_usuario['categoria'].tolist()

#Multiplicamos ambas matrices para usando la libreria numpy
array_lista = np.array(matriz_categorica)
array_vector = np.array(matriz_peso)
resultado = array_lista * array_vector[:, np.newaxis]

#Obtenemos el vector suma de pesos*datos de one hot
array_resultado = np.array(resultado)
vector_suma = np.sum(array_resultado, axis=0)
suma_total = sum(vector_suma)

#Transformamos los datos en escala numerica de 0 a 1
vector_dividido = [num/19 for num in vector_suma]

#Multiplicamos los datos en escala numerica * los datos categoricos one hot
array_divido = np.array(vector_dividido)
array_categoria = np.array(data_producto_categorica)
resultado_final = np.multiply(array_divido, array_categoria[:, np.newaxis])

#Sumamos todos los datos de las filas de la matriz final y lo aproximamos a 2 decimales
suma_filas = np.sum(resultado_final, axis=2)
suma_filas_aproximado = np.round(suma_filas, decimals=2)

#Combinamos la matriz nombres con el vector suma filas
vector_combinado = list(zip(data_producto_nombres, suma_filas_aproximado))
#print(vector_combinado)

#Dividimos el vector de 180 productos en sublistas de 30 productos cada una
listas_divididas = [vector_combinado[i:i+20] for i in range(0, len(vector_combinado), 20)]
nueva_lista = [listas_divididas[i:i+9] for i in range(0, len(listas_divididas), 9)]

#lista1
lista_1 = nueva_lista[0][0]
df = pd.DataFrame(lista_1)
df = df.iloc[0:]
lista_1n = df.values.tolist()
lista_1n.sort(key=lambda x: x[1], reverse=True)
nuevo_array = lista_1n[:3]

#lista2
lista_2 = nueva_lista[0][1]
df = pd.DataFrame(lista_2)
df = df.iloc[0:]
lista_2n = df.values.tolist()
lista_2n.sort(key=lambda x: x[1], reverse=True)
lista_dis_2 = lista_2n[:3]
nuevo_array = np.concatenate((nuevo_array, lista_dis_2), axis=0)

#lista3
lista_3 = nueva_lista[0][2]
df = pd.DataFrame(lista_3)
df = df.iloc[0:]
lista_3n = df.values.tolist()
lista_3n.sort(key=lambda x: x[1], reverse=True)
lista_dis_3 = lista_3n[:3]
nuevo_array = np.concatenate((nuevo_array, lista_dis_3), axis=0)

#lista4
lista_4 = nueva_lista[0][3]
df = pd.DataFrame(lista_4)
df = df.iloc[0:]
lista_4n = df.values.tolist()
lista_4n.sort(key=lambda x: x[1], reverse=True)
lista_dis_4 = lista_4n[:3]
nuevo_array = np.concatenate((nuevo_array, lista_dis_4), axis=0)

#lista5
lista_5 = nueva_lista[0][4]
df = pd.DataFrame(lista_5)
df = df.iloc[0:]
lista_5n = df.values.tolist()
lista_5n.sort(key=lambda x: x[1], reverse=True)
lista_dis_5 = lista_5n[:3]
nuevo_array = np.concatenate((nuevo_array, lista_dis_5), axis=0)

#lista6
lista_6 = nueva_lista[0][5]
df = pd.DataFrame(lista_6)
df = df.iloc[0:]
lista_6n = df.values.tolist()
lista_6n.sort(key=lambda x: x[1], reverse=True)
lista_dis_6 = lista_6n[:3]
nuevo_array = np.concatenate((nuevo_array, lista_dis_6), axis=0)

#lista7
lista_7 = nueva_lista[0][6]
df = pd.DataFrame(lista_7)
df = df.iloc[0:]
lista_7n = df.values.tolist()
lista_7n.sort(key=lambda x: x[1], reverse=True)
lista_dis_7 = lista_7n[:3]
nuevo_array = np.concatenate((nuevo_array, lista_dis_7), axis=0)

#lista8
lista_8 = nueva_lista[0][7]
df = pd.DataFrame(lista_8)
df = df.iloc[0:]
lista_8n = df.values.tolist()
lista_8n.sort(key=lambda x: x[1], reverse=True)
lista_dis_8 = lista_8n[:3]
nuevo_array = np.concatenate((nuevo_array, lista_dis_8), axis=0)

#lista9
lista_9 = nueva_lista[0][8]
df = pd.DataFrame(lista_9)
df = df.iloc[0:]
lista_9n = df.values.tolist()
lista_9n.sort(key=lambda x: x[1], reverse=True)
lista_dis_9 = lista_9n[:3]
nuevo_array = np.concatenate((nuevo_array, lista_dis_9), axis=0)

#Eliminamos los datos con 0
nuevo_array = [fila for fila in nuevo_array if fila[1] != 0]

#Creamos el archivo json
data_transformed = [(producto, peso[0]) for producto, peso in nuevo_array]
df = pd.DataFrame(data_transformed, columns=['Producto', 'Peso'])
df = df.sort_values('Peso', ascending=False)
df.to_json("C:/ZamProjects2023/Tambo/productos recomendados.json", orient="records", force_ascii=False)
print("Se guardo")
