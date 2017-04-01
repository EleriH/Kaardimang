import java.util.List;
import java.util.Random;

/**
 * Valib kardi täitsa juhuslikult olenemata lauale käidud kaartide mastist või numbrist.
 */
public class JuhuslikMängija extends Mängija {

    private final Random random = new Random();

    public JuhuslikMängija(String nimi) {
        super(nimi);
    }

    @Override
    public Kaart käiKaart(List<Kaart> kaardidLaual) {
        int i = random.nextInt(kaardidKäes.size());
        Kaart ajutine = kaardidKäes.get(i);
        kaardidKäes.remove(i);
        return ajutine;
    }
}
