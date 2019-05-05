import java.util.ArrayList;
import java.util.List;

public class Bolum {
    private String adi;
    private List<Ders> dersList;
    private List<Ogrenci> ogrenciList;
    private List<OgretimElemani> ogretimElemaniList;

    Bolum(String adi){
        this.adi = adi;
        this.dersList = new ArrayList<>();
        this.ogrenciList = new ArrayList<>();
        this.ogretimElemaniList = new ArrayList<>();
    }

    public String getAdi() { return adi; }
    Ders getIndexOfDers(int a){ return dersList.get(a); }
    List<Ders> getDersList() { return dersList; }
    Ogrenci getIndexOfOgrenci(int a) { return ogrenciList.get(a); }
    List<Ogrenci> getOgrenciList() { return ogrenciList; }
    OgretimElemani getIndexOfOgretimElemani(int a) { return ogretimElemaniList.get(a); }
    List<OgretimElemani> getOgretimElemaniList() { return ogretimElemaniList; }

    boolean DersEkle(String dersAdi, int subeSayisi){
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

    void DersSil(int index){
        dersList.remove(index);
    }

    void DersleriListele(){
        System.out.println("Bölüme ait dersler: ");
        for (int i = 0; i <  dersList.size(); i++){
            System.out.printf("%2d. %s", i+1, dersList.get(i).getAdi());
        }
    }

    boolean OgrenciEkle(Ogrenci ogrenci){
        if(ogrenciList.size() == 0){
            ogrenciList.add(ogrenci);
            return true;
        }
        if(OgrenciAra(ogrenci.getNo()) == -1){
            ogrenciList.add(ogrenci);
            return true;
        }
        return false;
    }

    void OgrenciSil(int index){
        ogrenciList.remove(index);
    }

    private int OgrenciAra(int no){
        for (Ogrenci o: ogrenciList) {
            if(o.getNo() == no){
                return ogrenciList.indexOf(o);
            }
        }
        return -1;
    }

    void OgrencileriListele(){
        System.out.println("Bölüme kayıtlı öğrenciler: ");
        System.out.println("    Adı\tSoyadı\tNo");
        for (int i = 0; i < ogrenciList.size(); i++){
            System.out.printf("%2d. %s\t%s\t%d \n", i+1, ogrenciList.get(i).getAdi(), ogrenciList.get(i).getSoyadi()
                    , ogrenciList.get(i).getNo());
        }
    }

    boolean OgretimElemaniAta(String adi, String soyadi){
        if(ogretimElemaniList.size() == 0){
            ogretimElemaniList.add(new OgretimElemani(adi, soyadi));
            return true;
        }
        if(OgretimElemaniAra(adi, soyadi) == -1){
            ogretimElemaniList.add(new OgretimElemani(adi, soyadi));
            return true;
        }
        return false;
    }

    private int OgretimElemaniAra(String adi, String soyadi){
        for (OgretimElemani o: ogretimElemaniList) {
            if(o.getAdi().equals(adi) && o.getSoyadi().equals(soyadi)){
                return ogretimElemaniList.indexOf(o);
            }
        }
        return -1;
    }

    void OgretimElemaniSil(int index){
        ogretimElemaniList.remove(index);
    }

    void OgretimElemaniListele(){
        System.out.println("Bölümdeki öğretim elemanları: ");
        System.out.println("    Adı\tSoyadı");
        for (int i = 0; i < ogretimElemaniList.size(); i++){
            System.out.printf("%2d. %s\t%s \n", i+1, ogretimElemaniList.get(i).getAdi()
                    , ogretimElemaniList.get(i).getSoyadi());
        }
    }

}
