
class SwapArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        for (int i = 0; i < arr.length / 2; i++) {
            int j = arr.length - i - 1;
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        System.out.println(java.util.Arrays.toString(arr));
    }
}
