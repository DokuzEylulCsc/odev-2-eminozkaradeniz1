import java.util.ArrayList;
import java.util.List;

public class Bolum {
    private String adi;
    private List<Ders> dersList;
    private List<Ogrenci> ogrenciList;

    public Bolum(String adi){
        this.adi = adi;
        this.dersList = new ArrayList<>();
        this.ogrenciList = new ArrayList<>();
    }

    public String getAdi() { return adi; }
    public Ders getIndexOf(int a){ return dersList.get(a); }
    public List<Ders> getDersList() { return dersList; }

    public boolean DersEkle(String  dersAdi, int subeSayisi){
        if(DersAra(dersAdi) == -1){
            Ders ders = new Ders(dersAdi, subeSayisi);
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

    public boolean DersSil(int ind){
        dersList.remove(ind);
        return true;
    }

    public void DersleriListele(){
        System.out.println("Bölüme ait dersler: ");
        for (int i = 0; i <  dersList.size(); i++){
            System.out.printf("%2d. %s", i+1, dersList.get(i).getAdi());
        }
    }

    public boolean OgrenciEkle(Ogrenci ogrenci){
        if(ogrenciList.size() == 0){
            ogrenciList.add(ogrenci);
            return true;
        }
        if(OgrenciAra(ogrenci) == -1){
            ogrenciList.add(ogrenci);
            return true;
        }
        return false;
    }

    private int OgrenciAra(Ogrenci ogrenci){
        for (Ogrenci o: ogrenciList) {
            if(o.getNo() == ogrenci.getNo()){
                return ogrenciList.indexOf(o);
            }
        }
        return -1;
    }

}
