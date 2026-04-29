
class Main {

    public static void permute(int[] arr, int index) {

        if (index == arr.length) {
            System.out.println(java.util.Arrays.toString(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // swap
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

            // Das Element an der Position "index" wird fixiert,
            // wenn wir permute(arr, index + 1) aufrufen
            permute(arr, index + 1);

            // backtrack
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        permute(arr, 0);
    }
}
