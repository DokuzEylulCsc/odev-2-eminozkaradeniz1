import java.util.ArrayList;
import java.util.List;

public class Fakulte {
    private String adi;
    private List<Bolum> bolumList;

    public Fakulte(String adi) {
        this.adi = adi;
        this.bolumList = new ArrayList<>();
    }

    public String getAdi() { return adi; }
    public Bolum getIndexOf(int a){ return bolumList.get(a); }
    public List<Bolum> getBolumList() { return bolumList; }

    public boolean BolumEkle(String bolumAdi){
        if(BolumAra(bolumAdi) == -1){
            bolumList.add(new Bolum(bolumAdi));
            return true;
        }
        return false;
    }

    private int BolumAra(String bolumAdi){
        for (Bolum b: bolumList) {
            if(b.getAdi().equals(bolumAdi)){
                return bolumList.indexOf(b);
            }
        }
        return -1;
    }

    public void BolumleriListele(){
        System.out.println("Fakülteye ait bölümler: ");
        for (int i = 0; i < bolumList.size(); i++){
            System.out.printf("%2d. %s \n", i+1, bolumList.get(i).getAdi());
        }
    }




}
