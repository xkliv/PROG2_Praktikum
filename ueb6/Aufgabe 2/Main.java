
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<Integer, Integer> quersumme = (num) -> {
            num = Math.abs(num);

            int summe = 0;

            while (num > 0) {
                summe += num % 10;
                num = num / 10;
            }
            return summe;
        };

        Function<Integer, Integer> letzteZiffer = (num) -> {

            return num % 10;
        };


        System.out.println(letzteZiffer.apply(756));
        System.out.println(quersumme.apply(456));
    }
}
