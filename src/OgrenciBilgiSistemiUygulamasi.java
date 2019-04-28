import java.util.Scanner;

public class OgrenciBilgiSistemiUygulamasi {

    private Universite universite;
    private boolean exit;
    private Scanner scanner;

    public void start(){

        universite = new Universite("Dokuz Eylül Üniversitesi");
        exit = false;
        scanner = new Scanner(System.in);
        menu();
    }

    private void menu(){

        int choice = -1;
        String str = "";

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
                            str = scanner.next();

                        }
                    }while (!isAcceptable(str));

                    str = str.toLowerCase();
                    str = str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
                    universite.FakulteEkle(new Fakulte(str));

                    break;
                case 2:
                    System.out.println("Bölüm ekle:");
                    //ilk Fakülte adi girilicek
                    break;
                case 3:
                    System.out.println("Ders ekle:");
                    //ilk fakülte ve bölüm adi girilicek
                    break;
                default:
                    System.out.println("Hatalı giriş tekrar deneyin.");
                    scanner.nextLine();

            }


        }while (!exit);


    }

    private boolean isAcceptable(String str){
        for(int i=0; i<str.length(); i++){
            if(!Character.isLetter(str.charAt(i))){
                System.out.println("Noktalama işaretleri ve rakamlar olmadan giriş yapınız: ");
                return false;
            }
        }
        return true;
    }
}
