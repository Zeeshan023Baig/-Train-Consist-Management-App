import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class Train {

    static class Bogie {
        int capacity;

        Bogie(int capacity) {
            this.capacity = capacity;
        }
    }

    private int getTotal(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = List.of(
                new Bogie(70),
                new Bogie(30)
        );

        assertEquals(100, getTotal(bogies));
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = List.of(
                new Bogie(10),
                new Bogie(20),
                new Bogie(30)
        );

        assertEquals(60, getTotal(bogies));
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = List.of(
                new Bogie(50)
        );

        assertEquals(50, getTotal(bogies));
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        assertEquals(0, getTotal(bogies));
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = List.of(
                new Bogie(40),
                new Bogie(60)
        );

        assertEquals(100, getTotal(bogies));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = List.of(
                new Bogie(10),
                new Bogie(20),
                new Bogie(30),
                new Bogie(40)
        );

        assertEquals(100, getTotal(bogies));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie(10));

        int size = bogies.size();

        getTotal(bogies);

        assertEquals(size, bogies.size());
    }
}