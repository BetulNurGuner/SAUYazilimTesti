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

class OperatorTest {
	public static DosyaServis ds;
	public static Operator ope;
	
	@BeforeEach
	public void setup()
	{
				
		IDosya _idosya=mock(IDosya.class);  //arayüzden bir nesne var gibi mock nesne urettim.	
		ds=new DosyaServis();
		ds.setIDosya(_idosya);
		_idosya.setUrl("F:\\YerelDiskC_denAlinanlar\\eclipse-workspace\\Odev1_3\\OrnekDosya\\pkt\\deneme.java");
		when(_idosya.DosyaUrl()).thenReturn("F:\\YerelDiskC_denAlinanlar\\eclipse-workspace\\Odev1_3\\OrnekDosya\\pkt\\deneme.java");
		ds.setDosyaUrl(_idosya.DosyaUrl());
		ds.setDosyadanKelime(_idosya);
		ds.setDosyaUrl("F:\\YerelDiskC_denAlinanlar\\eclipse-workspace\\Odev1_3\\OrnekDosya\\pkt\\deneme.java");
		when(_idosya.DosyadanKelimeGet()).thenReturn(ds.getDosyadanKelime());
		
		IOperator ioperator=mock(IOperator.class);
		ope = new Operator(ds);
		
	}
	
	
	@Test
	public void getTekliSayisiTest()
	{
		assertEquals(15, ope.getTekliSayisi());
	}
	
	@Test
	public void getCiftliSayisiTest()
	{
		assertEquals(6, ope.getCiftliSayisi());
	}
	
	@Test
	public void getTekliListeTest()
	{
		ArrayList<String> beklenen=new ArrayList<String>(Arrays.asList(
				"=", "=", "=", "=", ">", "=", "+", "=", "+", ">", ">", "=", "+", "=", "*"
				));
		assertEquals(beklenen, ope.getTekliListe());
		
	}
	
	@Test
	public void getIkiliListeTest()
	{
		ArrayList<String> beklenen=new ArrayList<String>(Arrays.asList(
				"++", "++", "<=", "++", "++", "&&"
				));
		assertEquals(beklenen, ope.getIkiliListe());
		
	}
	
	@Test
	public void getSayisalSayisiTest()
	{
		assertEquals(16, ope.getSayisalSayisi());
	}
	
	@Test
	public void getSayisalListeTest()
	{
		ArrayList<String> beklenen=new ArrayList<String>(Arrays.asList(
				"=", "=", "=", "=", "++", "++", "=", "+", "++", "++", "=", "+", "=", "+", "=", "*"
				));
		assertEquals(beklenen, ope.getSayisalListe());
		
	}
	@Test
	public void getIliskiselSayisiTest()
	{
		assertEquals(4, ope.getIliskiselSayisi());
	}
	
	@Test
	public void getIliskiselListeTest()
	{
		ArrayList<String> beklenen=new ArrayList<String>(Arrays.asList(
				">", "<=", ">", ">"
				));
		assertEquals(beklenen, ope.getIliskiselListe());
		
	}
	@Test
	public void getMantiksalSayisiTest()
	{
		assertEquals(1, ope.getMantiksalSayisi());
	}
	
	@Test
	public void getMantiksalListeTest()
	{
		ArrayList<String> beklenen=new ArrayList<String>(Arrays.asList(
				"&&"
				));
		assertEquals(beklenen, ope.getMantiksalListe());
		
	}
	
	@Test
	public void toplamOperatorSayisiTest()
	{
		assertEquals(21, ope.toplamOperatorSayisi());
	}
	

	

}
