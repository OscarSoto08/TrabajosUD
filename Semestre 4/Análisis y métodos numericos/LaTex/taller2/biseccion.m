function p = biseccion(f, a, b, TOL, N0, decimales)
    if f(a) * f(b) >= 0
        error('f(a) y f(b) deben ser signos opuestos');
    end

    i = 1;
    FA = f(a);

    while i <= N0
        p = (a + b) / 2;
        FP = f(p);

        if FP == 0 || (b - a) / 2 < TOL
            break;
        end

        i = i + 1;

        if FA * FP > 0
            a = p;
            FA = FP;
        else
            b = p;
        end
    end
    
    if i > N0
        fprintf(['%.0f. Con Tolerancia: ' '%.' num2str(decimales) 'f\n'], p);
    else
        fprintf(['%.0f. Solución aproximada: ' '%.' num2str(decimales) 'f\n'], p);
    end
end

func = @(x) sqrt(x) - cos(x);
a = 0;
b = 1;
tol = 10e-15;
n = 20;
decimales = 6;


biseccion(func, a, b, tol, n, decimales);