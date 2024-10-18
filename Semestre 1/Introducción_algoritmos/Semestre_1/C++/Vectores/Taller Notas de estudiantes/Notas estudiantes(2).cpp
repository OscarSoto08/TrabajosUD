#include "iostream"
#include "math.h"
using namespace std;

int leernota()
{
	int nota[1000], n;
	
	cout<<"Digite la cantidad de notas que tiene: "<<endl; cin >> n;
	for(int i=0; i<n; i++){
		nota[i];
		cout << "ahora digite el valor de sus notas: 	"<< i << endl; cin >> nota[i];
	}	
	
	for(int i=0;i<n;i++){
		
		cout<<nota[i];	
	}	
}


int leer ()//captura un valor 
{int x;
     cout<<"\t***PROGRAMA QUE MIDE EL PROMEDIO DE 5 NOTAS***"<<endl;
     cout<<endl<<"Presentado por: Johan Steve Ospina Prieto y Oscar Alejandro Gonzalez Soto"<<endl;
	 cout<<endl<<"Digite nota: ";
     cin>>x;
return (x);
}

void imprimir (int nota[5])
{for (int i=0;i<5;i++)
     {cout<<endl<<"Nota No "<<i+1<<": "<<nota[i];
     }
}

void promedio (int nota[5], float *prom)
{int i;
*prom=0;//declaro dos variables al proceso
for (int i=0;i<5;i++)
     {*prom=*prom + nota[i];
     }
     *prom=*prom/5;
     cout<<endl<<endl<<"El promedio es de:  "<< *prom ;
}

void notasmayores(int notas[5], float prom)
{int promedioR = round(prom);
for (int i=0;i<5;i++)
      {
         if (notas[i]>=promedioR)
          cout<<endl<<"notas mayor que el promedio "<<notas[i];
      }      
}

int main ()
//primero va fila y luego columna [5] con 1 sola fila
{
	float prom;
	int i, nota[5];//no entrega el valor de leer, esta definiendo una variable y un vector 
	for (i=0;i<5;i++)
	//leer guarda un solo valor y luego va guardando
	{nota[i]= leer();// se va perdiendo los datos o valores anteriores, pero si le pongo el vector [i] ahora si se guarda
// si tiene () es una funcion.
	}
imprimir (nota);//recibe toda la matriz, y lo recorrio (osea q lo mostro lo q tenia en los indices)
promedio (nota, &prom);
notasmayores(nota, prom);
}
