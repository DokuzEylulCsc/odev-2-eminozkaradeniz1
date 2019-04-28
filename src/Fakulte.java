import java.util.ArrayList;
import java.util.List;

public class Fakulte {
    private String adi;
    private List<Bolum> bolumList;

    public Fakulte(String adi) {
        this.adi = adi;
        this.bolumList = new ArrayList<Bolum>();
    }

    public String getAdi() {
        return adi;
    }

    public boolean BolumEkle(Bolum bolum){
        if(!hasContain(bolum.getAdi())){
            bolumList.add(bolum);
            return true;
        }
        return false;
    }

    private boolean hasContain(String bolumAdi){
        for (Bolum b: bolumList) {
            if(b.getAdi() == bolumAdi){
                return true;
            }
        }
        return false;
    }

}
