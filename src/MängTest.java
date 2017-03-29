import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eleri on 22.03.2017.
 */
public class MängTest {
    public static void main(String[] args) {
        List<Kaart> pakk = Kaardisegaja.valiKaardipakk(true);

        ArrayList<Mängija> mängijad = new ArrayList<>();
        mängijad.add(new JuhuslikMängija("Totu"));
        mängijad.add(new TargemJuhuslikMängija("Lotu"));

        Mäng mäng = new Mäng(pakk, mängijad);

        mäng.mängi();

    }
}

