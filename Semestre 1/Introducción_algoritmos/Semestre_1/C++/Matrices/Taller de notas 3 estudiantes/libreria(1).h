#include "iostream"
#include "conio.h"
using namespace std;
int f, c;

int menu()
{
	int op;
		
	cout<<endl<<"1. Mostrar matriz";
	cout<<endl<<"2. insertar notas matriz";
	cout<<endl<<"3. Generar promedio";
	cout<<endl<<"4. Salir";
	cout<<endl<<"Digite opcion: "<<endl;
	cin>>op;
	
	return (op);
}

void leer (float notas [3][5])
{
for (f=0;f<=2;f++)
    {
     cout<<endl<<"Estudiante No: "<<f+1; 
    
   	 for(c=0;c<=4;c++)
   	     {
	     cout<<endl<<"digite nota del estudiante: ";
	     cin>>notas[f][c];
	     }
	}
}

void imprimir (float notas [3][5])
{
for (f=0;f<=2;f++){
		cout<<endl<<"Estudiante No: "<<f+1<<": "; 

   	 for(c=0;c<=4;c++)
   	    {cout<<"\t"<<notas[f][c]<<endl;
	    }
	    
	}
}

void promedio (float notas [3][5])
{float prom;
for (f=0;f<=2;f++){
		cout<<endl<<"Estudiante No: "<<f+1<<": "; 
		prom=0;
   	 for(c=0;c<=4;c++)
   	    {prom=prom+notas[f][c];
	    }
	 cout<<"\t"<<"El prom es: "<<prom/c<<endl;
	}
}



void procesos (int op, float notas[3][5])
{switch (op)
	{case 1:
	    imprimir(notas);
		break;
	 case 2:
	 	leer(notas);
	 	break;
	 case 3:
	 	promedio(notas);
	 	break;
	}
}
