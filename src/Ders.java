import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ders {
    private String adi;
    private String kodu;
    private List<Sube> subeList; //dersin şubeleri

    public Ders(String adi, String kodu, int subeSayisi){
        this.adi = adi;
        this.kodu = kodu;
        this.subeList = new ArrayList<Sube>();

        char c = 'A';
        for (int i = 0; i < subeSayisi; i++){
            this.subeList.add(new Sube(c));
            c++;
        }

    }

    public String getAdi() {
        return adi;
    }

    public boolean subeEkle(Sube sube){
        if(!hasContain(sube.getAdi())){
            subeList.add(sube);
            return true;
        }
        return false;
    }

    private boolean hasContain(char subeAdi){
        for (Sube s: subeList) {
            if(s.getAdi() == subeAdi){
                return true;
            }
        }
        return false;
    }
}
