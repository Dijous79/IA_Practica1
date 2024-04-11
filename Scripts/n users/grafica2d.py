import matplotlib.pyplot as plt
import numpy as np

# Datos proporcionados
usuaris = [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000, 2100, 2200, 2300, 2400, 2500, 2600, 2700, 2800, 2900, 3000, 3100, 3200, 3300, 3400, 3500, 3600, 3700, 3800, 3900, 4000, 4100, 4200, 4300, 4400, 4500, 4600, 4700, 4800, 4900, 5000]
temps_max = [15745, 28366, 38836, 58541, 77262, 88694, 109038, 124460, 137889, 147019, 164090, 187223, 196606, 212471, 230094, 239705, 255688, 273544, 288748, 306272, 313541, 329923, 349847, 367347, 377580, 394346, 400846, 414239, 430923, 447255, 471400, 485243, 506769, 520818, 525633, 535599, 555524, 571579, 597613, 596866, 617990, 632116, 656227, 666173, 681455, 708333, 711479, 728342, 737939, 754883]

# Redondear los valores para reducir la cantidad de datos
usuaris_redondeados = usuaris[::4]  # Tomar una cuarta parte de los valores
temps_max_redondeados = temps_max[::4]

# Crear la gráfica
plt.figure(figsize=(10, 6))
plt.plot(usuaris_redondeados, temps_max_redondeados, marker='o', linestyle='-', color='b')
plt.title('Canvi de temps segons el nº de usuaris')
plt.xlabel('nº de usuaris')
plt.ylabel('Temps màxim individuals')
plt.grid(True)

# Personalizar ejes X e Y
plt.xticks(np.arange(0, 5001, step=500))  # Personalizar los ticks en el eje X
plt.yticks(np.arange(0, 754883, step=50000))  # Personalizar los ticks en el eje Y

plt.tight_layout()

# Mostrar la gráfica
plt.show()
