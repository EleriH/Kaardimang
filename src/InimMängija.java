import java.util.List;
import java.util.Scanner;

public class InimMängija extends Mängija {

    public InimMängija(String nimi) {
        super(nimi);
    }

    public void ütleKäesOlevadKaardid() {
        String kaardid = "";
        for (int i = 0; i < kaardidKäes.size(); i++) {
           kaardid += i + ": (" + kaardidKäes.get(i) + "), ";
        }
        System.out.println("Sul on käes järgmised kaardid: " + kaardid.substring(0, kaardid.length()-2)); //subString on vajalik, et väljaprinditava lause lõpus poleks üleliigset koma (ja tühikut)
    }

    @Override
    public Kaart käiKaart(List<Kaart> kaardidLaual) {
        System.out.println("Sulle käidi kaart:" + kaardidLaual); //näitab, millise kaardi arvuti Sulle käis
        ütleKäesOlevadKaardid();
        Scanner reader = new Scanner(System.in);
        System.out.println("Sisesta kaardinr, millega tahad vastu käia: ");
        int valitudKaart = reader.nextInt();
        return kaardidKäes.remove(valitudKaart);
    }
}
