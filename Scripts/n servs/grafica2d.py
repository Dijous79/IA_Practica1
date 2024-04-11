import matplotlib.pyplot as plt
import numpy as np

# Datos proporcionados
servidores = [50, 100, 150, 200, 250, 300, 350, 400, 450, 500, 550, 600, 650, 700, 750, 800, 850, 900, 950, 1000, 1050, 1100, 1150, 1200, 1250, 1300, 1350, 1400, 1450, 1500, 1550, 1600, 1650, 1700, 1750, 1800, 1850, 1900, 1950, 2000, 2050, 2100, 2150, 2200, 2250, 2300, 2350, 2400, 2450, 2500]
temps_max = [31118, 16518, 10655, 8931, 6951, 7610, 6596, 5671, 5152, 4975, 4983, 4955, 4777, 4981, 4985, 4907, 4859, 4988, 4982, 4994, 4566, 4995, 4686, 4903, 4873, 4387, 4794, 4888, 4989, 4990, 4909, 4872, 4989, 4971, 4999, 4744, 4924, 4994, 4811, 4985, 4884, 4924, 4986, 4702, 4696, 4917, 4843, 4891, 4930, 4717]

# Redondear los valores para reducir la cantidad de datos
servidores_redondeados = servidores[::4]  # Tomar una cuarta parte de los valores
temps_max_redondeados = temps_max[::4]

# Crear la gráfica
plt.figure(figsize=(10, 6))
plt.plot(servidores_redondeados, temps_max_redondeados, marker='o', linestyle='-', color='b')
plt.title('Canvi de temps segons el nº de servidors')
plt.xlabel('nº de servidors')
plt.ylabel('Temps màxim individuals')
plt.grid(True)

# Personalizar ejes X e Y
plt.xticks(np.arange(0, 2001, step=200))  # Personalizar los ticks en el eje X
plt.yticks(np.arange(5000, 30001, step=5000))  # Personalizar los ticks en el eje Y

plt.tight_layout()

# Mostrar la gráfica
plt.show()
