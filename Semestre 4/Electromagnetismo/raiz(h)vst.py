import pandas as pd
import numpy as np

def cramer_solver(A, b):
    det_A = np.linalg.det(A)
    if det_A == 0:
        raise ValueError("El sistema no tiene una solución única (determinante es 0)")
    
    n = len(b)
    coeficientes = []
    for i in range(n):
        Ai = np.copy(A)
        Ai[:, i] = b
        det_Ai = np.linalg.det(Ai)
        coeficientes.append(det_Ai / det_A)
    
    return coeficientes

def calcular_sumatorias(df):
    df['Y'] = pd.to_numeric(df['Y'], errors='coerce')
    df['X'] = pd.to_numeric(df['X'], errors='coerce')
    df = df.dropna()
    
    sum_X = df['X'].sum()
    sum_Y = (df['Y']** 0.5).sum()
    sum_X2 = (df['X'] ** 2).sum()
    sum_XY = (df['X'] * ((df['Y'])**0.5)).sum()

    return sum_X, sum_Y, sum_X2, sum_XY

def resolver_sistema_cramer(sum_X, sum_Y, sum_X2, sum_XY, N):
    A = np.array([
        [N, sum_X],
        [sum_X, sum_X2]
    ])
    
    b = np.array([sum_Y, sum_XY])
    
    return cramer_solver(A, b)

def calcular_variables(a1, R, r, Ho):
    k = 2*a1
    T = (R ** 2/r**2)*((2*Ho/9.77412)**0.5)
    return f"El valor de la constante es: {k} \n y el tiempo de vaciado es: {T}"

def ajuste_cuadratico_csv(file_path):
    try:
        df = pd.read_csv(file_path, sep=';')  # Usa punto y coma como separador
    except pd.errors.ParserError:
        print("Error leyendo el archivo con punto y coma.")
        return
    
    sum_X, sum_Y, sum_X2, sum_XY = calcular_sumatorias(df)

    N = len(df)
    
    
    try:
        a0, a1 = resolver_sistema_cramer(sum_X, sum_Y, sum_X2, sum_XY, N)
        print(f"Coeficientes del ajuste lineal: \n a0 = {a0}, \n a1 = {a1}")
    except ValueError as e:
        print(e)

    print(calcular_variables(a1,25,3,0.38))

# Ejemplo de uso con la ruta del archivo CSV
ajuste_cuadratico_csv('datos.csv')
