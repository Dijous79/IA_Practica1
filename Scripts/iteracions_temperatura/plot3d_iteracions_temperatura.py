import matplotlib.pyplot as plt
import numpy as np

# Datos proporcionados
iterations = [5000, 5000, 5000, 5000, 5000, 10000, 10000, 10000, 10000, 10000, 25000, 25000, 25000, 25000, 25000, 50000, 50000, 50000, 50000, 50000, 100000, 100000, 100000, 100000, 100000]
iterations_per_temp_change = [100, 200, 500, 1000, 2000, 100, 200, 500, 1000, 2000, 100, 200, 500, 1000, 2000, 100, 200, 500, 1000, 2000, 100, 200, 500, 1000, 2000]
temps_max = [31674, 31301, 31608, 32000, 31986, 28670, 29322, 29381, 30733, 29107, 23736, 23919, 23773, 23765, 24357, 20110, 20264, 20778, 21229, 20715, 17065, 17559, 17602, 17795, 17211]

# Redondear valores de temps_max en tramos
temps_max_bins = np.round(temps_max, -3)

# Crear la figura
fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

# Mapear los valores de iterations a un rango específico
x_values = np.array([5000, 10000, 25000, 50000, 100000])
x_mapping = {val: idx for idx, val in enumerate(x_values)}
iterations_mapped = [x_mapping[val] for val in iterations]

# Mapear los valores de iterations_per_temp_change a un rango específico
y_values = np.array([100, 200, 500, 1000, 2000])
y_mapping = {val: idx for idx, val in enumerate(y_values)}
iterations_per_temp_change_mapped = [y_mapping[val] for val in iterations_per_temp_change]

# Colores para las barras en función de los valores de iterations_per_temp_change
colors = ['r', 'g', 'b', 'y', 'm']

# Crear las barras con colores diferentes para cada categoría de valores de iterations_per_temp_change
for i in range(len(iterations)):
    x = iterations_mapped[i]
    y = iterations_per_temp_change_mapped[i]
    z = temps_max_bins[i]
    ax.bar3d(x, y, 0, 1, 1, z, color=colors[y], zsort='average')

# Configuración de etiquetas y título
ax.set_xticks(range(len(x_values)))
ax.set_xticklabels(x_values)
ax.set_xlabel('Iterations')
ax.set_yticks(range(len(y_values)))
ax.set_yticklabels(y_values)
ax.set_ylabel('Iterations per Temp Change')
ax.set_zlabel('Temp Max (rounded)')
ax.set_title('3D Bar Plot')

# Mostrar la gráfica
plt.show()