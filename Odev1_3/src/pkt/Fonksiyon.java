

package pkt;

import java.util.ArrayList;

public class Fonksiyon {
	private int fonksiyonAdedi;
	DosyaServis _ds=new DosyaServis();;
	private ArrayList<String> fonksiyonListe;
	
	public Fonksiyon(DosyaServis _ds)
	{
		fonksiyonAdedi=0;
		fonksiyonListe=new ArrayList<String>();
		this._ds=_ds;
		
		//fonksiyonlarin basinda function vs gibi taným olmadigi icin en secici noktasi ()-(parametreler) den yola cikarak
		// yuvarlak parantez baþlangici "(" sayisi fonksiyon sayisidir kabul edildi.
		for(String i: _ds.getDosyadanKelime())
		{
			if ( i.equals("(") ) 
			{
				fonksiyonAdedi++;
				fonksiyonListe.add(i);
				
			}
		}
		
	}
	

	public int getFonksiyonAdedi()
	{
		return fonksiyonAdedi;
	}

	public ArrayList<String> getFonksiyonListe()
	{
		return fonksiyonListe;
	}

}
