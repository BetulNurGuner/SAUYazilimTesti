
#include "Dosya.h"
#include <string>
#include <vector>


using namespace std;


void Dosya::DosyaYoluGir(string _dosyaYolu="C:\\Users\\admin\\Desktop\\YazilimTesti\\Odev2\\Kisiler.txt")
{
    dosyaYolu = _dosyaYolu;
    kisiAdedi = 1;

}

string Dosya::DosyaYoluDon()
{
    return dosyaYolu;
}


vector<string> Dosya::getKisilerListesi()
{
    int sonKalinan=-1;
    int iterator=-1;
    list<string> kisiParametreler;
    kisiAdedi = (kisilerListesi.size() / 4)-1; //bir kisiye ait 4 bilgi var
    return kisilerListesi;
}

 
int Dosya::len(string str)
{
    int length = 0;
    for (int i = 0; str[i] != '\0'; i++)
    {
        length++;

    }
    return length;
}



vector<string> Dosya::DosyadanKelimeGet()
{

        ifstream dosyaOku(dosyaYolu);
        string satir = "";
        int satirNo=0;
        if (dosyaOku.is_open()) {

            while (getline(dosyaOku, satir)) {
               
                okunanSatirlar.push_back(satir);
                split(satir, '#',satirNo);
                satirNo++;

            }

            kisiAdedi = satirNo;
            
            dosyaOku.close();
        }



    return okunanSatirlar;
}

Kisi& Dosya::kisileriGetir()
{
    return *kisiler;
}


Kisi& Dosya::indeksleKisiDondur(int index)
{
    return kisiler[index];
   
}


void Dosya::indexleKisiSil(int index)
{
    kisiler[index].setBosKisi();
    
    
}

void Dosya::lstYazdir()
{
    cout <<endl<< "LST YACDÝR" << endl;
    for (auto& v : kisilerListesi)
    {
        cout << v<<endl;
    }

}


void Dosya::split(string str, char seperator, int _satirNo)
{
    string strings[4]; 
    int currIndex = 0, i = 0;
    int startIndex = 0, endIndex = 0;
    while (i <= len(str))
    {
        if (str[i] == seperator || i == len(str))
        {
            endIndex = i;
            string subStr = "";
            subStr.append(str, startIndex, endIndex - startIndex);
            strings[currIndex] = subStr;
            currIndex += 1;
            startIndex = endIndex + 1;
        }
        i++;
    }

    for (int i = 0; i < 4; i++)
    {

        kisilerListesi.push_back(strings[i]);
    }
    kisiler[_satirNo].setKisi(strings[0], stod(strings[1]), stod(strings[2]), stoi(strings[3]));
    lst.push_back(kisiler[_satirNo]);


}

