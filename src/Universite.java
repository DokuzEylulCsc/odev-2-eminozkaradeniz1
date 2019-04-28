import java.util.ArrayList;
import java.util.List;

public class Universite {
    private String adi;
    private List<Fakulte> fakulteList;

    public Universite(String adi) {
        this.adi = adi;
        this.fakulteList = new ArrayList<Fakulte>();
    }
}
