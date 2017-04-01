import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Eleri on 22.03.2017.
 */
public class MängTest {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Sisesta mängija nimi: ");
        String a = reader.next();
        System.out.println("Sisesta vastasmängija nimi: ");
        String b = reader.next();

        List<Kaart> pakk = Kaardisegaja.valiKaardipakk(true);

        List<Mängija> mängijad = new ArrayList<>();
        mängijad.add(new JuhuslikMängija(a));
        mängijad.add(new TargemJuhuslikMängija(b));

        Mäng mäng = new Mäng(pakk, mängijad);

        mäng.mängi();
    }
}

