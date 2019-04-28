import java.util.ArrayList;
import java.util.List;

public class Fakulte {
    private String adi;
    private List<Bolum> bolumList;

    public Fakulte(String adi) {
        this.adi = adi;
        this.bolumList = new ArrayList<Bolum>();
    }
}
