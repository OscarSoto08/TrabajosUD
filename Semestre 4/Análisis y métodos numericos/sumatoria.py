def suma(N):
    suma = 0
    for i in range (1, N+1):
        suma += i
    return suma

def sumaPorFormula(N):
    return N*(N+1)/2

print(f"La suma es {suma(100)}")   
print(f"La suma por formula es: {sumaPorFormula(100)}")