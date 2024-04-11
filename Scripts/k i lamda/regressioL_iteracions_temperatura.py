import matplotlib.pyplot as plt
import numpy as np
from sklearn.linear_model import LinearRegression
from mpl_toolkits.mplot3d import Axes3D

# Datos proporcionados
K_values = np.array([5, 5, 5, 5, 5, 25, 25, 25, 25, 25, 100, 100, 100, 100, 100, 500, 500, 500, 500, 500, 1000, 1000, 1000, 1000, 1000])
lambda_values = np.array([1.0, 0.1, 0.01, 0.001, 0.0001, 1.0, 0.1, 0.01, 0.001, 0.0001, 1.0, 0.1, 0.01, 0.001, 0.0001, 1.0, 0.1, 0.01, 0.001, 0.0001, 1.0, 0.1, 0.01, 0.001, 0.0001])
temps_max = np.array([33889, 29421, 20742, 19913, 20378, 34054, 29221, 20698, 20502, 20204, 33902, 28285, 20373, 20519, 20631, 34386, 29013, 19321, 20997, 22977, 34836, 28704, 20352, 20883, 23661])

# Crear una figura 3D
fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

# Plot de los puntos de datos
ax.scatter(K_values, lambda_values, temps_max, c='blue', marker='o')

# Crear un modelo de regresión lineal múltiple
X = np.column_stack((K_values, lambda_values))
model = LinearRegression().fit(X, temps_max)

# Obtener los coeficientes de regresión
coefficients = model.coef_
intercept = model.intercept_

# Imprimir los coeficientes
print("Coeficientes de regresión:", coefficients)
print("Término independiente:", intercept)

# Plot del plano de regresión
x_surf, y_surf = np.meshgrid(np.linspace(min(lambda_values), max(lambda_values), 100),
                             np.linspace(min(K_values), max(K_values), 100))
X_surf = np.column_stack((y_surf.flatten(), x_surf.flatten()))  # Intercambiamos x e y aquí para ajustar los ejes
predicciones = model.predict(X_surf)
ax.plot_surface(y_surf, x_surf, predicciones.reshape(y_surf.shape), color='red', alpha=0.5)  # Intercambiamos x_surf y y_surf aquí

# Etiquetas y título
ax.set_xlabel('K Values')
ax.set_ylabel('Lambda Values')
ax.set_zlabel('Temp Max')
plt.title('Regresión lineal: K Values vs Lambda Values vs Temp Max')

# Definir los valores específicos para los ejes X y Y
ax.set_xticks([5, 25, 100, 500, 1000])
ax.set_yticks([0.0001, 0.001, 0.01, 0.1, 1.0])

# Mostrar gráfico
plt.show()
