import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Eleri2 on 20.03.2017.
 */
public class Mäng {
    private ArrayList<Kaart> kaardidPakis;
    private ArrayList<Mängija> mängijad;

    public Mäng(ArrayList<Kaart> kaardidPakis, ArrayList<Mängija> mängijad) {
        this.kaardidPakis = kaardidPakis;
        this.mängijad = mängijad;
    }

    public void mängi() {
        for (Mängija k : mängijad) {
            for (int i = 0; i < 8; i++) {
                k.lisaKaart(kaardidPakis.get(0));
                kaardidPakis.remove(0);
            }
        }

        int järgmineAlustaja = new Random().nextInt(mängijad.size());
        while (kaardidPakis.size() < mängijad.size()) {
            järgmineAlustaja = mänguring(järgmineAlustaja);
            for (Mängija m : mängijad) {
                m.lisaKaart(kaardidPakis.get(0));
                kaardidPakis.remove(0);
            }
        }
    }

    public int mänguring(int alustajaIndeks) {
        ArrayList<Kaart> kaardidLaual = new ArrayList<>();

        int kõigeTugevamIndeks;
        Kaart kõigeTugevamKaart;
        int i = alustajaIndeks;
        do {
            Mängija m = mängijad.get(i);
            Kaart k = m.käiKaart(kaardidLaual);
            kaardidLaual.add(k);

            if ((i == alustajaIndeks) ||
                    ((k.getMast()==kõigeTugevamKaart.getMast()) &&
                            (k.getNumber() > kõigeTugevamKaart.getNumber())) {
                kõigeTugevamIndeks = i;
                kõigeTugevamKaart = k;
            }
            i++;
            if (i == mängijad.size())
                i = 0;
        } while (i != alustajaIndeks);

        return kõigeTugevamIndeks;
    }
}
