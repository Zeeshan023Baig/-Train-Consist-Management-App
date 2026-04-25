import java.util.*;

public class Train {

    // 🔍 Search with validation
    public static boolean searchBogie(String[] arr, String key) {

        // 🔥 Fail-fast check
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        // Linear search (you can also plug binary here)
        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC20 - Safe Search with Exception ");
        System.out.println("=========================================\n");

        String[] bogieIds = {}; // try with empty & non-empty

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Bogie ID to search: ");
        String key = sc.nextLine();

        try {
            boolean found = searchBogie(bogieIds, key);

            if (found) {
                System.out.println("Bogie FOUND ");
            } else {
                System.out.println("Bogie NOT FOUND ");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}