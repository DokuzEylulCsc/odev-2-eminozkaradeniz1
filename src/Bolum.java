import java.util.ArrayList;
import java.util.List;

public class Bolum {
    private String adi;
    private List<Ders> dersList;

    public Bolum(String adi){
        this.adi = adi;
        this.dersList = new ArrayList<Ders>();
    }

    public String getAdi() {
        return adi;
    }

    public boolean DersEkle(String  dersAdi, String dersKodu, int subeSayisi){
        if(DersAra(dersAdi) == -1){
            Ders ders = new Ders(dersAdi, dersKodu, subeSayisi);
            dersList.add(ders);
            return true;
        }
        return false;
    }

    private int DersAra(String dersAdi){
        for (Ders d: dersList) {
            if(d.getAdi().equals(dersAdi)){
                return dersList.indexOf(d);
            }
        }
        return -1;
    }

    public Ders getIndexOf(int a){
        return dersList.get(a);
    }
}
