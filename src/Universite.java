import java.util.ArrayList;
import java.util.List;

public class Universite {
    private String adi;
    private List<Fakulte> fakulteList;

    public Universite(String adi) {
        this.adi = adi;
        this.fakulteList = new ArrayList<Fakulte>();
    }

    public boolean FakulteEkle(Fakulte fakulte){
        if(!hasContain(fakulte.getAdi())){
            fakulteList.add(fakulte);
            return true;
        }
        return false;
    }

    private boolean hasContain(String fakulteAdi){
        for (Fakulte f: fakulteList) {
            if(f.getAdi() == fakulteAdi){
                return true;
            }
        }
        return false;
    }

}
