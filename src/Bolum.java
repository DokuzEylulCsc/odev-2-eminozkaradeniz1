import java.util.ArrayList;
import java.util.List;

public class Bolum {
    private String adi;
    private List<Ders> dersList;

    public Bolum(String adi){
        this.adi = adi;
        this.dersList = new ArrayList<Ders>();
    }
}
