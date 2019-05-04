import java.util.ArrayList;
import java.util.List;

public class Universite {
    private String adi;
    private List<Fakulte> fakulteList;

    public Universite(String adi) {
        this.adi = adi;
        this.fakulteList = new ArrayList<>();
    }

    public String getAdi() { return adi; }
    public Fakulte getIndexOf(int a) { return fakulteList.get(a); }
    public List<Fakulte> getFakulteList() { return fakulteList; }

    public boolean FakulteEkle(String fakulteAdi){
        if(FakulteAra(fakulteAdi) == -1){
            fakulteList.add(new Fakulte(fakulteAdi));
            return true;
        }
        return false;
    }

    private int FakulteAra(String fakulteAdi){
        for (Fakulte f: fakulteList) {
            if(f.getAdi().equals(fakulteAdi)){
                return fakulteList.indexOf(f);
            }
        }
        return -1;
    }

    public void FakulteleriListele(){
        System.out.println("Fakülteler: ");
        for (int i = 0; i < fakulteList.size(); i++){
            System.out.printf("%2d. %s \n", i+1, fakulteList.get(i).getAdi());
        }
    }

}
