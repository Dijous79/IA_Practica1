def filtrar_datos(entrada):
    lines = entrada.strip().split('\n')
    
    K_values = []
    lambda_values = []
    temps_max = []
    
    for line in lines:
        if line.startswith("K:"):
            K_values.append(int(line.split(":")[1].strip()))
        elif line.startswith("Lambda:"):
            lambda_values.append(float(line.split(":")[1].strip()))
        elif line.startswith("El temps de transmisió total és:"):
            temps_max.append(int(line.split(":")[2].strip().split()[0]))
    
    return K_values, lambda_values, temps_max

entrada = """
Iterations: 50000
IterationsPerTempChange: 100
K: 5
Lambda: 1.0

DFA Simulated Annealing -->

nodesExpanded : 801
El valor de la heurística per a la solució final és: 33889.0
El temps de transmisió total és: 1520365 i el temps màxim és: 33889

Iterations: 50000
IterationsPerTempChange: 100
K: 5
Lambda: 0.1

DFA Simulated Annealing -->

nodesExpanded : 7501
El valor de la heurística per a la solució final és: 29421.0
El temps de transmisió total és: 1362652 i el temps màxim és: 29421

Iterations: 50000
IterationsPerTempChange: 100
K: 5
Lambda: 0.01

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 20742.0
El temps de transmisió total és: 978097 i el temps màxim és: 20742

Iterations: 50000
IterationsPerTempChange: 100
K: 5
Lambda: 0.001

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 19913.0
El temps de transmisió total és: 931795 i el temps màxim és: 19913

Iterations: 50000
IterationsPerTempChange: 100
K: 5
Lambda: 1.0E-4

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 20378.0
El temps de transmisió total és: 960006 i el temps màxim és: 20378

Iterations: 50000
IterationsPerTempChange: 100
K: 25
Lambda: 1.0

DFA Simulated Annealing -->

nodesExpanded : 801
El valor de la heurística per a la solució final és: 34054.0
El temps de transmisió total és: 1505945 i el temps màxim és: 34054

Iterations: 50000
IterationsPerTempChange: 100
K: 25
Lambda: 0.1

DFA Simulated Annealing -->

nodesExpanded : 7501
El valor de la heurística per a la solució final és: 29221.0
El temps de transmisió total és: 1310657 i el temps màxim és: 29221

Iterations: 50000
IterationsPerTempChange: 100
K: 25
Lambda: 0.01

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 20698.0
El temps de transmisió total és: 967331 i el temps màxim és: 20698

Iterations: 50000
IterationsPerTempChange: 100
K: 25
Lambda: 0.001

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 20502.0
El temps de transmisió total és: 969372 i el temps màxim és: 20502

Iterations: 50000
IterationsPerTempChange: 100
K: 25
Lambda: 1.0E-4

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 20204.0
El temps de transmisió total és: 955769 i el temps màxim és: 20204

Iterations: 50000
IterationsPerTempChange: 100
K: 100
Lambda: 1.0

DFA Simulated Annealing -->

nodesExpanded : 801
El valor de la heurística per a la solució final és: 33902.0
El temps de transmisió total és: 1488432 i el temps màxim és: 33902

Iterations: 50000
IterationsPerTempChange: 100
K: 100
Lambda: 0.1

DFA Simulated Annealing -->

nodesExpanded : 7501
El valor de la heurística per a la solució final és: 28285.0
El temps de transmisió total és: 1245468 i el temps màxim és: 28285

Iterations: 50000
IterationsPerTempChange: 100
K: 100
Lambda: 0.01

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 20373.0
El temps de transmisió total és: 968497 i el temps màxim és: 20373

Iterations: 50000
IterationsPerTempChange: 100
K: 100
Lambda: 0.001

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 20519.0
El temps de transmisió total és: 967332 i el temps màxim és: 20519

Iterations: 50000
IterationsPerTempChange: 100
K: 100
Lambda: 1.0E-4

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 20631.0
El temps de transmisió total és: 984537 i el temps màxim és: 20631

Iterations: 50000
IterationsPerTempChange: 100
K: 500
Lambda: 1.0

DFA Simulated Annealing -->

nodesExpanded : 801
El valor de la heurística per a la solució final és: 34386.0
El temps de transmisió total és: 1508115 i el temps màxim és: 34386

Iterations: 50000
IterationsPerTempChange: 100
K: 500
Lambda: 0.1

DFA Simulated Annealing -->

nodesExpanded : 7501
El valor de la heurística per a la solució final és: 29013.0
El temps de transmisió total és: 1284289 i el temps màxim és: 29013

Iterations: 50000
IterationsPerTempChange: 100
K: 500
Lambda: 0.01

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 19321.0
El temps de transmisió total és: 908941 i el temps màxim és: 19321

Iterations: 50000
IterationsPerTempChange: 100
K: 500
Lambda: 0.001

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 20997.0
El temps de transmisió total és: 971410 i el temps màxim és: 20997

Iterations: 50000
IterationsPerTempChange: 100
K: 500
Lambda: 1.0E-4

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 22977.0
El temps de transmisió total és: 1070296 i el temps màxim és: 22977

Iterations: 50000
IterationsPerTempChange: 100
K: 1000
Lambda: 1.0

DFA Simulated Annealing -->

nodesExpanded : 801
El valor de la heurística per a la solució final és: 34836.0
El temps de transmisió total és: 1584074 i el temps màxim és: 34836

Iterations: 50000
IterationsPerTempChange: 100
K: 1000
Lambda: 0.1

DFA Simulated Annealing -->

nodesExpanded : 7501
El valor de la heurística per a la solució final és: 28704.0
El temps de transmisió total és: 1277331 i el temps màxim és: 28704

Iterations: 50000
IterationsPerTempChange: 100
K: 1000
Lambda: 0.01

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 20352.0
El temps de transmisió total és: 967506 i el temps màxim és: 20352

Iterations: 50000
IterationsPerTempChange: 100
K: 1000
Lambda: 0.001

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 20883.0
El temps de transmisió total és: 989769 i el temps màxim és: 20883

Iterations: 50000
IterationsPerTempChange: 100
K: 1000
Lambda: 1.0E-4

DFA Simulated Annealing -->

nodesExpanded : 50001
El valor de la heurística per a la solució final és: 23661.0
El temps de transmisió total és: 1089811 i el temps màxim és: 23661
"""

K_values, lambda_values, temps_max = filtrar_datos(entrada)

print(K_values)
print(lambda_values)
print(temps_max)
