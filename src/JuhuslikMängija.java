import java.util.List;
import java.util.Random;

/**
 * Valib kardi täitsa juhuslikult olenemata lauale käidud kaartide mastist või numbrist.
 */
public class JuhuslikMängija extends Mängija{

    public JuhuslikMängija(String nimi) {
        super(nimi);
    }


    @Override
    public Kaart käiKaart(List<Kaart> kaardidLaual) {
        int i= new Random().nextInt(kaardidKäes.size());
        Kaart ajutine= kaardidKäes.get(i);
        kaardidKäes.remove(i);
        return ajutine;
    }
}
