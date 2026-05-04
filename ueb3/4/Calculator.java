public class Calculator {
    // trying lampda
    BinaryOperation addition = (a, b) -> a + b;

    BinaryOperation subtraction = new BinaryOperation() {
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    };

    BinaryOperation divde = new BinaryOperation() {
        @Override
        public int apply(int a, int b) {
            return a / b;
        }
    };

    BinaryOperation multiplication = new BinaryOperation() {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    };

    public int compute(int a, int b, BinaryOperation op) {
        return op.apply(a, b);
    }
}
