public class StringProcessorDrive {
    public static void main(String[] args) {

        StringProcessor sp = new StringProcessor();

        sp.add("  Kasem  ");
        sp.add("ahmad");
        sp.add("Erik");
        sp.add("Sarah");
        sp.add("maria");
        sp.add("Alexander");
        sp.add("Ali");
        sp.add("Yasmin");

        // Filtert alle Strings, die länger als fünf Zeichen sind.
        LinkedList<String> longerThanFive = sp.filter(s -> s.length() > 5);
        for (String s : longerThanFive) {
            System.out.println(s);
        }

        // Filtert alle Strings, die mit einem Großbuchstaben beginnen.
        LinkedList<String> startsWithUppercase = sp.filter(s -> Character.isUpperCase(s.trim().charAt(0)));
        for (String s : startsWithUppercase) {
            System.out.println(s);
        }

        // Entfernt führende und nachfolgende Leerzeichen.
        LinkedList<String> trimmed = sp.applyToAll(s -> s.trim());
        for (String s : trimmed) {
            System.out.println(s);
        }

        // Wandelt alle Strings in Großbuchstaben um.
        LinkedList<String> upperCase = sp.applyToAll(s -> s.toUpperCase());
        for (String s : upperCase) {
            System.out.println(s);
        }

        // Kehrt alle Strings um.
        LinkedList<String> reversed = sp.applyToAll(s -> new StringBuilder(s).reverse().toString());
        for (String s : reversed) {
            System.out.println(s);
        }

        // Wandelt alle Strings in ihre jeweilige Länge um.
        LinkedList<Integer> lengths = sp.mapToInt(s -> s.length());
        for (Integer length : lengths) {
            System.out.println(length);
        }

        // Zählt die Anzahl der Vorkommen des Buchstabens 'a'.
        LinkedList<Integer> countA = sp.mapToInt(s -> (int) s.chars()
                .filter(c -> c == 'a')
                .count());
        for (Integer count : countA) {
            System.out.println(count);
        }

        // Gibt alle Strings mit einem vorangestellten » aus.
        sp.forEach(s -> System.out.println("»" + s));

        // Gibt alle Strings unverändert aus.
        sp.forEach(System.out::println);

        // Gibt alle Strings mit ihrer jeweiligen Länge in Klammern aus.
        sp.forEach(s -> System.out.println(s + " (" + s.length() + ")"));
    }
}