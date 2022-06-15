
#include "Dosya.h"
#include <iostream>
#include "Oyun.h"

int main()
{

    string txtUrl = "C:\\Users\\admin\\Desktop\\YazilimTesti\\Odev2\\Kisiler.txt";
    Dosya *dosyaNesne = new Dosya();
    Masa* masaNesne = new Masa();
    Oyun* oyunNesne = new Oyun(dosyaNesne,masaNesne);
    int turSayisi;
    
    
    dosyaNesne->DosyaYoluGir(txtUrl);
    dosyaNesne->DosyadanKelimeGet();
    dosyaNesne->getKisilerListesi();
    dosyaNesne->kisileriGetir();

    oyunNesne->Tur();

       

    

}

