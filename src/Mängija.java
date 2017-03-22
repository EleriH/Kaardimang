import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Eleri2 on 20.03.2017.
 */
public abstract class Mängija {
    private String nimi;
    private ArrayList<Kaart> kaardidKäes;

    public Mängija(String nimi) {
        this.nimi = nimi;
        kaardidKäes = new ArrayList<>();
    }

    public void lisaKaart(Kaart kaart){
        kaardidKäes.add(kaart);
    }

    public abstract Kaart käiKaart(List kaardidLaual);

    
}
