

package pkt;

import java.util.ArrayList;

import org.mockito.InjectMocks;

public class Operator {
	@InjectMocks 
	public IOperator ioperator;
	
	private int tekliSayisi; 
	private int ikiliSayisi;
	private int sayisalSayisi; 
	private int iliskiselSayisi; 
	private int mantiksalSayisi; 
	private ArrayList<String> tekliListe;
	private ArrayList<String> ikiliListe;
	private ArrayList<String> sayisalListe;
	private ArrayList<String> mantiksalListe;
	private ArrayList<String> iliskiselListe;
	DosyaServis _ds=new DosyaServis();
	
	public void setIOperator(IOperator ioperator)
	{
		this.ioperator=ioperator;
	}
	
	public IOperator getIOperator()
	{
		return ioperator;
	}
	
	public Operator(DosyaServis _ds)
	{
		this._ds=_ds;
		
		tekliSayisi=0;
		ikiliSayisi=0;
		sayisalSayisi=0;
		iliskiselSayisi=0;
		mantiksalSayisi=0;
		tekliListe=new ArrayList<String>();
		ikiliListe=new ArrayList<String>();
		sayisalListe=new ArrayList<String>();
		mantiksalListe=new ArrayList<String>();
		iliskiselListe=new ArrayList<String>();
		
		
		for(String i: _ds.getDosyadanKelime()) 
		{
			//tekli operatorler icin aradigimiz seyler if kontrolunde bulunur ve ilgili listeye eklenir.
			if(i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/") || i.equals( "%") || 
					i.equals( "&") || i.equals( "|") || i.equals( "^") || i.equals( "=") ||
					i.equals( "<") || i.equals(">") || i.equals( "!")
					)
			{
				tekliSayisi++;
				tekliListe.add(i);
			}
			//ikili operatorler icin aradigimiz seyler if kontrolunde bulunur ve ilgili listeye eklenir.
			if(i.equals("++") || i.equals("--") || i.equals("+=") || i.equals("-=") || i.equals( "/=") || 
					i.equals( "*=") || i.equals( "%=") || i.equals( "&=") || i.equals( "|=") ||
					i.equals("^=") || i.equals("<=") || i.equals(">=") || i.equals( "==") ||
					i.equals( "!=") || i.equals( "&&") || i.equals( "||")
				)
			{
				ikiliSayisi++;
				ikiliListe.add(i);
			}
			//iliskisel operatorler icin aradigimiz seyler if kontrolunde bulunur ve ilgili listeye eklenir.
			if(i.equals("<") || i.equals("<=") || i.equals(">") || i.equals(">=") || i.equals( "==") || 
					i.equals( "!=")  )
			{
				iliskiselSayisi++;
				iliskiselListe.add(i);
				
			}
			//mantiksal operatorler icin aradigimiz seyler if kontrolunde bulunur ve ilgili listeye eklenir.
			if(i.equals("&&") || i.equals("||") || i.equals("!") )
			{
				mantiksalSayisi++;
				mantiksalListe.add(i);
				
			}
			//sayisal operatorler icin aradigimiz seyler if kontrolunde bulunur ve ilgili listeye eklenir.
			if(i.equals("+") || i.equals("++") || i.equals("-") || i.equals("--") || i.equals( "*") || 
					i.equals( "/" )|| i.equals( "%") || i.equals( "&") || i.equals( "|") ||
					i.equals( "^") || i.equals("=") || i.equals( "+=") || i.equals( "-=") 
					|| i.equals( "/=") || i.equals( "*=") || i.equals( "%=") || i.equals( "&=")
					|| i.equals( "|=") || i.equals( "^=")
				)
			{
				sayisalSayisi++;
				sayisalListe.add(i);
				
			}
			
			
			
		}
		
	};
	public int getTekliSayisi()
	{
		return tekliSayisi;
		
	}
	public int getCiftliSayisi()
	{
		return ikiliSayisi;
	}
	public int getSayisalSayisi()
	{
		return sayisalSayisi;
	}
	public int getIliskiselSayisi()
	{
		return iliskiselSayisi;
	}
	public int getMantiksalSayisi()
	{
		return mantiksalSayisi;
	}
	public int toplamOperatorSayisi()
	{
		return tekliSayisi+ikiliSayisi;
	}
	public ArrayList<String> getTekliListe()
	{
		return tekliListe;
	}
	public ArrayList<String> getIkiliListe()
	{
		return ikiliListe;
	}
	public ArrayList<String> getSayisalListe()
	{
		return sayisalListe;
	}
	public ArrayList<String> getIliskiselListe()
	{
		return iliskiselListe;
	}
	public ArrayList<String> getMantiksalListe()
	{
		return mantiksalListe;
	}
}
