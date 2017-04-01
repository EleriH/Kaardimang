import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Eleri on 22.03.2017.
 */
public class MängTest {
    public static void main(String[] args) {
        List<Mängija> mängijad = new ArrayList<>();

        Scanner reader = new Scanner(System.in);
        System.out.println("Sisesta mängijate arv: ");
        int mArv = reader.nextInt();
        for (int i=0; i < mArv; i++) {
            System.out.println("Sisesta mängija nimi: ");
            String nimi = reader.next();
            mängijad.add(new JuhuslikMängija(nimi));
        }

        List<Kaart> pakk = Kaardisegaja.valiKaardipakk(true);


        Mäng mäng = new Mäng(pakk, mängijad);

        mäng.mängi();
    }
}

