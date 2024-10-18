Algoritmo Valor_Cena_con_IVA_Incluido
	Definir nota1,nota2, resultado Como Entero;
	
	Escribir "Ingrese el valor de su comida";
	Leer nota1;
	
	resultado <- nota1+(nota1*19)/100;
	
	Escribir "El valor de su cena es " , resultado, "$ con IVA incluido";
	
FinAlgoritmo
