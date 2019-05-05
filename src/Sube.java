import java.util.ArrayList;
import java.util.List;

public class Sube {
    private char adi; //A,B,C,D..
    private List<Ogrenci> ogrenciList;

    Sube(char adi){
        this.adi = adi;
        this.ogrenciList = new ArrayList<>();
    }

    List<Ogrenci> getOgrenciList() { return ogrenciList; }

    public char getAdi() {
        return adi;
    }

    boolean OgrenciAra(Ogrenci ogrenci){
        return ogrenciList.contains(ogrenci);
    }

    void OgrenciEkle(Ogrenci ogrenci){
        ogrenciList.add(ogrenci);
    }

    void OgrencileriListele(){
        System.out.println("Şubedeki Öğrenciler: ");
        System.out.println("    Adı\tSoyadı\tNo");
        for (int i = 0; i < ogrenciList.size(); i++){
            System.out.printf("%2d. %s\t%s\t%d \n", i+1, ogrenciList.get(i).getAdi(), ogrenciList.get(i).getSoyadi()
                    , ogrenciList.get(i).getNo());
        }
    }

    void OgrenciSil(int index){
        ogrenciList.remove(index);
    }


}
