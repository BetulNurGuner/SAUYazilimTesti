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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperandTest {
	public static DosyaServis ds;
	public static Operand _ope;
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
		ope = new Operator(ds); //operator icin dosyaservis nesnesi parametre verilmeli
		_ope=new Operand(ope); //operand icin ise operator nesnesi parametre verilmeli
		
	}

	@Test
	public void getTekliOperandSayisiTest() {
		assertEquals(4, _ope.getTekliOperandSayisi());
	}
	
	@Test
	public void getTekliOperandListeTest()
	{
		//System.out.println("Test1:  "+_ope.getTekliOperandListe());
		ArrayList<String> beklenen=new ArrayList<String>(Arrays.asList(
				"++", "++", "++", "++"
				));
		assertEquals(beklenen, _ope.getTekliOperandListe());
		
	}
	
	@Test
	public void getIkiliOperandSayisiTest()
	{
		assertEquals(34, _ope.getIkiliOperandSayisi());
	}
	@Test
	public void getIkiliOperandListeTest()
	{
		//System.out.println("Test2: "+_ope.getIkiliOperandListe());
		ArrayList<String> beklenen=new ArrayList<String>(Arrays.asList(
				"=", "=", "=", "=", ">", "=", "+", "=", "+", ">", ">", "=", "+", "=", "*","<=","&&"
				));
		assertEquals(beklenen, _ope.getIkiliOperandListe());
		
	}
	
	@Test
	public void getToplamOperandSayisiTest()
	{
		//System.out.println("Test3:"+_ope.getIkiliOperandSayisi());
		assertEquals(38, _ope.getToplamOperandSayisi());
	}
	
	@Test
	public void getToplamOperandListeTest()
	{
		//System.out.println("Test2: "+_ope.getIkiliOperandListe());
		ArrayList<String> beklenen=new ArrayList<String>(Arrays.asList(
				"=", "=", "=", "=", ">", "=", "+", "=", "+", ">", ">", "=", "+", "=", "*","++","++","<=","++","++","&&"
				));
		assertEquals(beklenen, _ope.getToplamOperandListe());
		
	}

}
