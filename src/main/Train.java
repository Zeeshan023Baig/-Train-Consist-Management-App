import java.util.Scanner;

public class Train {

    // 🔍 Linear Search Method
    public static boolean linearSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {

            // Compare using equals()
            if (arr[i].equals(key)) {
                return true; // found → stop early
            }
        }
        return false; // not found
    }

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC18 - Linear Search for Bogie ID ");
        System.out.println("=========================================\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Bogie ID to search: ");
        String searchKey = sc.nextLine();

        boolean found = linearSearch(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie FOUND ");
        } else {
            System.out.println("Bogie NOT FOUND ");
        }

        sc.close();
    }
}