
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

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

        Predicate<Integer> isNegative = num -> num < 0;
        Predicate<Integer> isEven = num -> num % 2 == 0;

        IntFunction<IntPredicate> isDivisorOf = x -> y -> y != 0 && x % y == 0;

        System.out.println(isDivisorOf.apply(9).test(3));
        System.out.println(isEven.test(5));
        System.out.println(isNegative.test(3));
        System.out.println(letzteBeidenZiffen.apply(13344));
        System.out.println(letzteZiffer.apply(756));
        System.out.println(quersumme.apply(456));
    }
}
