import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class StringProcessor {

    private LinkedList<String> strings;

    public StringProcessor() {
        strings = new LinkedList<>();
    }

    public StringProcessor(String[] values) {
        strings = new LinkedList<>();

        for (String string : values) {
            strings.addLast(string);
        }
    }

    public void add(String value) {
        strings.addLast(value);
    }

    // Predicate<String>
    // Nimmt einen String entgegen und gibt einen boolean-Wert zurück.
    // Nur Strings, für die true zurückgegeben wird,
    // werden in die Ergebnisliste übernommen.
    public LinkedList<String> filter(Predicate<String> predicate) {

        LinkedList<String> result = new LinkedList<>();

        for (String string : strings) {
            if (predicate.test(string)) {
                result.addLast(string);
            }
        }

        return result;
    }

    // UnaryOperator<String>
    // Nimmt einen String entgegen und gibt einen neuen String zurück.
    // Die Operation wird auf jeden String angewendet.
    public LinkedList<String> applyToAll(UnaryOperator<String> operation) {

        LinkedList<String> result = new LinkedList<>();

        for (String string : strings) {
            String newString = operation.apply(string);
            result.addLast(newString);
        }

        return result;
    }

    // Function<String, Integer>
    // Nimmt einen String entgegen und wandelt ihn in einen Integer um.
    // Die erzeugten Integer-Werte werden in einer neuen Liste gespeichert.
    public LinkedList<Integer> mapToInt(Function<String, Integer> function) {

        LinkedList<Integer> result = new LinkedList<>();

        for (String string : strings) {
            Integer number = function.apply(string);
            result.addLast(number);
        }

        return result;
    }

    // Consumer<String>
    // Nimmt einen String entgegen und führt eine Aktion aus.
    // Es wird kein Wert zurückgegeben und die Liste nicht verändert.
    public void forEach(Consumer<String> consumer) {
        for (String string : strings) {
            consumer.accept(string);
        }
    }
}
