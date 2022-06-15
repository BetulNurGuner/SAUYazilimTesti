
#include "Masa.h"

void Masa::masaParaEkle(double _para)
{
	para += _para;
}

void Masa::masadanParaAl(double _para)
{
	para -= _para;
}

double Masa::guncelMasaTutar()
{
	return para;
}
