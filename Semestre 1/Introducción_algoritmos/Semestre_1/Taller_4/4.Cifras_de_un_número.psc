Algoritmo Cifras_de_un_n�mero

	Mostrar  "Digite un n�mero"
	Leer n1
	
	temporal = n1
	cnt_Digitos = 0 
	Mostrar  n1
	
	Mientras temporal > 0 Hacer 
		digito = temporal%10
		temporal = (temporal-digito)/10
		Mostrar " digito: " digito 
		cant_digitos = cantidad_digitos+1
				
	FinMientras
	
	mostrar "el numero " n1 "tiene " can_digitos " digitos "

FinAlgoritmo
