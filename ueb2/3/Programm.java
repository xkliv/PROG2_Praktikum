import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Programm {

    public static void main(String[] args) throws IOException {

        if (args.length < 3) {
            System.out.println("Usage: java Programm.java <iterativ/rekursiv> <wort/datei> <Otto/input.txt>");
            return;
        }

        Palindrom palindrom = algorithmus(args[0]);
        String wort = leseEingabe(args[1], args[2]);

        boolean ergebnis = palindrom.istPalindrom(wort);

        if (ergebnis) {
            System.out.println("\"" + wort + "\" ist ein Palindrom.");
        } else {
            System.out.println("\"" + wort + "\" ist kein Palindrom.");
        }
    }

    private static Palindrom algorithmus(String name) {
        if (name.equalsIgnoreCase("iterativ")) {
            return new PalindromIterativ();
        }

        if (name.equalsIgnoreCase("rekursiv")) {
            return new PalindromRekursiv();
        }

        throw new IllegalArgumentException("Unbekannter Algorithmus: " + name);
    }

    private static String leseEingabe(String typ, String wert) throws IOException {
        if (typ.equalsIgnoreCase("wort")) {
            return wert;
        }

        if (typ.equalsIgnoreCase("datei")) {
            return Files.readString(Path.of(wert)).trim();
        }

        throw new IllegalArgumentException("Unbekannter Eingabetyp: " + typ);
    }
}