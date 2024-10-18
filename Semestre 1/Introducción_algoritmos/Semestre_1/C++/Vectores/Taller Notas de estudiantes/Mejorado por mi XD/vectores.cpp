#include "iostream"
#include "math.h"
using namespace std;

int leernota(int *recibe)
{
	int nota[1000], i, r=(nota[1000]);
	
	
	for(i=0; i<(*recibe)
	; i++){
		nota[i];
		cout << "ahora digite el valor de sus notas: 	"<< endl; cin >> nota[i];	
	}
	return r;
}

void imprimir(int *valor)
{
for (int i=0; i>(*valor); i++){//se pueden declarar tantas variables i como se desee
	
	cout<< i << " --> " << *valor << endl;
		
	}
	
}

int main(){
	
	int n, vv=(leernota(&n));//vv = variable vector
	
	cout<<"Digite la cantidad de notas que tiene: "<<endl; cin >> n;
	leernota(&n);
	imprimir(&vv);
	
	
	
	return 0;
}
