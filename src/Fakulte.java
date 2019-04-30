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

    public boolean BolumEkle(String bolumAdi){
        if(BolumAra(bolumAdi) == -1){
            bolumList.add(new Bolum(bolumAdi));
            return true;
        }
        return false;
    }

    public int BolumAra(String bolumAdi){
        for (Bolum b: bolumList) {
            if(b.getAdi().equals(bolumAdi)){
                return bolumList.indexOf(b);
            }
        }
        return -1;
    }


    public Bolum getIndexOf(int a){
        return bolumList.get(a);
    }

}
