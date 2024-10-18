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
    df['X'] = pd.to_numeric(df['X'], errors='coerce')
    df['Y'] = pd.to_numeric(df['Y'], errors='coerce')
    df = df.dropna()
    
    sum_X = df['X'].sum()
    sum_Y = df['Y'].sum()
    sum_X2 = (df['X'] ** 2).sum()
    sum_X3 = (df['X'] ** 3).sum()
    sum_X4 = (df['X'] ** 4).sum()
    sum_XY = (df['X'] * df['Y']).sum()
    sum_X2Y = (df['X'] ** 2 * df['Y']).sum()

    return sum_X, sum_Y, sum_X2, sum_X3, sum_X4, sum_XY, sum_X2Y

def resolver_sistema_cramer(sum_X, sum_Y, sum_X2, sum_X3, sum_X4, sum_XY, sum_X2Y, N):
    A = np.array([
        [N, sum_X, sum_X2],
        [sum_X, sum_X2, sum_X3],
        [sum_X2, sum_X3, sum_X4]
    ])
    
    b = np.array([sum_Y, sum_XY, sum_X2Y])
    
    return cramer_solver(A, b)

def ajuste_cuadratico_csv(file_path):
    try:
        df = pd.read_csv(file_path, sep=';')  # Usa punto y coma como separador
    except pd.errors.ParserError:
        print("Error leyendo el archivo con punto y coma.")
        return
    
    sum_X, sum_Y, sum_X2, sum_X3, sum_X4, sum_XY, sum_X2Y = calcular_sumatorias(df)
    
    N = len(df)
    
    try:
        a0, a1, a2 = resolver_sistema_cramer(sum_X, sum_Y, sum_X2, sum_X3, sum_X4, sum_XY, sum_X2Y, N)
        print(f"Coeficientes del ajuste cuadrático: a0 = {a0}, a1 = {a1}, a2 = {a2}")
    except ValueError as e:
        print(e)

# Ejemplo de uso con la ruta del archivo CSV
ajuste_cuadratico_csv('datos.csv')
