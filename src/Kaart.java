/**
 * Klass kaart vastab teatud kaardipaki kaardile, mille number ja mast on määratud vastavate isendiväljadega.
 * Mõlema isendivälja tüübiks on int, mille tähendus on määratud staatiliste stringi arraydega MASTI_NIMI ja NUMBRI_NIMI.
 * Isendiväljade korrektsust hetkel ei kontrollita. Ebakorrektne väärtus põhjustab programmi töös vea.
 */
public class Kaart {

    private static final String[] MASTI_NIMI = {"ärtu", "poti", "risti", "ruutu"};
    private static final String[] NUMBRI_NIMI = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "poiss", "emand", "kuningas", "äss"};

    private int mast;
    private int number;

    public Kaart(int number, int mast) {
        this.number = number;
        this.mast = mast;
    }

    public int getNumber() {
        return number;
    }

    public int getMast() {
        return mast;
    }

    @Override
    public String toString() {
        return MASTI_NIMI[mast] + " " + NUMBRI_NIMI[number];
    }
}
