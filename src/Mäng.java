import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Eleri2 on 20.03.2017.
 */
public class Mäng {
    private List<Kaart> kaardidPakis;
    private List<Mängija> mängijad;

    public Mäng(List<Kaart> kaardidPakis, List<Mängija> mängijad) {
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
        int ringiNumber = 1;
        while (kaardidPakis.size() > mängijad.size()) {
            System.out.println("Mänguring " + ringiNumber);
            järgmineAlustaja = mänguring(järgmineAlustaja);
            for (Mängija m : mängijad) {
                m.lisaKaart(kaardidPakis.get(0));
                kaardidPakis.remove(0);
            }
            ringiNumber++;
        }

        System.out.println("Tulemused:");
        for (Mängija m: mängijad) {
            System.out.println(m.getNimi() + ": " + m.getSkoor());
        }
    }

    public int mänguring(int alustajaIndeks) {
        ArrayList<Kaart> kaardidLaual = new ArrayList<>();

        int kõigeTugevamIndeks = -1;
        Kaart kõigeTugevamKaart = null;
        int i = alustajaIndeks;
        do {
            Mängija m = mängijad.get(i);
            Kaart k = m.käiKaart(kaardidLaual);
            kaardidLaual.add(k);
            System.out.println(m.getNimi() + " käib " + k);
            if ((i == alustajaIndeks) ||
                    ((k.getMast()==kõigeTugevamKaart.getMast()) &&
                            (k.getNumber() > kõigeTugevamKaart.getNumber()))) {
                kõigeTugevamIndeks = i;
                kõigeTugevamKaart = k;
            }
            i++;
            if (i == mängijad.size())
                i = 0;
        } while (i != alustajaIndeks);

        System.out.println("Võitis " + mängijad.get(kõigeTugevamIndeks).getNimi());
        mängijad.get(kõigeTugevamIndeks).lisaPunkt();

        return kõigeTugevamIndeks;
    }
}
