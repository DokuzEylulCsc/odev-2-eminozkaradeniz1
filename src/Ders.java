import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ders {
    private String adi;
    private List<Sube> subeList; //dersin şubeleri
    private OgretimElemani ogretimElemani; //dersi veren öğretim elemanı

    public Ders(String adi, int subeSayisi){
        this.adi = adi;
        this.ogretimElemani = null;
        this.subeList = new ArrayList<>();

        char c = 'A';
        for (int i = 0; i < subeSayisi; i++){
            this.subeList.add(new Sube(c));
            c++;
        }

    }

    public String getAdi() { return adi; }
    List<Sube> getSubeList() { return subeList; }
    Sube getIndexOf(int a) { return subeList.get(a); }
    OgretimElemani getOgretimElemani() { return ogretimElemani; }
    void setOgretimElemani(OgretimElemani ogretimElemani) { this.ogretimElemani = ogretimElemani; }

    void SubeleriListele(){
        System.out.println("Derse ait şubeler: ");
        for (int i = 0; i < subeList.size(); i++){
            System.out.printf("%2d. %c\n", i+1, subeList.get(i).getAdi());
        }
    }

    boolean OgrenciEkle(Ogrenci ogrenci, int indexSube){
        if(OgrenciAra(ogrenci)){
            return false;
        }
        subeList.get(indexSube).OgrenciEkle(ogrenci);
        return true;
    }

    private boolean OgrenciAra(Ogrenci ogrenci){
        boolean b;
        for (Sube sube: subeList) {
            b = sube.OgrenciAra(ogrenci);
            if(b){
                return true;
            }
        }
        return false;
    }
}
