

#pragma once
#include<iostream>
#include "Masa.h"
#include "Dosya.h"
#include "Kisi.h"
#include <ctime>
#include<iostream>
#include <time.h>
#include <Windows.h>

using namespace std;

class Oyun
{
private:
	Masa* masa;
	Dosya* dosya;	//kisilerle ilgili iþlemler dosyada
	int enZenginPara;
	int enZenginKisiIndex;
	int elenenSayisi;
	int turSayisi;
	bool oyunStatus;
public:
	int sansliSayi;
	Oyun(Dosya*,Masa*);
	void Tur();
	bool oyunStatusDon();
	void setElenenSayisi(int);
	int kazananIslemi(int);
	int kaybedenIslemi(int);
	
};

