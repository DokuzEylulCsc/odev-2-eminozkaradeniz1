import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ders {
    private String adi;
    private List<Sube> subeList; //dersin şubeleri

    public Ders(String adi, int subeSayisi){
        this.adi = adi;
        this.subeList = new ArrayList<>();

        char c = 'A';
        for (int i = 0; i < subeSayisi; i++){
            this.subeList.add(new Sube(c));
            c++;
        }

    }

    public String getAdi() {
        return adi;
    }
}
