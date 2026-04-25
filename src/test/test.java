import java.util.*;
import java.util.stream.*;

public class UseCase9TrainConsistMgmt {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("=========================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 80));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 60));

        // 🔥 Grouping using Streams
        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        // Display grouped result
        System.out.println("Grouped Bogies:\n");

        groupedBogies.forEach((type, list) -> {
            System.out.println(type + ":");
            list.forEach(b -> System.out.println("   " + b));
        });

        System.out.println("\nUC9 grouping completed...");
    }
}