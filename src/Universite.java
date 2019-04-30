import java.util.ArrayList;
import java.util.List;

public class Universite {
    private String adi;
    private List<Fakulte> fakulteList;

    public Universite(String adi) {
        this.adi = adi;
        this.fakulteList = new ArrayList<Fakulte>();
    }

    public boolean FakulteEkle(String fakulteAdi){
        if(fakulteAra(fakulteAdi) == -1){
            fakulteList.add(new Fakulte(fakulteAdi));
            return true;
        }
        return false;
    }

    public int fakulteAra(String fakulteAdi){
        for (Fakulte f: fakulteList) {
            if(f.getAdi().equals(fakulteAdi)){
                return fakulteList.indexOf(f);
            }
        }
        return -1;
    }

    public Bolum BolumAra(String bolumAdi){
        int i = -1;
        for (Fakulte f: fakulteList) {
            i = f.BolumAra(bolumAdi);
            if(i > -1){
                return f.getIndexOf(i);
            }
        }
        return null;

    }

    public Fakulte getIndexOf(int a){
        return fakulteList.get(a);
    }

}
