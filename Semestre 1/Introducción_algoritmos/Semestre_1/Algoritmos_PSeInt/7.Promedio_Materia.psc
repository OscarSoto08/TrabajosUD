Algoritmo Promedio_Materia
	Definir n1, n2, n3, definitiva Como Real;
	
	Escribir "Digite el valor de su primer nota";
	Leer n1
	Escribir "Digite el valor de su segunda nota";
	Leer n2;
	Escribir  "Dijite el valor de su tercer nota";
	Leer n3;
	
	
	Si (n1 >=10 y n1 <=50) Y (n2 >=10 y n2 <=50) Y (n3 >=10 y n3 <=50) Entonces;
		definitiva <- (n1+n2+n3)/3
		Escribir "El valor de su promedio es:", resultado;
	SiNo
		escribir "El valor es incorrecto"
	
	Fin Si
	
	
	
FinAlgoritmo
