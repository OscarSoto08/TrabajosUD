#include <iostream>
#include <iomanip>
#include <cmath>
#include <stdexcept>

double biseccion(double (*f)(double), double a, double b, double TOL, int N0, int decimales) {
    if (f(a) * f(b) >= 0) {
        throw std::invalid_argument("f(a) y f(b) deben ser signos opuestos");
    }

    int i = 1;
    double FA = f(a);
    double p;

    while (i <= N0) {
        p = (a + b) / 2;
        double FP = f(p);

        if (FP == 0 || (b - a) / 2 < TOL) {
            break;
        }

        i++;

        if (FA * FP > 0) {
            a = p;
            FA = FP;
        } else {
            b = p;
        }
    }

    if (i > N0) {
        std::cout << "Se alcanzó el máximo de iteraciones: " << N0 
                  << ". Con Tolerancia: " << std::scientific << TOL << std::endl;
    } else {
        std::cout << "Se encontró la solución aproximada: " 
                  << std::fixed << std::setprecision(decimales) << p << std::endl;
    }

    return p;
}

// Definición de la función
double func(double x) {
    return sqrt(x) - cos(x);
}

int main() {
    double a = 0;
    double b = 1;
    double tol = 1e-15;
    int n = 20;
    int decimales = 12;

    try {
        double resultado = biseccion(func, a, b, tol, n, decimales);
        std::cout << "El resultado es: " << std::fixed << std::setprecision(decimales) << resultado << std::endl;
    } catch (const std::exception &e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }

    return 0;
}
