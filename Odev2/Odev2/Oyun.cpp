
#include "Oyun.h"
#include <iomanip>
using namespace std;


Oyun::Oyun(Dosya* _dosyaNesne,Masa* _masaNesne)
{
	dosya = _dosyaNesne;
	masa = _masaNesne;
	sansliSayi = 1;
	elenenSayisi = 0;
	enZenginKisiIndex = 0;
	oyunStatus = false;
	
}


void Oyun::Tur()
{
	while (elenenSayisi < dosya->kisiAdedi - 1)
	{
		oyunStatus = true;
		system("CLS");

		turSayisi++;

		srand(time(NULL));
		sansliSayi = 1 + rand() % 10;

		enZenginPara = dosya->indeksleKisiDondur(enZenginKisiIndex).kisiParaDondur();

		for (int i = 0; i < dosya->kisiAdedi; i++)
		{

			//cout << "->->" << dosya->indeksleKisiDondur(i).kisiAdSoyadDondur() << "--" << dosya->indeksleKisiDondur(i).kisiSayiDondur() << "--" << dosya->indeksleKisiDondur(i).kisiParaDondur() << endl;

			if (dosya->indeksleKisiDondur(i).kisiParaDondur() > enZenginPara)
			{
				enZenginPara = dosya->indeksleKisiDondur(i).kisiParaDondur();
				enZenginKisiIndex = i;

			}


			if (dosya->indeksleKisiDondur(i).kisiParaDondur() < 1000 && dosya->indeksleKisiDondur(i).kisiParaDondur() > -1)
			{
				dosya->indexleKisiSil(i);
				elenenSayisi++;

			}

			else if (dosya->indeksleKisiDondur(i).kisiParaDondur() > -1 && dosya->indeksleKisiDondur(i).kisiSayiDondur() == sansliSayi)
			{
				int yeniToplam = kazananIslemi(i);
				/*
				int eklenecekMiktar = dosya->indeksleKisiDondur(i).kisiParaDondur() * dosya->indeksleKisiDondur(i).kisiHerTurdaYatirilanParaDondur() * 10;
				int yeniToplam = dosya->indeksleKisiDondur(i).kisiParaDondur() + eklenecekMiktar;
				masa->masadanParaAl(eklenecekMiktar);
				*/
				dosya->indeksleKisiDondur(i).kisiParaDegistir(yeniToplam);
				
				
			}
			else if (dosya->indeksleKisiDondur(i).kisiParaDondur() > -1 && dosya->indeksleKisiDondur(i).kisiParaDondur() != sansliSayi)
			{
				int yeniToplam = kaybedenIslemi(i);
				/*
				int eksilecekMiktar = dosya->indeksleKisiDondur(i).kisiParaDondur() * dosya->indeksleKisiDondur(i).kisiHerTurdaYatirilanParaDondur();
				int yeniToplam = dosya->indeksleKisiDondur(i).kisiParaDondur() - eksilecekMiktar;
				masa->masaParaEkle(eksilecekMiktar);
				*/
				dosya->indeksleKisiDondur(i).kisiParaDegistir(yeniToplam);
				
				
			}
		};

		cout << setw(50) << "##################################################" << endl; //50 tane
		cout <<"##"<<setw(30)<<"SANSLI SAYI: " << sansliSayi << setw(17)<<"##" << endl;
		cout << setw(30) << "##################################################" << endl;
		cout << setw(30) << "##################################################" << endl;
		cout << "##" << setw(25) << "TUR: " << turSayisi << setw(22) << "##" << endl;
		cout << "##" << setw(16) << "MASA BAKIYE: " << masa->guncelMasaTutar()<<"TL" << setw(24) << "##" << endl;
		cout << "##" << setw(48) << "##" << endl;
		cout << "##" << "----------------------------------------------"  << "##" << endl;
		cout << "##" << setw(30) << "EN ZENGIN KISI: " << setw(18) << "##" << endl;
		cout << "##" << setw(26) << dosya->indeksleKisiDondur(enZenginKisiIndex).kisiAdSoyadDondur() << setw(22) << "##" << endl;
		cout << "##" << setw(15) << "BAKIYESI: " <<dosya->indeksleKisiDondur(enZenginKisiIndex).kisiParaDondur() <<setw(27) << "##" << endl;
		cout << "##" << setw(48) << "##" << endl;
		cout << setw(30) << "##################################################" << endl;
		Sleep(5000);
		

	};
	oyunStatus = false;

		cout << "Herkes elendi, oyun bitti......................................"<<endl;
		cout << setw(50) << "##################################################" << endl; //50 tane
		cout << "##" << setw(30) << "SANSLI SAYI: " << sansliSayi << setw(17) << "##" << endl;
		cout << setw(30) << "##################################################" << endl;
		cout << setw(30) << "##################################################" << endl;
		cout << "##" << setw(25) << "TUR: " << turSayisi << setw(22) << "##" << endl;
		cout << "##" << setw(16) << "MASA BAKIYE: " << masa->guncelMasaTutar() << "TL" << setw(24) << "##" << endl;
		cout << "##" << setw(48) << "##" << endl;
		cout << "##" << "----------------------------------------------" << "##" << endl;
		cout << "##" << setw(30) << "EN ZENGIN KISI: " << setw(18) << "##" << endl;
		cout << "##" << setw(26) << dosya->indeksleKisiDondur(enZenginKisiIndex).kisiAdSoyadDondur() << setw(22) << "##" << endl;
		cout << "##" << setw(15) << "BAKIYESI: " << dosya->indeksleKisiDondur(enZenginKisiIndex).kisiParaDondur() << setw(27) << "##" << endl;
		cout << "##" << setw(48) << "##" << endl;
		cout << setw(30) << "##################################################" << endl;
		cout << "Herkes elendi, oyun bitti......................................" << endl;
		Sleep(50000);

}

bool Oyun::oyunStatusDon()
{
	return oyunStatus;
}

void Oyun::setElenenSayisi(int _sayi)
{
	elenenSayisi = _sayi;
}

int Oyun::kazananIslemi(int i)
{
	int eklenecekMiktar = dosya->indeksleKisiDondur(i).kisiParaDondur() * dosya->indeksleKisiDondur(i).kisiHerTurdaYatirilanParaDondur() * 10;
	int yeniToplam = dosya->indeksleKisiDondur(i).kisiParaDondur() + eklenecekMiktar;
	//dosya->indeksleKisiDondur(i).kisiParaDegistir(yeniToplam);
	masa->masadanParaAl(eklenecekMiktar);
	return yeniToplam;
}

int Oyun::kaybedenIslemi(int i)
{
	int eksilecekMiktar = dosya->indeksleKisiDondur(i).kisiParaDondur() * dosya->indeksleKisiDondur(i).kisiHerTurdaYatirilanParaDondur();
	int yeniToplam = dosya->indeksleKisiDondur(i).kisiParaDondur() - eksilecekMiktar;
	//dosya->indeksleKisiDondur(i).kisiParaDegistir(yeniToplam);
	masa->masaParaEkle(eksilecekMiktar);
	return yeniToplam;
}

		






	
	
	

