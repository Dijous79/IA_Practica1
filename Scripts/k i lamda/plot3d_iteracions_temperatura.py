import matplotlib.pyplot as plt
import numpy as np

# Datos proporcionados
K_values = [5, 5, 5, 5, 5, 25, 25, 25, 25, 25, 100, 100, 100, 100, 100, 500, 500, 500, 500, 500, 1000, 1000, 1000, 1000, 1000]
lambda_values = [1.0, 0.1, 0.01, 0.001, 0.0001, 1.0, 0.1, 0.01, 0.001, 0.0001, 1.0, 0.1, 0.01, 0.001, 0.0001, 1.0, 0.1, 0.01, 0.001, 0.0001, 1.0, 0.1, 0.01, 0.001, 0.0001]
temps_max = [33889, 29421, 20742, 19913, 20378, 34054, 29221, 20698, 20502, 20204, 33902, 28285, 20373, 20519, 20631, 34386, 29013, 19321, 20997, 22977, 34836, 28704, 20352, 20883, 23661]

# Redondear valores de temps_max en tramos
temps_max_bins = np.round(temps_max, -3)

# Crear la figura
fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

# Mapear los valores de lambda_values a un rango específico
x_values = np.array([1.0, 0.1, 0.01, 0.001, 0.0001])
x_mapping = {val: idx for idx, val in enumerate(x_values)}
lambda_values_mapped = [x_mapping[val] for val in lambda_values]

# Mapear los valores de K_values a un rango específico
y_values = np.array([5, 25, 100, 500, 1000])
y_mapping = {val: idx for idx, val in enumerate(y_values)}
K_values_mapped = [y_mapping[val] for val in K_values]

# Colores para las barras en función de los valores de K_values
colors = ['r', 'g', 'b', 'y', 'm']

# Crear las barras con colores diferentes para cada categoría de valores de K_values
for i in range(len(lambda_values)):
    x = lambda_values_mapped[i]
    y = K_values_mapped[i]
    z = temps_max_bins[i]
    ax.bar3d(x, y, 0, 1, 1, z, color=colors[y_mapping[K_values[i]]], zsort='average')

# Configuración de etiquetas y título
ax.set_xticks(range(len(x_values)))
ax.set_xticklabels(x_values)
ax.set_xlabel('Lambda Values')
ax.set_yticks(range(len(y_values)))
ax.set_yticklabels(y_values)
ax.set_ylabel('K Values')
ax.set_zlabel('Temp Max (rounded)')
ax.set_title('3D Bar Plot')

# Mostrar la gráfica
plt.show()
