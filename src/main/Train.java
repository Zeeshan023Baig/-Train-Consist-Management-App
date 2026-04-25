import java.util.*;

public class Train {

    // 🔍 Binary Search Method
    public static boolean binarySearch(String[] arr, String key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int cmp = key.compareTo(arr[mid]);

            if (cmp == 0) {
                return true; // found
            } else if (cmp < 0) {
                high = mid - 1; // search left
            } else {
                low = mid + 1; // search right
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("=========================================\n");

        String[] bogieIds = {"BG309","BG101","BG550","BG205","BG412"};

        // 🔥 Step 1: Sort (IMPORTANT precondition)
        Arrays.sort(bogieIds);

        System.out.println("Sorted Bogie IDs:");
        System.out.println(Arrays.toString(bogieIds));

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Bogie ID to search: ");
        String key = sc.nextLine();

        boolean found = binarySearch(bogieIds, key);

        if (found) {
            System.out.println("Bogie FOUND ");
        } else {
            System.out.println("Bogie NOT FOUND ");
        }

        sc.close();
    }
}