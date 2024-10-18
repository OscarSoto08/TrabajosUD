Algoritmo Conversion_de_moneda
	Definir v1, res1, res2 Como real;
	Escribir "Digite el valor que usted desea convertir en pesos colombianos";
	leer v1
//dolares
	res1 <- trunc(v1*0.00021);
//euros
	res2 <- trunc(v1*0.00019);
	escribir "El valor de su moneda en dolares es equivalente a: ", res1 "$ y en euros su moneda es equivalente a " , res2 "$"
FinAlgoritmo
