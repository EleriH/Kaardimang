import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Natuke targem mängija kui JuhuslikMängija, kes jälgib ka esimesena lauale käidud kaardi masti.
 * Juhul kui laual on kaart, valib juhuslikult käes olevatest kaartidest ühe sama masti kaardi.
 * Kui sama masti kaarti käes pole või laual pole veel ühtegi kaarti, valib suvalise käes oleva kaardi.
 */
public class TargemJuhuslikMängija extends Mängija {
    public TargemJuhuslikMängija(String nimi) {
        super(nimi);
    }

    @Override
    public Kaart käiKaart(List<Kaart> kaardidLaual) {
        ArrayList<Kaart> valik;

        if (kaardidLaual.isEmpty())
            valik = kaardidKäes;
        else {
            valik = new ArrayList<>();
            int mast = kaardidLaual.get(0).getMast();
            for (Kaart k: kaardidKäes) {
                if (k.getMast() == mast)
                    valik.add(k);
            }
            if (valik.isEmpty())
                valik = kaardidKäes;
        }

        int i = new Random().nextInt(valik.size());
        Kaart ajutine = valik.get(i);
        kaardidKäes.remove(ajutine);
        return ajutine;
    }
}
