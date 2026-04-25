import java.util.Arrays;

public class Train {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC17 - Sort Bogie Names using Arrays.sort()");
        System.out.println("=========================================\n");

        String[] bogieNames = {
                "Sleeper", "AC Chair", "First Class", "General", "Luxury"
        };

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(bogieNames));

        // 🔥 Built-in sort (alphabetical for String)
        Arrays.sort(bogieNames);

        System.out.println("\nAfter Sorting:");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nSorting completed...");
    }
}