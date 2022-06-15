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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FonksiyonTest {
	public static DosyaServis ds;
	public static Fonksiyon fk;
	
	@BeforeEach
	public void setup()
	{
		//IOperator _ioperator=mock(IOperator.class);  //arayüzden bir nesne var gibi mock nesne urettik.		
		IDosya _idosya=mock(IDosya.class);  //arayüzden bir nesne var gibi mock nesne urettik.	
		ds=new DosyaServis();
		ds.setIDosya(_idosya);
		_idosya.setUrl("F:\\YerelDiskC_denAlinanlar\\eclipse-workspace\\Odev1_3\\OrnekDosya\\pkt\\deneme.java");
		when(_idosya.DosyaUrl()).thenReturn("F:\\YerelDiskC_denAlinanlar\\eclipse-workspace\\Odev1_3\\OrnekDosya\\pkt\\deneme.java");
		ds.setDosyaUrl(_idosya.DosyaUrl());
		ds.setDosyadanKelime(_idosya);
		ds.setDosyaUrl("F:\\YerelDiskC_denAlinanlar\\eclipse-workspace\\Odev1_3\\OrnekDosya\\pkt\\deneme.java");
		//when(_idosya.DosyaTuru(".java")).thenReturn(true);
		when(_idosya.DosyadanKelimeGet()).thenReturn(ds.getDosyadanKelime());
		//when(_idosya.getKelimeSayisi()).thenReturn(10);
		
		fk=new Fonksiyon(ds);
		
	}
	
	
	// "(" operatorler arasinda deðil ve fonksiyona özel oldugunu dusunerek bu sayýdan yola ciktim. 
	// 4 tane ( varsa 4 fonksiyon var demektir.
	
	@Test
	public void getFonksiyonAdediTest() {
		assertEquals(4,fk.getFonksiyonAdedi() );
	}
	
	@Test
	public void getFonksiyonListeTest() {
		ArrayList<String> beklenen=new ArrayList<String>(Arrays.asList(
				"(", "(", "(", "("
			));
		
		assertEquals(beklenen, fk.getFonksiyonListe());
	}
	
}
