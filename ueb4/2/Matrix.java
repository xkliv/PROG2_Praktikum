public class Matrix<T extends Number> {

    private Number[][] arr;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows and columns must be positive.");
        }

        this.rows = rows;
        this.cols = cols;
        this.arr = new Number[rows][cols];

        // Initialize matrix with 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = 0;
            }
        }
    }

    public void set(int row, int col, T value) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Invalid matrix index.");
        }
        arr[row][col] = value;
    }

    @SuppressWarnings("unchecked")
    public T get(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Invalid matrix index.");
        }
        return (T) arr[row][col];
    }

    public Matrix<Double> add(Matrix<? extends Number> other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }

        Matrix<Double> result = new Matrix<>(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double sum = this.arr[i][j].doubleValue()
                        + other.arr[i][j].doubleValue();

                result.set(i, j, sum);
            }
        }

        return result;
    }

    public Matrix<Double> scalarMulti(Number scalar) {
        Matrix<Double> result = new Matrix<>(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double value = this.arr[i][j].doubleValue()
                        * scalar.doubleValue();

                result.set(i, j, value);
            }
        }

        return result;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            sb.append("[ ");

            for (int j = 0; j < cols; j++) {
                sb.append(arr[i][j]);

                if (j < cols - 1) {
                    sb.append("\s\s");
                }
            }

            sb.append(" ]\n");
        }

        return sb.toString();
    }

}