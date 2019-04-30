import java.text.ParseException;
import java.util.Scanner;

public class OgrenciBilgiSistemiUygulamasi {

    private Universite universite;
    private boolean exit;
    private Scanner scanner;

    public void start(){

        universite = new Universite("Dokuz Eylül Üniversitesi");
        exit = false;
        scanner = new Scanner(System.in);

        //deneme
        universite.FakulteEkle("Fen");
        Fakulte f = universite.getIndexOf(0);
        f.BolumEkle("Bilgisayar");
        Bolum b = f.getIndexOf(0);

        System.out.println(f.getAdi());
        System.out.println(b.getAdi());
        System.out.println();

        menu();
    }

    private void menu(){

        int choice = -1;
        String fakulteAdi = "";
        String bolumAdi = "";
        String dersAdi = "";
        int i = -1,j = -1;
        boolean b = false;

        do{
            System.out.println("Menu:");
            System.out.println("1.Üniversiteye fakülte ekle");
            System.out.println("2.Bir fakülteye bölüm ekle");
            System.out.println("3.Bir bölüme ders ekle");
            System.out.println("0.Çıkış");

            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
            }


            switch (choice){

                case 0:
                    exit = true;
                    break;

                case 1:
                    System.out.println("Fakulte ekle:");
                    System.out.println("Fakulte adı girin:");
                    do{
                        if(scanner.hasNextLine()){
                            fakulteAdi = scanner.next();
                        }
                    }while (!isAcceptable(fakulteAdi));

                    fakulteAdi = convertToName(fakulteAdi);
                    b = universite.FakulteEkle(fakulteAdi);

                    if(b){
                        System.out.println("Fakülte başarıyla eklendi.");
                    }else{
                        System.out.println("Fakülte daha önceden eklenmiş.");
                    }
                    break;

                case 2:
                    System.out.println("Bölüm ekle: ");
                    System.out.println("Bölümün ekleneceği fakültenin adını girin: ");
                    do{
                        if(scanner.hasNextLine()){
                            fakulteAdi = scanner.next();
                        }
                    }while (!isAcceptable(fakulteAdi));

                    fakulteAdi = convertToName(fakulteAdi);
                    i = universite.fakulteAra(fakulteAdi);
                    System.out.println("i=" + i);////

                    if(i == -1){
                        System.out.println("Bu isimde fakülte bulunmamaktadır.");
                        break;
                    }

                    System.out.println("Eklenecek bölümün adını girin: ");
                    do{
                        if(scanner.hasNextLine()){
                            bolumAdi = scanner.next();
                        }
                    }while (!isAcceptable(bolumAdi));
                    bolumAdi = convertToName(bolumAdi);
                    b = universite.getIndexOf(i).BolumEkle(bolumAdi);


                    if(b){
                        System.out.println("Bölüm başarıyla eklendi.");
                    }else {
                        System.out.println("Bölüm daha önceden eklenmiş.");
                    }
                    break;

                case 3:
                    System.out.println("Ders ekle:");
                    System.out.println("Dersin ekleneceği bölümün adını girin: ");
                    do{
                        if(scanner.hasNextLine()){
                            bolumAdi = scanner.next();
                        }
                    }while (!isAcceptable(bolumAdi));
                    bolumAdi = convertToName(bolumAdi);

                    Bolum bolum = universite.BolumAra(bolumAdi);
                    if(bolum == null){
                        System.out.println("Böyle bir bölüm bulunmamaktadır. ");
                        break;
                    }

                    System.out.println("Eklenecek dersin adını girin: ");
                    do{
                        if(scanner.hasNextLine()){
                            dersAdi = scanner.next();
                        }
                    }while (!isAcceptable(dersAdi));
                    dersAdi = convertToName(dersAdi);

                    System.out.println("Dersin kodunu girin: ");
                    String dersKodu = "";
                    int subeSayisi = -1;
                    if(scanner.hasNextLine()){
                        dersKodu = scanner.next();
                    }

                    System.out.println("Ders kaç şube olacak: (1,2,4)");
                    if(scanner.hasNextLine()){
                        do{
                            try {
                                subeSayisi = Integer.parseInt(scanner.next());
                            }catch (NumberFormatException e){
                                System.out.println("Şube sayısını 1,2 ya da 4 girin: ");
                                continue;
                            }
                            if(subeSayisi == 1 || subeSayisi == 2 || subeSayisi == 4){
                                break;
                            }else{
                                System.out.println("Şube sayısını 1,2 ya da 4 girin: ");
                            }

                        }while (true);
                    }

                    b = bolum.DersEkle(dersAdi, dersKodu, subeSayisi);
                    if(b){
                        System.out.println("Ders başarıyla eklendi.");
                    }else {
                        System.out.println("Ders daha önceden eklenmiş.");
                    }
                    break;

                default:
                    System.out.println("Hatalı giriş tekrar deneyin.");
                    scanner.nextLine();

            }
            System.out.println();

        }while (!exit);

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

    private static String convertToName(String str){
        str = str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
        return str;
    }

}
