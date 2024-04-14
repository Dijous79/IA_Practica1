import matplotlib.pyplot as plt
import numpy as np
from sklearn.linear_model import LinearRegression
from mpl_toolkits.mplot3d import Axes3D

# Datos proporcionados
iterations = np.array([5000, 5000, 5000, 5000, 5000, 10000, 10000, 10000, 10000, 10000, 25000, 25000, 25000, 25000, 25000, 50000, 50000, 50000, 50000, 50000, 100000, 100000, 100000, 100000, 100000])
iterations_per_temp_change = np.array([100, 200, 500, 1000, 2000, 100, 200, 500, 1000, 2000, 100, 200, 500, 1000, 2000, 100, 200, 500, 1000, 2000, 100, 200, 500, 1000, 2000])
temps_max = np.array([31674, 31301, 31608, 32000, 31986, 28670, 29322, 29381, 30733, 29107, 23736, 23919, 23773, 23765, 24357, 20110, 20264, 20778, 21229, 20715, 17065, 17559, 17602, 17795, 17211])

# Crear una figura 3D
fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

# Plot de los puntos de datos
ax.scatter(iterations, iterations_per_temp_change, temps_max, c='blue', marker='o')

# Crear un modelo de regresión lineal múltiple
X = np.column_stack((iterations, iterations_per_temp_change))
model = LinearRegression().fit(X, temps_max)

# Obtener los coeficientes de regresión
coefficients = model.coef_
intercept = model.intercept_

# Imprimir los coeficientes
print("Coeficientes de regresión:", coefficients)
print("Término independiente:", intercept)

# Plot del plano de regresión
x_surf, y_surf = np.meshgrid(np.linspace(iterations.min(), iterations.max(), 100),
                             np.linspace(iterations_per_temp_change.min(), iterations_per_temp_change.max(), 100))
X_surf = np.column_stack((x_surf.flatten(), y_surf.flatten()))
predicciones = model.predict(X_surf)
ax.plot_surface(x_surf, y_surf, predicciones.reshape(x_surf.shape), color='red', alpha=0.5)

# Etiquetas y título
ax.set_xlabel('Iterations')
ax.set_ylabel('Iterations per Temp Change')
ax.set_zlabel('Temp Max')
plt.title('Regresión lineal: Iterations vs Iterations per Temp Change vs Temp Max')

# Mostrar gráfico
plt.show()
