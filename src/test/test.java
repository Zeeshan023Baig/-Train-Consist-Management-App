import java.util.*;
import java.util.stream.*;

public class Train {

    // Simple Bogie model
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC13 - Performance (Loop vs Stream) ");
        System.out.println("=========================================\n");

        // Create a LARGE dataset for meaningful timing
        List<Bogie> bogies = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 200_000; i++) {
            int cap = 20 + r.nextInt(100); // 20..119
            bogies.add(new Bogie("Passenger", cap));
        }

        int threshold = 60;

        // ---------------- LOOP ----------------
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > threshold) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // ---------------- STREAM ----------------
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .toList();

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // ---------------- OUTPUT ----------------
        System.out.println("Loop result size   : " + loopResult.size());
        System.out.println("Stream result size : " + streamResult.size());

        System.out.println("\nExecution Time:");
        System.out.println("Loop   : " + loopTime + " ns");
        System.out.println("Stream : " + streamTime + " ns");

        System.out.println("\nResults match? " + (loopResult.size() == streamResult.size()));
    }
}