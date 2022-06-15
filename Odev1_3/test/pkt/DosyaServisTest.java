/**
*
* @author Betul Nur Guner _ betul.guner1@ogr.sakarya.edu.tr
* @since 17.04.2022
* <p>
* 1.Ogretim A grubu
* </p>
*/

package pkt;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.github.javafaker.Faker;

class DosyaServisTest {
	
	public static DosyaServis ds;
	
	@BeforeEach
	public void setup()
	{
		IDosya _idosya=mock(IDosya.class);  //arayüzden bir nesne var gibi mock nesne urettim.		
		ds=new DosyaServis();
		ds.setIDosya(_idosya);
		//Entegrasyon Testi icin disaridan deneme.java dosyasini kullaniyoruz. 
		_idosya.setUrl("F:\\YerelDiskC_denAlinanlar\\eclipse-workspace\\Odev1_3\\OrnekDosya\\pkt\\deneme.java");
		when(_idosya.DosyaUrl()).thenReturn("F:\\YerelDiskC_denAlinanlar\\eclipse-workspace\\Odev1_3\\OrnekDosya\\pkt\\deneme.java");
		ds.setDosyaUrl(_idosya.DosyaUrl());
		ds.setDosyadanKelime(_idosya);
		when(_idosya.DosyadanKelimeGet()).thenReturn(ds.getDosyadanKelime());
		when(_idosya.getKelimeSayisi()).thenReturn(ds.kacKelimeVar());
	}
	
	//Dosya uzantisi bulan fonksiyton testte burda buldugumuz yol ile bize dondurulen yol ayný mý kontrol edecegiz.
	public String DosyaUzantisiBul(String dosyaAdi)
	{
		int i=0;
    	String aranan="";
    	StringTokenizer st=new StringTokenizer(dosyaAdi, ".");
    	while(st.hasMoreElements())
    	{
    		String token = st.nextElement().toString();
    		i++;
    		if(i==2)
    		{
    			aranan=token;
  
    		}
    	}
    	return aranan;
    	
	}
	
	//java uzantili yollarda true, diger uzantýlarda false vermeli. Bunu parametrerized test ile test ettik.
	@ParameterizedTest
	@CsvSource({"deneme.java,true","betul.txt,false", "ali.cpp,false", "dosya.doc,false","furkan.c,false","den.jar,false" }) 
	//CsvSource ile test kumemiz parametre olarak verildi.
	public void DosyaTuruTest(String tur, boolean cikti) {
		assertEquals(cikti, ds.DosyaTuru(tur)); //java uzantiliysa dogru, txt vs uzantiliysa yanlis dondursun tur. 
		//beklenen ciktimiz java da true, digerlerinde false. 
	}
	
	//Bir de faker ile bu metodu test etmek istedim. Ayný metoda birden fazla test yazilabilirdi. 
	//Faker ile dosya isimleri aliyoruz ve uzantilarini kontrol ediyoruz.  
	@Test
	public void DosyaTuruTest2() {
		boolean cikti;
		for(int i=0;i<100;i++)
		{
			Faker faker=new Faker();
			String isim=faker.file().fileName();
			System.out.println(isim);
			if(DosyaUzantisiBul(isim)=="java")
			{
				cikti=true;
			}
			else
				cikti=false;
			
			assertEquals(cikti, ds.DosyaTuru(isim)); 
		}
		//java uzantiliysa dogru, txt vs uzantiliysa yanlis dondursun tur.
	}
	
	//Bane verilen dosya url gercekten istediðim yoldaki deneme.java mi, kontrol ediyorum.
	@Test
	public void getDosyaUrlTest()
	{
		assertEquals("F:\\YerelDiskC_denAlinanlar\\eclipse-workspace\\Odev1_3\\OrnekDosya\\pkt\\deneme.java", ds.getDosyaUrl());
	}
	
	//deneme.java Dosyasini kelime kelime okudugumda elde etmek istediðim kelimeler dogru bulunmus mu?
	@Test
	public void getDosyadanKelimeTest()
	{
		ArrayList<String> beklenen=new ArrayList<String>(Arrays.asList(
				"public", "class", "JavaOrnekleri","{", "public", "static", "void",
				"main", "(", "String", "[", "]", "args", ")", "{", "int", "sayi1",
				"=", "10", ";", "int", "sayi2", "=", "20", ";", "int", "sayi3", 
				"=", "5", ";", "int", "sayi4", "=", "2", ";", "if", "(", "sayi1",
				">", "sayi2",")", "{", "sayi1", "++", ";", "sayi2", "++", ";",
				"int", "toplam", "=", "sayi1", "+", "sayi2", ";", "}", "if", "(",
				"sayi1", "<=", "sayi2",")", "{", "sayi1", "++", ";", "sayi2", 
				"++", ";", "int", "toplam", "=", "sayi1", "+", "sayi2", ";", "}",
				"if", "(", "sayi3", ">", "sayi2", "&&", "sayi2", ">", "sayi1",
				")", "{", "int", "toplam", "=", "sayi1", "+", "sayi2", ";", "int",
				"carpim", "=", "sayi1","*", "sayi2", ";", "}", "}", "}"
						
				)); //beklenen sonucun oldugu liste.

		
		assertEquals(beklenen, ds.getDosyadanKelime()); //gelen liste ile beklenen listesi esit olmalý. 
	}
	
	@Test
	public void KacKelimeVarTest()
	{	
		assertEquals(105, ds.kacKelimeVar()); //deneme.java dosyam bosluklara gore okundugunda 105 kelime var.
	}
	
	
	@RepeatedTest(100)  //100 kez dosya açýlmasý deneniyor
	@DisplayName("Dosya Ac Dene yorma testi")
	void dosyaAcDeneTest()
	{
		Faker faker=new Faker();
		String isim=faker.file().fileName(); //totam_eum\placeat.csv  gibi isimler uretti.
		//System.out.println(isim);
		assertFalse(ds.dosyaAcDene(isim)); 
		//fakerdan dosya yolu olduðu için acilmasini beklemiyorum, false gelmeli ve bu yollar acilamamali.
	}
	
	@RepeatedTest(50)  //50 kez dosya açýlmasý deneniyor
	@DisplayName("Dosya Turu yorma testi")
	void dosyaTuruTestYorma()
	{
		Faker faker=new Faker();
		String isim=faker.file().fileName();
		System.out.println(isim);
		assertTrue(ds.DosyaTuru(isim));  
		//DosyaTuru metodu verilen parametrenin uzantisi java ise true verir. Ben de java uzantili ve true olmasini bekliyorum.
		//Ancak fakerda java uzantili uretilmeyen dosya adlari fail oluyor testte.
		//Genelde 50 tanesinde de java uzantisi olmuyor ve tum testler bekledigim gibi fail veriyor. 
		
	}
	
	
	

}
