#include "iostream"
#include "conio.h"
#include "libreria(1).h"
using namespace std;

int main ()
{
	float notas [3][5];
	int op;
	do
	{
		op=menu();
		procesos(op, notas);
    }while(op!=4);
	return 0;
}
