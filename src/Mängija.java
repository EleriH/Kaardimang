import java.util.ArrayList;
import java.util.List;

/**
 * Abstarktne alusklass ühe mängu mängija kohta, mille funktsiooniks on hoida kättejagatud kaardipakki ja otsustada,
 * milline kaart igal mängu sammul käia sõltuvalt juba lauale käidud kaartidest.
 */
public abstract class Mängija {
    protected String nimi;
    protected ArrayList<Kaart> kaardidKäes;
    private int skoor;

    public Mängija(String nimi) {
        this.nimi = nimi;
        kaardidKäes = new ArrayList<>();
        skoor = 0;
    }

    public void lisaKaart(Kaart kaart){
        kaardidKäes.add(kaart);
    }

    public abstract Kaart käiKaart(List<Kaart> kaardidLaual);

    public String getNimi() {
        return nimi;
    }

    public int getSkoor() {
        return skoor;
    }

    public void lisaPunkt() {
        skoor++;
    }
}
