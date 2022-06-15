

#pragma once
#include<iostream>
#include <cstring>
#include <sstream>

using namespace std;

class Kisi
{
private:
	string AdSoyad;
	double para;
	double herTurdaYatirilanPara;
	int sayi;

public:
	void setKisi(string, double, double, int);
	void setBosKisi();
	string kisiAdSoyadDondur();
	double kisiParaDondur();
	void kisiParaDegistir(double _para);
	double kisiHerTurdaYatirilanParaDondur();
	int kisiSayiDondur();

};

