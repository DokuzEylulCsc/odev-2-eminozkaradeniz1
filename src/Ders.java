import java.util.ArrayList;
import java.util.List;

public class Ders {
    private String adi;
    private String kodu;
    private List<Sube> subeList; //dersin şubeleri

    public Ders(String adi, String kodu){
        this.adi = adi;
        this.kodu = kodu;
        this.subeList = new ArrayList<Sube>();
    }
}
