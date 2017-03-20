import java.util.List;

/**
 * Created by Eleri2 on 20.03.2017.
 */
public class KaardisegajaTest {
    public static void main(String[] args) {
        List<Kaart> pakk = Kaardisegaja.valiKaardipakk(true);

        for (Kaart k: pakk) {
            System.out.println(k);
        }
    }
}
