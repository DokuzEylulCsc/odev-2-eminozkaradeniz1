import java.lang.reflect.Type;
import java.util.Scanner;

public class OgrenciBilgiSistemiUygulamasi {

    private Universite universite;
    private boolean exit;
    private Scanner scanner;

    public OgrenciBilgiSistemiUygulamasi(){
        scanner = new Scanner(System.in);
        exit = false;
    }

    public void start(){

        universite = new Universite("Dokuz Eylül Üniversitesi");
        boolean b;
        //deneme
        universite.FakulteEkle("Fen");
        universite.FakulteEkle("İşletme");
        universite.FakulteEkle("Denizcilik");
        b = universite.getIndexOf(0).BolumEkle("Bilgisayar Bilimleri");
        System.out.println(b);
        b = universite.getIndexOf(0).getIndexOf(0).DersEkle("Nesne",2);
        System.out.println(b);
        System.out.println();
        menu();
    }

    private void menu(){
        int choice = -1;
        do{
            System.out.println("\nMenu:");
            System.out.println(" 1. Üniversiteye fakülte ekle");
            System.out.println(" 2. Bir fakülteye bölüm ekle");
            System.out.println(" 3. Bir bölüme ders aç");
            System.out.println(" 4. Bir bölümden ders kapa");
            System.out.println(" 5. Bir bölüme öğrenci kaydı");
            System.out.println(" 6. Bir bölümden öğrenci kaydı sil");
            System.out.println(" 7. Bir bölüme öğretim elemanı ata");
            System.out.println(" 8. Bir bölümden öğretim elemanı sil");
            System.out.println(" 9. Bir derse öğretim elemanı ata");
            System.out.println("10. Bir dersin öğretim elemanını değiştir");
            System.out.println("11. Bir derse öğrenci ekle");
            System.out.println("12. Bir dersten öğrenci sil");
            System.out.println(" 0. Çıkış");

            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
            }

            switch (choice){
                case 0:
                    exit = true;
                    break;
                case 1: //fakülte ekle
                    fakulteEkle();
                    break;
                case 2: //bölüm ekle
                    bolumEkle();
                    break;
                case 3: //bir bölüme ders ekle
                    dersEkle();
                    break;
                case 4: //bir bölümden ders sil
                    dersSil();
                    break;
                case 5: //bir bölüme öğrenci kaydı
                    ogrenciKaydi();
                    break;
                case 6: //bir bölümden öğrenci kaydı sil
                    ogrenciKaydiSil();
                    break;
                case 7: //bir bölüme öğretim elemanı ata
                    ogretimElemaniAta();
                    break;
                case 8: //bir bölümden öğretim elemanı sil
                    ogretimElemaniSil();
                    break;
                case 9: //bir derse öğretim elemanı ata
                    derseOgretimElemaniAta();
                    break;
                case 10: //bir dersin öğretim elemanını değiştir
                    dersOgretimElemaniDegistir();
                    break;
                case 11: //bir derse öğrenci ekle
                    derseOgrenciEkle();
                    break;
                case 12: //bir dersten öğrenci sil
                    derstenOgrenciSil();
                    break;
                default:
                    System.out.println("Hatalı giriş tekrar deneyin.");
                    scanner.nextLine();
            }
            System.out.println();
        }while (!exit);
        scanner.close();
    }

    private static boolean isAcceptable(String str){
        for(int i=0; i<str.length(); i++){
            if(!Character.isLetter(str.charAt(i))){
                System.out.println("Noktalama işaretleri ve rakamlar olmadan giriş yapınız: ");
                return false;
            }
        }
        return true;
    }

    private static String convertToName(String str){ //gelen stringi baş harfi büyük, diğer harfleri küçük hale getiriyor
        str = str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
        return str;
    }

    private int getIndex(int size){
        int index = -1;
        if(scanner.hasNextLine()){
            do{
                try {
                    index = Integer.parseInt(scanner.next());
                }catch (NumberFormatException e){
                    System.out.println("Tamsayı girişi yapın!");
                    continue;
                }
                if(index <= size && index > 0){
                    break;
                }else{
                    System.out.println("Hatalı giriş!");
                }
            }while (true);
        }
        return index - 1;
    }

    private void fakulteEkle(){ //fakülte ekle case 1
        String fakulteAdi = "";
        System.out.println("Fakulte ekle:");
        System.out.println("Fakulte adı girin:");

        do{
            if(scanner.hasNextLine()){
                fakulteAdi = scanner.next();
            }
        }while (!isAcceptable(fakulteAdi));
        fakulteAdi = convertToName(fakulteAdi);

        boolean b = universite.FakulteEkle(fakulteAdi);
        if(b){
            System.out.println("Fakülte başarıyla eklendi.");
        }else{
            System.out.println("Fakülte daha önceden eklenmiş.");
        }
    }

    private void bolumEkle(){ //bir fakülteye bölüm ekle case 2
        universite.FakulteleriListele();
        int n = universite.getFakulteList().size();
        if(n == 0){
            System.out.println("Üniversiteye ait fakülte bulunmamaktadır.");
            return;
        }
        System.out.println("\nFakülte seçiniz: ");
        int i = getIndex(n);

        String bolumAdi = "";
        System.out.println("\nBölüm adı girin:");
        do{
            if(scanner.hasNextLine()){
                bolumAdi = scanner.next();
            }
        }while (!isAcceptable(bolumAdi));
        bolumAdi = convertToName(bolumAdi);

        boolean b = universite.getIndexOf(i).BolumEkle(bolumAdi);
        if (b){
            System.out.println("Bölüm başarıyla eklendi. ");
        }else {
            System.out.println("Bölüm daha önce eklenmiş. ");
        }
    }

    private void dersEkle(){ //bir bölüme ders ekle case 3
        int n = universite.getFakulteList().size();
        if(n == 0){
            System.out.println("Üniversiteye ait fakülte bulunmamaktadır.");
            return;
        }
        universite.FakulteleriListele();
        System.out.println("\nFakülte seçiniz: ");
        int i = getIndex(n);

        n = universite.getIndexOf(i).getBolumList().size();
        if(n == 0){
            System.out.println("\nBu fakülteye ait bölüm bulunmamaktadır. ");
            return;
        }
        universite.getIndexOf(i).BolumleriListele();
        System.out.println("\nBölüm seçiniz: ");
        int j = getIndex(n);

        String dersAdi = "";
        System.out.println("Ders adı girin: ");
        do{
            if(scanner.hasNextLine()){
                dersAdi = scanner.next();
            }
        }while (!isAcceptable(dersAdi));
        dersAdi = convertToName(dersAdi);

        int subeSayisi = -1;
        System.out.println("Ders kaç şube olucak (1,2,4): ");
        if(scanner.hasNextLine()){
            do{
                try {
                    subeSayisi = Integer.parseInt(scanner.next());
                }catch (NumberFormatException e){
                    System.out.println("Tamsayı girişi yapın!");
                    continue;
                }
                if(subeSayisi == 1 || subeSayisi == 2 || subeSayisi == 4){
                    break;
                }else{
                    System.out.println("Hatalı giriş!");
                }
            }while (true);
        }

        boolean b = universite.getIndexOf(i).getIndexOf(j).DersEkle(dersAdi, subeSayisi);
        if (b){
            System.out.println("Ders başarıyla eklendi. ");
        }else {
            System.out.println("Ders daha önce eklenmiş. ");
        }
    }

    private void dersSil(){ //bir bölümden ders sil case 4
        int n = universite.getFakulteList().size();
        if(n == 0){
            System.out.println("Üniversiteye ait fakülte bulunmamaktadır.");
            return;
        }
        universite.FakulteleriListele();
        System.out.println("\nFakülte seçiniz: ");
        int i = getIndex(n);

        n = universite.getIndexOf(i).getBolumList().size();
        if(n == 0){
            System.out.println("Bu fakülteye ait bölüm bulunmamaktadır. ");
            return;
        }
        universite.getIndexOf(i).BolumleriListele();
        System.out.println("\nBölüm seçiniz: ");
        int j = getIndex(n);

        n = universite.getIndexOf(i).getIndexOf(j).getDersList().size();
        if(n == 0){
            System.out.println("Bu bölüme ait ders bulunmamaktadır. ");
            return;
        }
        universite.getIndexOf(i).getIndexOf(j).DersleriListele();
        System.out.println("\nDers seçiniz: ");
        int d = getIndex(n);

        boolean b = universite.getIndexOf(i).getIndexOf(j).DersSil(d);
        if (b){
            System.out.println("Ders başarıyla silindi.");
        }else {
            System.out.println("Ders silinemedi.");
        }
    }

    private void ogrenciKaydi(){ //bölüme öğrenci kaydı case 5
        int n = universite.getFakulteList().size();
        if(n == 0){
            System.out.println("Üniversiteye ait fakülte bulunmamaktadır.");
            return;
        }
        universite.FakulteleriListele();
        System.out.println("\nFakülte seçiniz: ");
        int i = getIndex(n);

        n = universite.getIndexOf(i).getBolumList().size();
        if(n == 0){
            System.out.println("Bu fakülteye ait bölüm bulunmamaktadır. ");
            return;
        }
        universite.getIndexOf(i).BolumleriListele();
        System.out.println("\nBölüm seçiniz: ");
        int j = getIndex(n);
        System.out.println("\nÖğrenci seçimi: ");
        System.out.println("1. Lisans\n2. Yüksek Lisans\n3. Doktora");
        n = 3;
        int t = getIndex(n);

        String ogrenciAdi = "";
        String ogrenciSoyadi = "";

        System.out.println("\nÖğrenci adı girin: ");
        do{
            if(scanner.hasNextLine()){
                ogrenciAdi = scanner.next();
            }
        }while (!isAcceptable(ogrenciAdi));
        ogrenciAdi = convertToName(ogrenciAdi);

        System.out.println("\nÖğrenci soyadı girin: ");
        do{
            if(scanner.hasNextLine()){
                ogrenciSoyadi = scanner.next();
            }
        }while (!isAcceptable(ogrenciSoyadi));
        ogrenciSoyadi = convertToName(ogrenciSoyadi);

        System.out.println("\nÖğrenci no girin: ");
        int ogrenciNo = getIndex(Integer.MAX_VALUE);

        Ogrenci ogrenci;
        if (t == 0){
            ogrenci = new Lisans(ogrenciAdi,ogrenciSoyadi,ogrenciNo);
        }else if (t == 1){
            ogrenci = new YuksekLisans(ogrenciAdi,ogrenciSoyadi,ogrenciNo);
        }else{
            ogrenci = new Doktora(ogrenciAdi,ogrenciSoyadi,ogrenciNo);
        }

        boolean b = universite.getIndexOf(i).getIndexOf(j).OgrenciEkle(ogrenci);
        if (b){
            System.out.println("Öğrenci bölüme başarıyla eklendi.");
        }else {
            System.out.println("Bu no ya sahip öğrenci daha önce eklenmiş.");
        }
    }

    private void ogrenciKaydiSil(){ //bölümden öğrenci kaydı sil case 6

    }

    private void ogretimElemaniAta(){

    }

    private void ogretimElemaniSil(){

    }

    private void derseOgretimElemaniAta(){

    }

    private void dersOgretimElemaniDegistir(){

    }

    private void derseOgrenciEkle(){

    }

    private void derstenOgrenciSil(){

    }



}
