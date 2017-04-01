import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MängTest {
    public static void main(String[] args) {
        List<Mängija> mängijad = new ArrayList<>();

        System.out.println("Oled sisenemas põnevasse kaardimängumaailma! Enne mängima asumist, järgi palun juhiseid");
        Scanner reader = new Scanner(System.in);

        lisaInimMängija(mängijad, reader); //meetod InimMängija lisamiseks

        lisaArvutiMängija(mängijad, reader); //meetod ArvutiMängija lisamiseks

        List<Kaart> pakk = Kaardisegaja.valiKaardipakk(true);

        Mäng mäng = new Mäng(pakk, mängijad);

        mäng.mängi();
    }

    private static void lisaInimMängija(List<Mängija> mängijad, Scanner reader) {
        System.out.println("Sisesta inimmängijate arv: ");
        int mArv = reader.nextInt();
        for (int i = 0; i < mArv; i++) {
            System.out.println("Sisesta inimmängija nimi: ");
            String nimi = reader.next();
            mängijad.add(new InimMängija(nimi));
        }
    }

    private static void lisaArvutiMängija(List<Mängija> mängijad, Scanner reader) {
        System.out.println("Sisesta arvutimängijate arv: ");
        int aArv = reader.nextInt();

        for (int i = 0; i < aArv; i++) {
            System.out.println("Sisesta arvutimängija nimi: ");
            String nimi = reader.next();
            System.out.println("Palun vali vastase tugevus: nõrk=1; tugev =2");
            int tugevus = reader.nextInt();
            if (tugevus == 1) {
                mängijad.add(new JuhuslikMängija(nimi));
            } else if (tugevus == 2) {
                mängijad.add(new TargemJuhuslikMängija(nimi));
            }
        }
    }
}

