Algoritmo Promedio_de_nota
		Definir n1, n2, n3, definitiva Como Real;
		
		Escribir "Digite el valor de su primer nota";
		Leer n1
		Escribir "Digite el valor de su segunda nota";
		Leer n2;
		Escribir  "Dijite el valor de su tercer nota";
		Leer n3;
		
		
		Si (n1 >=1.0 y n1 <=5.0) Y (n2 >=1.0 y n2 <=5.0) Y (n3 >=1.0 y n3 <=5.0) Entonces;
			definitiva <- (n1+n2+n3)/3
			//definitiva <- trunc(definitiva)
			Escribir "El valor de su promedio es:", definitiva;
		SiNo
			escribir "El valor es incorrecto"
			
		Fin Si
FinAlgoritmo
