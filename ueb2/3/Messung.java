import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Messung {

    public static void main(String[] args) throws IOException {

        Palindrom iterativ = new PalindromIterativ();
        Palindrom rekursiv = new PalindromRekursiv();

        // Datei öffnen zum Schreiben
        try (PrintWriter writer = new PrintWriter(new FileWriter("messung.csv"))) {

            // Überschrift
            writer.println("Laenge,Iterativ_ns,Rekursiv_ns");

            // verschiedene Wortlängen testen
            for (int laenge = 10; laenge <= 10000; laenge += 10) {

                String wort = erzeugeWort(laenge);

                long zeitIterativ = missZeit(iterativ, wort);
                long zeitRekursiv = missZeit(rekursiv, wort);
                writer.println(laenge + "," + zeitIterativ + "," + zeitRekursiv);
            }
        }

        System.out.println("Fertig! Ergebnisse in messung.csv");
    }

    private static long missZeit(Palindrom algo, String wort) {

        long start = System.nanoTime();
        algo.istPalindrom(wort); // Algorithmus ausführen
        long ende = System.nanoTime();

        return ende - start; // Differenz = Laufzeit
    }

    private static String erzeugeWort(int laenge) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < laenge; i++) {
            sb.append('k');
        }
        return sb.toString();
    }
}