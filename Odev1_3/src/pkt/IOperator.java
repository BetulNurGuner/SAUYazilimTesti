

package pkt;

import java.util.ArrayList;

public interface IOperator {

	public int getTekliSayisi(ArrayList <String> _kelimeler);
	public int getCiftliSayisi(ArrayList <String> _kelimeler);
	public int getSayisalSayisi(ArrayList <String> _kelimeler);
	public int getIliskiselSayisi(ArrayList <String> _kelimeler);
	public int getIMantiksalSayisi(ArrayList <String> _kelimeler);
	public int toplamOperatorSayisi();
	public ArrayList<String> getTekliListe();
	public ArrayList<String> getIkiliListe();
	public ArrayList<String> getSayisalListe();
	public ArrayList<String> getIliskiselListe();
	public ArrayList<String> getMantiksalListe();
	

}
