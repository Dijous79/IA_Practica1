
def filtrar_datos(entrada):
    lines = entrada.strip().split('\n')
    
    iterations = []
    iterations_per_temp_change = []
    temps_max = []
    
    for line in lines:
        if line.startswith("Iterations:"):
            iterations.append(int(line.split(":")[1].strip()))
        elif line.startswith("IterationsPerTempChange:"):
            iterations_per_temp_change.append(int(line.split(":")[1].strip()))
        elif line.startswith("El temps de transmisió total és:"):
            temps_max.append(int(line.split(":")[2].strip().split()[0]))
    
    return iterations, iterations_per_temp_change, temps_max

entrada = """
Iterations: 5000
IterationsPerTempChange: 100
K: 500
Lambda: 0.001
nodesExpanded : 5001
El temps de transmisió total és: 1409808 i el temps màxim és: 31674

Iterations: 5000
IterationsPerTempChange: 200
K: 500
Lambda: 0.001
nodesExpanded : 5001
El temps de transmisió total és: 1324930 i el temps màxim és: 31301

Iterations: 5000
IterationsPerTempChange: 500
K: 500
Lambda: 0.001
nodesExpanded : 5001
El temps de transmisió total és: 1443685 i el temps màxim és: 31608

Iterations: 5000
IterationsPerTempChange: 1000
K: 500
Lambda: 0.001
nodesExpanded : 5001
El temps de transmisió total és: 1403189 i el temps màxim és: 32000

Iterations: 5000
IterationsPerTempChange: 2000
K: 500
Lambda: 0.001
nodesExpanded : 5001
El temps de transmisió total és: 1368686 i el temps màxim és: 31986

Iterations: 10000
IterationsPerTempChange: 100
K: 500
Lambda: 0.001
nodesExpanded : 10001
El temps de transmisió total és: 1299606 i el temps màxim és: 28670

Iterations: 10000
IterationsPerTempChange: 200
K: 500
Lambda: 0.001
nodesExpanded : 10001
El temps de transmisió total és: 1310304 i el temps màxim és: 29322

Iterations: 10000
IterationsPerTempChange: 500
K: 500
Lambda: 0.001
nodesExpanded : 10001
El temps de transmisió total és: 1307448 i el temps màxim és: 29381

Iterations: 10000
IterationsPerTempChange: 1000
K: 500
Lambda: 0.001
nodesExpanded : 10001
El temps de transmisió total és: 1354750 i el temps màxim és: 30733

Iterations: 10000
IterationsPerTempChange: 2000
K: 500
Lambda: 0.001
nodesExpanded : 10001
El temps de transmisió total és: 1276108 i el temps màxim és: 29107

Iterations: 25000
IterationsPerTempChange: 100
K: 500
Lambda: 0.001
nodesExpanded : 25001
El temps de transmisió total és: 1098409 i el temps màxim és: 23736

Iterations: 25000
IterationsPerTempChange: 200
K: 500
Lambda: 0.001
nodesExpanded : 25001
El temps de transmisió total és: 1109224 i el temps màxim és: 23919

Iterations: 25000
IterationsPerTempChange: 500
K: 500
Lambda: 0.001
nodesExpanded : 25001
El temps de transmisió total és: 1086579 i el temps màxim és: 23773

Iterations: 25000
IterationsPerTempChange: 1000
K: 500
Lambda: 0.001
nodesExpanded : 25001
El temps de transmisió total és: 1102849 i el temps màxim és: 23765

Iterations: 25000
IterationsPerTempChange: 2000
K: 500
Lambda: 0.001
nodesExpanded : 25001
El temps de transmisió total és: 1134819 i el temps màxim és: 24357

Iterations: 50000
IterationsPerTempChange: 100
K: 500
Lambda: 0.001
nodesExpanded : 50001
El temps de transmisió total és: 934444 i el temps màxim és: 20110

Iterations: 50000
IterationsPerTempChange: 200
K: 500
Lambda: 0.001
nodesExpanded : 50001
El temps de transmisió total és: 937983 i el temps màxim és: 20264

Iterations: 50000
IterationsPerTempChange: 500
K: 500
Lambda: 0.001
nodesExpanded : 50001
El temps de transmisió total és: 957149 i el temps màxim és: 20778

Iterations: 50000
IterationsPerTempChange: 1000
K: 500
Lambda: 0.001
nodesExpanded : 50001
El temps de transmisió total és: 1001009 i el temps màxim és: 21229

Iterations: 50000
IterationsPerTempChange: 2000
K: 500
Lambda: 0.001
nodesExpanded : 50001
El temps de transmisió total és: 973365 i el temps màxim és: 20715

Iterations: 100000
IterationsPerTempChange: 100
K: 500
Lambda: 0.001
nodesExpanded : 100001
El temps de transmisió total és: 805259 i el temps màxim és: 17065

Iterations: 100000
IterationsPerTempChange: 200
K: 500
Lambda: 0.001
nodesExpanded : 100001
El temps de transmisió total és: 832176 i el temps màxim és: 17559

Iterations: 100000
IterationsPerTempChange: 500
K: 500
Lambda: 0.001
nodesExpanded : 100001
El temps de transmisió total és: 833776 i el temps màxim és: 17602

Iterations: 100000
IterationsPerTempChange: 1000
K: 500
Lambda: 0.001
nodesExpanded : 100001
El temps de transmisió total és: 840539 i el temps màxim és: 17795

Iterations: 100000
IterationsPerTempChange: 2000
K: 500
Lambda: 0.001
nodesExpanded : 100001
El temps de transmisió total és: 813381 i el temps màxim és: 17211
"""

iterations, iterations_per_temp_change, temps_max = filtrar_datos(entrada)

print(iterations)
print(iterations_per_temp_change)
print(temps_max)

######################################################################################################

