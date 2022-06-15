
#pragma once
#include <cstring>
#include <iostream>
#include <fstream>
#include <list>
#include "Kisi.h"
#include <vector>
#include <stdio.h>
#include <stdlib.h>
#include <cstdlib>
#include <sstream>

using namespace std;

class Dosya
{
private:
	string dosyaYolu;
	vector<string> kisilerListesi;
	vector<string> okunanSatirlar;
	vector<Kisi> lst;

	Kisi* kisiler = new Kisi[10000000];


public:

	int kisiAdedi;
	vector<string> getKisilerListesi();
	void split(string, char,int);
	void DosyaYoluGir(string);
	string DosyaYoluDon();
	vector<string> DosyadanKelimeGet( );
	Kisi& kisileriGetir();  
	Kisi& indeksleKisiDondur(int index);
	int len(string);
	void indexleKisiSil(int index);
	void lstYazdir();


};

