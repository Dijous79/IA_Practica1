# Input de los datos proporcionados

usuaris = []
temps_max = []

texto = """
# d'usuaris = 100
El valor de la heurística per a la solució final és: 15745.0
El temps de transmisió total és: 716935 i el temps màxim és: 15745


# d'usuaris = 200
El valor de la heurística per a la solució final és: 28366.0
El temps de transmisió total és: 1376221 i el temps màxim és: 28366


# d'usuaris = 300
El valor de la heurística per a la solució final és: 38836.0
El temps de transmisió total és: 1899952 i el temps màxim és: 38836


# d'usuaris = 400
El valor de la heurística per a la solució final és: 58541.0
El temps de transmisió total és: 2878325 i el temps màxim és: 58541


# d'usuaris = 500
El valor de la heurística per a la solució final és: 77262.0
El temps de transmisió total és: 3811066 i el temps màxim és: 77262


# d'usuaris = 600
El valor de la heurística per a la solució final és: 88694.0
El temps de transmisió total és: 4389445 i el temps màxim és: 88694


# d'usuaris = 700
El valor de la heurística per a la solució final és: 109038.0
El temps de transmisió total és: 5403566 i el temps màxim és: 109038


# d'usuaris = 800
El valor de la heurística per a la solució final és: 124460.0
El temps de transmisió total és: 6163399 i el temps màxim és: 124460


# d'usuaris = 900
El valor de la heurística per a la solució final és: 137889.0
El temps de transmisió total és: 6836632 i el temps màxim és: 137889


# d'usuaris = 1000
El valor de la heurística per a la solució final és: 147019.0
El temps de transmisió total és: 7296920 i el temps màxim és: 147019


# d'usuaris = 1100
El valor de la heurística per a la solució final és: 164090.0
El temps de transmisió total és: 8164492 i el temps màxim és: 164090


# d'usuaris = 1200
El valor de la heurística per a la solució final és: 187223.0
El temps de transmisió total és: 9297735 i el temps màxim és: 187223


# d'usuaris = 1300
El valor de la heurística per a la solució final és: 196606.0
El temps de transmisió total és: 9780581 i el temps màxim és: 196606


# d'usuaris = 1400
El valor de la heurística per a la solució final és: 212471.0
El temps de transmisió total és: 10564971 i el temps màxim és: 212471


# d'usuaris = 1500
El valor de la heurística per a la solució final és: 230094.0
El temps de transmisió total és: 11446572 i el temps màxim és: 230094


# d'usuaris = 1600
El valor de la heurística per a la solució final és: 239705.0
El temps de transmisió total és: 11917703 i el temps màxim és: 239705


# d'usuaris = 1700
El valor de la heurística per a la solució final és: 255688.0
El temps de transmisió total és: 12732654 i el temps màxim és: 255688


# d'usuaris = 1800
El valor de la heurística per a la solució final és: 273544.0
El temps de transmisió total és: 13617307 i el temps màxim és: 273544


# d'usuaris = 1900
El valor de la heurística per a la solució final és: 288748.0
El temps de transmisió total és: 14397058 i el temps màxim és: 288748


# d'usuaris = 2000
El valor de la heurística per a la solució final és: 306272.0
El temps de transmisió total és: 15264558 i el temps màxim és: 306272


# d'usuaris = 2100
El valor de la heurística per a la solució final és: 313541.0
El temps de transmisió total és: 15632574 i el temps màxim és: 313541


# d'usuaris = 2200
El valor de la heurística per a la solució final és: 329923.0
El temps de transmisió total és: 16432325 i el temps màxim és: 329923


# d'usuaris = 2300
El valor de la heurística per a la solució final és: 349847.0
El temps de transmisió total és: 17440874 i el temps màxim és: 349847


# d'usuaris = 2400
El valor de la heurística per a la solució final és: 367347.0
El temps de transmisió total és: 18319995 i el temps màxim és: 367347


# d'usuaris = 2500
El valor de la heurística per a la solució final és: 377580.0
El temps de transmisió total és: 18824006 i el temps màxim és: 377580


# d'usuaris = 2600
El valor de la heurística per a la solució final és: 394346.0
El temps de transmisió total és: 19661160 i el temps màxim és: 394346


# d'usuaris = 2700
El valor de la heurística per a la solució final és: 400846.0
El temps de transmisió total és: 19990599 i el temps màxim és: 400846


# d'usuaris = 2800
El valor de la heurística per a la solució final és: 414239.0
El temps de transmisió total és: 20675573 i el temps màxim és: 414239


# d'usuaris = 2900
El valor de la heurística per a la solució final és: 430923.0
El temps de transmisió total és: 21507098 i el temps màxim és: 430923


# d'usuaris = 3000
El valor de la heurística per a la solució final és: 447255.0
El temps de transmisió total és: 22301515 i el temps màxim és: 447255


# d'usuaris = 3100
El valor de la heurística per a la solució final és: 471400.0
El temps de transmisió total és: 23423434 i el temps màxim és: 471400


# d'usuaris = 3200
El valor de la heurística per a la solució final és: 485243.0
El temps de transmisió total és: 24206460 i el temps màxim és: 485243


# d'usuaris = 3300
El valor de la heurística per a la solució final és: 506769.0
El temps de transmisió total és: 25293750 i el temps màxim és: 506769


# d'usuaris = 3400
El valor de la heurística per a la solució final és: 520818.0
El temps de transmisió total és: 25998480 i el temps màxim és: 520818


# d'usuaris = 3500
El valor de la heurística per a la solució final és: 525633.0
El temps de transmisió total és: 26203961 i el temps màxim és: 525633


# d'usuaris = 3600
El valor de la heurística per a la solució final és: 535599.0
El temps de transmisió total és: 26729230 i el temps màxim és: 535599


# d'usuaris = 3700
El valor de la heurística per a la solució final és: 555524.0
El temps de transmisió total és: 27736547 i el temps màxim és: 555524


# d'usuaris = 3800
El valor de la heurística per a la solució final és: 571579.0
El temps de transmisió total és: 28530664 i el temps màxim és: 571579


# d'usuaris = 3900
El valor de la heurística per a la solució final és: 597613.0
El temps de transmisió total és: 29823703 i el temps màxim és: 597613


# d'usuaris = 4000
El valor de la heurística per a la solució final és: 596866.0
El temps de transmisió total és: 29767732 i el temps màxim és: 596866


# d'usuaris = 4100
El valor de la heurística per a la solució final és: 617990.0
El temps de transmisió total és: 30844759 i el temps màxim és: 617990


# d'usuaris = 4200
El valor de la heurística per a la solució final és: 632116.0
El temps de transmisió total és: 31544711 i el temps màxim és: 632116


# d'usuaris = 4300
El valor de la heurística per a la solució final és: 656227.0
El temps de transmisió total és: 32750088 i el temps màxim és: 656227


# d'usuaris = 4400
El valor de la heurística per a la solució final és: 666173.0
El temps de transmisió total és: 33263872 i el temps màxim és: 666173


# d'usuaris = 4500
El valor de la heurística per a la solució final és: 681455.0
El temps de transmisió total és: 34029171 i el temps màxim és: 681455


# d'usuaris = 4600
El valor de la heurística per a la solució final és: 708333.0
El temps de transmisió total és: 35344669 i el temps màxim és: 708333


# d'usuaris = 4700
El valor de la heurística per a la solució final és: 711479.0
El temps de transmisió total és: 35523849 i el temps màxim és: 711479


# d'usuaris = 4800
El valor de la heurística per a la solució final és: 728342.0
El temps de transmisió total és: 36379107 i el temps màxim és: 728342


# d'usuaris = 4900
El valor de la heurística per a la solució final és: 737939.0
El temps de transmisió total és: 36853285 i el temps màxim és: 737939


# d'usuaris = 5000
El valor de la heurística per a la solució final és: 754883.0
El temps de transmisió total és: 37692387 i el temps màxim és: 754883

"""

lineas = texto.split('\n')

# Iterar sobre cada línea para encontrar los valores de servidores y tiempos máximos
for linea in lineas:
    if "usuaris" in linea:
        # Extraer el valor de servidores de la línea
        usuari = int(linea.split('=')[1].strip())
        usuaris.append(usuari)
    elif "temps màxim" in linea:
        # Extraer el valor de tiempo máximo de la línea
        tiempo_max = int(linea.split(':')[2].strip())
        temps_max.append(tiempo_max)

# Imprimir los resultados
print("Valores de usuarios:", usuaris)
print("Valores de tiempos máximos:", temps_max)