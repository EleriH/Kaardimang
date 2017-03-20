import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Eleri2 on 20.03.2017.
 */
public class Kaardisegaja {
    public static List<Kaart> valiKaardipakk(boolean suur) {
        int algus;
        if (suur) {
            algus = 0;
        } else {
            algus = 4;
        }

        ArrayList <Kaart> pakk = new ArrayList <>();
        for (int i = 0; i < 4; i++) {
            for (int j = algus; j < 13; j++) {
                pakk.add(new Kaart(j, i));
            }
        }

        ArrayList <Kaart> segatudPakk= new ArrayList<>();
        Random juhuslik= new Random();
        while (pakk.size()>0){
            int indeks =juhuslik.nextInt(pakk.size());
            segatudPakk.add(pakk.get(indeks));
            pakk.remove(indeks);
        }

        return segatudPakk;
    }
}
