
#include "Kisi.h"


void Kisi::setKisi(string _adSoyad, double _para, double _herTurdaYatirilanPara, int _sayi)
{
	AdSoyad = _adSoyad;
	para = _para;
	herTurdaYatirilanPara = _herTurdaYatirilanPara;
	sayi = _sayi;
}

void Kisi::setBosKisi()
{
	AdSoyad = "";
	para = -1;
	herTurdaYatirilanPara = -1;
	sayi = 0;

}

string Kisi::kisiAdSoyadDondur()
{
	return AdSoyad;
}

double Kisi::kisiParaDondur()
{
	return para;
}

void Kisi::kisiParaDegistir(double _para)
{
	para = _para;
}

double Kisi::kisiHerTurdaYatirilanParaDondur()
{
	return herTurdaYatirilanPara;
}

int Kisi::kisiSayiDondur()
{
	return sayi;
}
