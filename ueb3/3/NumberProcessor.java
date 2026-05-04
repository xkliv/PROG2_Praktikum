public class NumberProcessor {
    // Enthält die zu verarbeitenden Werte
    private int[] values;

    /*
     * *
     * Konstruktor erhält das zu analysierende Array .
     * 
     * @param values das int - Array , z . B . Messwerte oder Punktestände
     */
    public NumberProcessor(int[] values) {
        this.values = values.clone(); // Kopie für Immutability
    }

    public void printGreaterThan(int threshold) {
        class Filter {
            public void printer() {
                System.out.println("Numbers greaterthan " + threshold + ":");
                for (int item : values) {
                    if (threshold < item) {
                        System.out.println("- " + item);
                    }
                }
            }
        }
        Filter f = new Filter();
        f.printer();
    }
}