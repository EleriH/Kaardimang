/**
 * Klass kaart vastab teatud kaardipaki kaardile, mille number ja mast on määratud vastavate isendiväljadega.
 * Mõlema isendivälja tüübiks on int, mille tähendus on määratud staatiliste stringi arraydega mastiNimi ja numbriNimi.
 * Isendiväljade korrektsust hetkel ei kontrollita. Ebakorrektne väärtus põhjustab programmi töös vea.
 */
public class Kaart {

    private int number;
    private int mast;

    private static String[] mastiNimi = {"ärtu", "poti", "risti", "ruutu"};
    private static String[] numbriNimi = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "poiss", "emand", "kuningas", "äss"};

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
        return mastiNimi[mast] + " " + numbriNimi[number];
    }
}
