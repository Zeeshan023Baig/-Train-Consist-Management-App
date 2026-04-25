import java.util.*;

public class Train {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC10 - Count Total Seats using reduce ");
        System.out.println("=========================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        // 🔥 map + reduce
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)          // extract numbers
                .reduce(0, Integer::sum);     // sum all

        System.out.println("Total Seating Capacity: " + totalSeats);

        System.out.println("\nUC10 aggregation completed...");
    }
}