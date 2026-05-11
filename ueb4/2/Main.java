public class Main {
    public static void main(String[] args) {

        Matrix<Integer> matrix1 = new Matrix<>(2, 2);
        Matrix<Integer> matrix2 = new Matrix<>(2, 2);
        matrix1.set(0, 0, 1);
        matrix1.set(0, 1, 1);
        matrix1.set(1, 0, 1);
        matrix1.set(1, 1, 1);

        matrix2.set(0, 0, 4);
        matrix2.set(0, 1, 5);
        matrix2.set(1, 0, 3);
        matrix2.set(1, 1, 7);

        System.out.println(matrix1.add(matrix2));

        System.out.println(matrix1.scalarMulti(9));
    }
}
