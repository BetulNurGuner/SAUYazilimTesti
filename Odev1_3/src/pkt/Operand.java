

package pkt;

import java.util.ArrayList;

import org.mockito.InjectMocks;

public class Operand {
	@InjectMocks //olmayan neyseye url set edemem vs. o yuzden gerekli.
	public IOperator ioperator;
	
	private int tekliOperand;   //a++, 6-- gibi bu ++ ve -- operatorleri tek operanda sahip.
	private int ikiliOperand;   //>=, <=, != gibiler saðda ve solda olmak üzere 2 operanda sahip a==b gibi.
	private ArrayList<String> OperatorList=new ArrayList<String>(); //Tum operatorlerin tutuldugu liste.
	private ArrayList<String> TekliOperandListe=new ArrayList<String>(); 
	private ArrayList<String> IkiliOperandListe=new ArrayList<String>();
	DosyaServis _ds=new DosyaServis();
	Operator _ope=new Operator(_ds);
	
	public Operand(Operator _ope)
	{
		this._ope=_ope;
		//operatorlist hem tekli hem ikili operatorlerin hepsinin bulundugu genel liste.
		OperatorList.addAll(_ope.getTekliListe());
		OperatorList.addAll(_ope.getIkiliListe());
		tekliOperand=0;
		ikiliOperand=0;
		
		for(String i:OperatorList)
		{
			if(i.equals("++") || i.equals("--"))
			{
				tekliOperand+=1; //++ ve -- icin solunda 1 operanda sahip. 25++, 19-- gibi.
				TekliOperandListe.add(i); //gercekten sadece ++ ve -- operatorleri mi alýnmýs diye kontrol edecegim testte bu liste ile.
				
			}
		}
		
		for(String i:OperatorList)
		{
			if(!(i.equals("++") || i.equals("--"))) //++ ve -- disindaki tum operatorler 2 operanda sahip. 
			{
				ikiliOperand+=2; //operand sayisi 2 artýrýlacak cunku sagda ve solda 2 operandi var a+b, a==c gibi.
				IkiliOperandListe.add(i); //gercekten aradigim operatorler mi tutulmus kontrol ediyorum testte, oyuzden bu liste gerekli..
			}
		}
		
	}
	


	public int getTekliOperandSayisi()
	{
		return tekliOperand;
		
	}
	
	public ArrayList<String> getTekliOperandListe()
	{
		return TekliOperandListe;
	}

	public int getIkiliOperandSayisi()
	{

		return ikiliOperand;
	}
	
	public ArrayList<String> getIkiliOperandListe()
	{
		return IkiliOperandListe;
	}
	
	
	public int getToplamOperandSayisi()
	{
		return getIkiliOperandSayisi()+getTekliOperandSayisi();
		
	}
	public ArrayList<String> getToplamOperandListe()
	{
		return OperatorList;
	}

}
