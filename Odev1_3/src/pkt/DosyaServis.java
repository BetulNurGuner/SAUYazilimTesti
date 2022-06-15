

package pkt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.mockito.InjectMocks;

public class DosyaServis{
	
	@InjectMocks //olmayan nesneye url set edemem vs. o yuzden gerekli.
	public IDosya idosya;
	
	ArrayList<String> kelimeler=new ArrayList<String>();
	int kelimeSayisi;
	
	public void setIDosya(IDosya idosya)
	{
		this.idosya=idosya;
	}
	
	public IDosya getIDosya()
	{
		return idosya;
	}
	
	public void setDosyaUrl(String _url)
	{
		idosya.setUrl(_url);
	}
	
	public String getDosyaUrl()
	{
		return idosya.DosyaUrl();
	}
	
	public boolean DosyaTuru(String _dosyaYolu) //_dosyaUzantisi ile d��ardan girilecek dosya yolu alinir.
	{	
		int i=0;
    	String aranan=""; //dosya yolunda noktadan sonraki k�s�m aranand�r.Yani uzant�d�r.
    	StringTokenizer st=new StringTokenizer(_dosyaYolu, ".");
    	while(st.hasMoreElements())
    	{
    		String token = st.nextElement().toString(); //Alinan dosya yolu noktadan �nce ve sonra olarak ayristirildi.
    		i++;
    		if(i==2) //noktadan �nceki k�s�m i=1, noktadan sonraki k�s�m i=2 olur.
    		{
    			aranan=token; //noktadan sonraki k�s�m aranan uzant�d�r.
    			
    		}
    		
    	}
    	
    	if(aranan.equals("java")) //e�er uzanti java ise true d�nmeli.
    		return true;
    	else
    		return false; //uzant� java degilse false d�nmeli.
    	
    	
		
	}
	
	//kelime kelime dosyan�n okunmasi islemi, dosyadan okunanlar kelimeler Arraylistine set edilir.
	public void setDosyadanKelime(IDosya idosya) 
	{
		this.idosya=idosya;
		String dosyaUrl=idosya.DosyaUrl();
   
    	File file = new File(dosyaUrl);
    	try {
    	Scanner scanner = new Scanner(file);
    	 while(scanner.hasNext())
    	 { // kelime kelime okur. bo�luklar silinir.
    			kelimeler.add(scanner.next());
    			kelimeSayisi++;
    			
    	 }
    	scanner.close();
    	   
    	} catch (FileNotFoundException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    	System.out.println("Dosya Bulunamadi...");
    	
    	}
    	
	}
	
	//dosyadan okunup kelimelerin kaydedildi�i arraylist d�nd�r�l�r.
	public ArrayList<String> getDosyadanKelime() 
	{			
		return kelimeler;	    	
	}
	
	//kelimeler arraylistinin uzunlu�u d�nd�r�l�r.
	public int kacKelimeVar()
	{	
		return kelimeSayisi;
	}
	
	//verilen yoldaki dosyanin okunabilir olup olmadigini kontrol eder.
	//Repeated testte kullanilacaktir, faker k�t�phanesinden �rnek dosya yolu verilerek.
	public boolean dosyaAcDene(String dosyaYol)
	{	
    	File file = new File(dosyaYol);
    	if(file.canRead())
    		return true;
    	else
    		return false;
		
	}
	

}
