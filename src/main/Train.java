import java.util.Arrays;

public class Train {

    // 🔥 Bubble Sort Method
    public static void bubbleSort(int[] arr) {

        int n = arr.length;

        // Outer loop → passes
        for (int i = 0; i < n - 1; i++) {

            // Inner loop → compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {

                // Swap if out of order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC16 - Bubble Sort Passenger Capacities ");
        System.out.println("=========================================\n");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(capacities));

        // 🔥 Apply Bubble Sort
        bubbleSort(capacities);

        System.out.println("\nAfter Sorting:");
        System.out.println(Arrays.toString(capacities));

        System.out.println("\nSorting completed...");
    }
}