# Input de los datos proporcionados

servidores = []
temps_max = []

texto = """
# de servidors = 50
El valor de la heurística per a la solució final és: 31118.0
El temps de transmisió total és: 1516822 i el temps màxim és: 31118


# de servidors = 100
El valor de la heurística per a la solució final és: 16518.0
El temps de transmisió total és: 1512875 i el temps màxim és: 16518


# de servidors = 150
El valor de la heurística per a la solució final és: 10655.0
El temps de transmisió total és: 1366101 i el temps màxim és: 10655


# de servidors = 200
El valor de la heurística per a la solució final és: 8931.0
El temps de transmisió total és: 1418328 i el temps màxim és: 8931


# de servidors = 250
El valor de la heurística per a la solució final és: 6951.0
El temps de transmisió total és: 1382083 i el temps màxim és: 6951


# de servidors = 300
El valor de la heurística per a la solució final és: 7610.0
El temps de transmisió total és: 1545233 i el temps màxim és: 7610


# de servidors = 350
El valor de la heurística per a la solució final és: 6596.0
El temps de transmisió total és: 1601266 i el temps màxim és: 6596


# de servidors = 400
El valor de la heurística per a la solució final és: 5671.0
El temps de transmisió total és: 1521766 i el temps màxim és: 5671


# de servidors = 450
El valor de la heurística per a la solució final és: 5152.0
El temps de transmisió total és: 1534941 i el temps màxim és: 5152


# de servidors = 500
El valor de la heurística per a la solució final és: 4975.0
El temps de transmisió total és: 1412752 i el temps màxim és: 4975


# de servidors = 550
El valor de la heurística per a la solució final és: 4983.0
El temps de transmisió total és: 1543931 i el temps màxim és: 4983


# de servidors = 600
El valor de la heurística per a la solució final és: 4955.0
El temps de transmisió total és: 1571661 i el temps màxim és: 4955


# de servidors = 650
El valor de la heurística per a la solució final és: 4777.0
El temps de transmisió total és: 1512895 i el temps màxim és: 4777


# de servidors = 700
El valor de la heurística per a la solució final és: 4981.0
El temps de transmisió total és: 1447866 i el temps màxim és: 4981


# de servidors = 750
El valor de la heurística per a la solució final és: 4985.0
El temps de transmisió total és: 1621738 i el temps màxim és: 4985


# de servidors = 800
El valor de la heurística per a la solució final és: 4907.0
El temps de transmisió total és: 1506272 i el temps màxim és: 4907


# de servidors = 850
El valor de la heurística per a la solució final és: 4859.0
El temps de transmisió total és: 1485722 i el temps màxim és: 4859


# de servidors = 900
El valor de la heurística per a la solució final és: 4988.0
El temps de transmisió total és: 1485342 i el temps màxim és: 4988


# de servidors = 950
El valor de la heurística per a la solució final és: 4982.0
El temps de transmisió total és: 1568236 i el temps màxim és: 4982


# de servidors = 1000
El valor de la heurística per a la solució final és: 4994.0
El temps de transmisió total és: 1493321 i el temps màxim és: 4994


# de servidors = 1050
El valor de la heurística per a la solució final és: 4566.0
El temps de transmisió total és: 1402082 i el temps màxim és: 4566


# de servidors = 1100
El valor de la heurística per a la solució final és: 4995.0
El temps de transmisió total és: 1629008 i el temps màxim és: 4995


# de servidors = 1150
El valor de la heurística per a la solució final és: 4686.0
El temps de transmisió total és: 1446580 i el temps màxim és: 4686


# de servidors = 1200
El valor de la heurística per a la solució final és: 4903.0
El temps de transmisió total és: 1592425 i el temps màxim és: 4903


# de servidors = 1250
El valor de la heurística per a la solució final és: 4873.0
El temps de transmisió total és: 1466421 i el temps màxim és: 4873


# de servidors = 1300
El valor de la heurística per a la solució final és: 4387.0
El temps de transmisió total és: 1231119 i el temps màxim és: 4387


# de servidors = 1350
El valor de la heurística per a la solució final és: 4794.0
El temps de transmisió total és: 1392836 i el temps màxim és: 4794


# de servidors = 1400
El valor de la heurística per a la solució final és: 4888.0
El temps de transmisió total és: 1494235 i el temps màxim és: 4888


# de servidors = 1450
El valor de la heurística per a la solució final és: 4989.0
El temps de transmisió total és: 1589347 i el temps màxim és: 4989


# de servidors = 1500
El valor de la heurística per a la solució final és: 4990.0
El temps de transmisió total és: 1558379 i el temps màxim és: 4990


# de servidors = 1550
El valor de la heurística per a la solució final és: 4909.0
El temps de transmisió total és: 1481784 i el temps màxim és: 4909


# de servidors = 1600
El valor de la heurística per a la solució final és: 4872.0
El temps de transmisió total és: 1465501 i el temps màxim és: 4872


# de servidors = 1650
El valor de la heurística per a la solució final és: 4989.0
El temps de transmisió total és: 1575689 i el temps màxim és: 4989


# de servidors = 1700
El valor de la heurística per a la solució final és: 4971.0
El temps de transmisió total és: 1436982 i el temps màxim és: 4971


# de servidors = 1750
El valor de la heurística per a la solució final és: 4999.0
El temps de transmisió total és: 1486977 i el temps màxim és: 4999


# de servidors = 1800
El valor de la heurística per a la solució final és: 4744.0
El temps de transmisió total és: 1413901 i el temps màxim és: 4744


# de servidors = 1850
El valor de la heurística per a la solució final és: 4924.0
El temps de transmisió total és: 1494965 i el temps màxim és: 4924


# de servidors = 1900
El valor de la heurística per a la solució final és: 4994.0
El temps de transmisió total és: 1515988 i el temps màxim és: 4994


# de servidors = 1950
El valor de la heurística per a la solució final és: 4811.0
El temps de transmisió total és: 1430475 i el temps màxim és: 4811


# de servidors = 2000
El valor de la heurística per a la solució final és: 4985.0
El temps de transmisió total és: 1523831 i el temps màxim és: 4985


# de servidors = 2050
El valor de la heurística per a la solució final és: 4884.0
El temps de transmisió total és: 1522147 i el temps màxim és: 4884


# de servidors = 2100
El valor de la heurística per a la solució final és: 4924.0
El temps de transmisió total és: 1500758 i el temps màxim és: 4924


# de servidors = 2150
El valor de la heurística per a la solució final és: 4986.0
El temps de transmisió total és: 1449939 i el temps màxim és: 4986


# de servidors = 2200
El valor de la heurística per a la solució final és: 4702.0
El temps de transmisió total és: 1425838 i el temps màxim és: 4702


# de servidors = 2250
El valor de la heurística per a la solució final és: 4696.0
El temps de transmisió total és: 1401084 i el temps màxim és: 4696


# de servidors = 2300
El valor de la heurística per a la solució final és: 4917.0
El temps de transmisió total és: 1546810 i el temps màxim és: 4917


# de servidors = 2350
El valor de la heurística per a la solució final és: 4843.0
El temps de transmisió total és: 1524797 i el temps màxim és: 4843


# de servidors = 2400
El valor de la heurística per a la solució final és: 4891.0
El temps de transmisió total és: 1456949 i el temps màxim és: 4891


# de servidors = 2450
El valor de la heurística per a la solució final és: 4930.0
El temps de transmisió total és: 1467411 i el temps màxim és: 4930


# de servidors = 2500
El valor de la heurística per a la solució final és: 4717.0
El temps de transmisió total és: 1417998 i el temps màxim és: 4717

"""

lineas = texto.split('\n')

# Iterar sobre cada línea para encontrar los valores de servidores y tiempos máximos
for linea in lineas:
    if "# de servidors" in linea:
        # Extraer el valor de servidores de la línea
        servidor = int(linea.split('=')[1].strip())
        servidores.append(servidor)
    elif "temps màxim" in linea:
        # Extraer el valor de tiempo máximo de la línea
        tiempo_max = int(linea.split(':')[2].strip())
        temps_max.append(tiempo_max)

# Imprimir los resultados
print("Valores de servidores:", servidores)
print("Valores de tiempos máximos:", temps_max)