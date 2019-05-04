abstract public class Ogrenci {
    private String adi;
    private String soyadi;
    private int no;

    public Ogrenci(String adi, String soyadi, int no) {
        this.adi = adi;
        this.soyadi = soyadi;
        this.no = no;
    }

    public String getAdi() {
        return adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public int getNo() {
        return no;
    }
}
