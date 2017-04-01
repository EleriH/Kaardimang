import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Klass, mis korraldab kaardimängu. St. jagab mängijatele pakist kaardid, küsib ükshaaval mängijate käest, millise
 * kaardi nad soovivad käia ja jagab võitjale punkte.
 * <p>
 * Kaardimäng koosneb mänguringidest. Kõigepealt jagatakse igale mängijale kaardipakist 8 kaarti.
 * Igas mänguringis käivad mängijad järjestikku lauale kaarte. Esimesena lauda käidud kaart määrab mänguringi masti.
 * Võidab mängija, kes käis kõige tugevama antud masti kaardi.
 * <p>
 * Esimest mänguringi alustab juhuslikult valitud mängija.
 * Järgmisi mänguringe alustab eelimise ringi võitja.
 * Edasi käivad mängijad kaarte vastavalt mängijate listi järjekorrale, mis antud klassi konstruktoris.
 * <p>
 * Mäng lõpeb, kui kaardipakis pole kaarte, et kõikidele mängijatele käidud kaardi asemele uut anda.
 */
public class Mäng {
    private List<Kaart> kaardidPakis;
    private List<Mängija> mängijad;

    /**
     * Konstruktor
     *
     * @param kaardidPakis list kaartidest, mis mängu pannakse
     * @param mängijad     list mängijatest, kes mängust osa võtavad
     */
    public Mäng(List<Kaart> kaardidPakis, List<Mängija> mängijad) {
        this.kaardidPakis = kaardidPakis;
        this.mängijad = mängijad;
    }

    /**
     * Viib läbi terve mängu kuni pakis pole enam kaarte, et saaks kõigile mängijate käidud kaardi asemele ühe juurde
     * anda.
     * <p>
     * Mängu käik ja tulemused trükitakse ekraanile
     */
    public void mängi() {
        for (Mängija mängija : mängijad) {
            for (int i = 0; i < 8; i++) {
                mängija.lisaKaart(kaardidPakis.get(0));
                kaardidPakis.remove(0);
            }
        }

        int järgmineAlustaja = new Random().nextInt(mängijad.size());
        int ringiNumber = 1;
        while (kaardidPakis.size() > mängijad.size()) {
            System.out.println("\u001B[32mMänguring " + ringiNumber + "\u001B[0m"); //mänguring väljastatakse rohelise värviga
            järgmineAlustaja = mänguring(järgmineAlustaja);
            for (Mängija m : mängijad) {
                m.lisaKaart(kaardidPakis.get(0));
                kaardidPakis.remove(0);
            }
            ringiNumber++;
        }

        System.out.println("\nTulemused:");
        for (Mängija m : mängijad) {
            System.out.println(m.getNimi() + ": " + m.getSkoor());
        }
    }

    /**
     * Viib läbi ühe mänguringi
     *
     * @param alustajaIndeks mänguringi alustava mängija indeks mängijate listis
     * @return võitja indeks
     */
    private int mänguring(int alustajaIndeks) {
        List<Kaart> kaardidLaual = new ArrayList<>();

        int kõigeTugevamIndeks = -1;
        Kaart kõigeTugevamKaart = null;
        int i = alustajaIndeks;
        do {
            // Küsitakse mängijalt kaarti ja lisatakse see lauale
            Mängija mängija = mängijad.get(i);
            Kaart k = mängija.käiKaart(kaardidLaual);
            kaardidLaual.add(k);
            System.out.println(mängija.getNimi() + " käib " + k);

            // Kontrollitakse, kas käidud kaart on uus tugevaim kaart
            if ((i == alustajaIndeks) ||
                    ((k.getMast() == kõigeTugevamKaart.getMast()) &&
                            (k.getNumber() > kõigeTugevamKaart.getNumber()))) {
                kõigeTugevamIndeks = i;
                kõigeTugevamKaart = k;
            }

            // Valitakse järgmine mängija. Kui listi lõpus, siis jätkatakse algusest, kuni jõutakse ringi alustanud
            // mängija juurde tagasi
            i++;
            if (i == mängijad.size())
                i = 0;
        } while (i != alustajaIndeks);

        System.out.println("Võitis " + mängijad.get(kõigeTugevamIndeks).getNimi());
        mängijad.get(kõigeTugevamIndeks).lisaPunkt();

        return kõigeTugevamIndeks;
    }
}
