public class Main {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        System.out.println(calc.compute(5, 6, calc.subtraction));
        System.out.println(calc.compute(5, 6, calc.multiplication));
        System.out.println(calc.compute(5, 0, calc.divde));
        System.out.println(calc.compute(5, 6, calc.addition));
    }
}