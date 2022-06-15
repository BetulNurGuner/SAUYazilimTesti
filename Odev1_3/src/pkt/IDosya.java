

package pkt;
import java.util.ArrayList;

public interface IDosya {

		public void setUrl(String url);
		public String DosyaUrl();
		public void DosyadanKelimeSet(); //Dosyadan veriler okunur, kelime kelime okunur
		public ArrayList<String> DosyadanKelimeGet();
		public int getKelimeSayisi();
	

}
