public class Hanoi {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java Hanoi <AnzahlScheiben>");
            return;
        }

        int n = Integer.parseInt(args[0]);

        bewege(n, "A", "B", "C");
    }

    private static void bewege(int i, String a, String b, String c) {

        if (i > 0) {
            bewege(i - 1, a, c, b);

            System.out.println("Verschiebe Scheibe von " + a + " nach " + c);

            bewege(i - 1, b, a, c);
        }
    }
}