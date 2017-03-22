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
            for (int i = 0; i < 8 ; i++) {
                k.lisaKaart(kaardidPakis.get(0));
                kaardidPakis.remove(0);
            }
        }

        int järgmineAlustaja= new Random().nextInt(mängijad.size());
        while (kaardidPakis.size()<mängijad.size()){
            järgmineAlustaja= mänguring(järgmineAlustaja)
        }
    }

    public int mänguring(int mängijaIndeks){

    }
}
