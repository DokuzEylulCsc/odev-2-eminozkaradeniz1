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

    public boolean DersEkle(Ders ders){
        if(!hasContain(ders.getAdi())){
            dersList.add(ders);
            return true;
        }
        return false;
    }

    private boolean hasContain(String dersAdi){
        for (Ders d: dersList) {
            if(d.getAdi() == dersAdi){
                return true;
            }
        }
        return false;
    }
}
