import java.util.List;
import java.util.Scanner;

public class InimMängija extends Mängija{

    public InimMängija(String nimi) {
        super(nimi);
    }

    public void ütleKäesOlevadKaardid() {
        System.out.println("Sul on järgmised kaardid: " + kaardidKäes);
    }

    @Override
    public Kaart käiKaart(List<Kaart> kaardidLaual) {
        //Kaart kaart = new Kaart(1, 2);

        // 1. printida välja kaardid koos indeksi väärtusega Kaartide listist

        // 2. võtta sisse kasutaja input - ehk valik mis kaardi mängib
        System.out.println("Sulle käidi kaart:" + kaardidLaual);
        ütleKäesOlevadKaardid();
        Scanner reader = new Scanner(System.in);
        System.out.println("Sisesta kaardinr, millega tahad vastu käia: ");
        int valitudKaart = reader.nextInt();

        return kaardidKäes.get(valitudKaart); // tagastada kaart
    }
}
