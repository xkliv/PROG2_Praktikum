
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<Integer, Integer> quersumme = num -> {
            num = Math.abs(num);

            int summe = 0;

            while (num > 0) {
                summe += num % 10;
                num = num / 10;
            }
            return summe;
        };

        Function<Integer, Integer> letzteZiffer = num -> num % 10;

        Function<Integer, Integer> letzteBeidenZiffen = num -> num % 100;

        System.out.println(letzteBeidenZiffen.apply(13344));
        System.out.println(letzteZiffer.apply(756));
        System.out.println(quersumme.apply(456));
    }
}
