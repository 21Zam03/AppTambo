import pandas as pd
#Obtenemos los datos de los productos 
data_producto = pd.read_json('C:/ZamProjects2023/Tambo/Productos.json')

listas_divididas = [data_producto[i:i+20] for i in range(0, len(data_producto), 20)]
nueva_lista = [listas_divididas[i:i+9] for i in range(0, len(listas_divididas), 9)]
print(nueva_lista)

# Imprimir las listas divididas
#for i, lista in enumerate(listas_divididas):
#    print(f"Lista {i+1}: {lista}")