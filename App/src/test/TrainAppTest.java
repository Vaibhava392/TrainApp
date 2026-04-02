package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TrainApp UC8: Filtering with Stream API.
 * Demonstrates processing collections using functional pipelines.
 */
public class TrainAppTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return String.format("%s (%d seats)", name, capacity);
        }
    }

    public static void main(String[] args) {
        // 1. Create a List of Bogies (Reused from UC7)
        List<Bogie> train = new ArrayList<>();
        train.add(new Bogie("Sleeper", 72));
        train.add(new Bogie("AC Chair", 56));
        train.add(new Bogie("First Class", 24));
        train.add(new Bogie("General", 90));

        System.out.println("Original Train: " + train);

        // 2. Convert to Stream, 3. Filter, 4. Collect
        // We are filtering for High-Capacity bogies (> 60 seats)
        List<Bogie> highCapacityBogies = train.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // 5. Display the filtered bogies
        System.out.println("=== High Capacity Bogies (> 60 seats) ===");
        highCapacityBogies.forEach(System.out::println);

        System.out.println("\nProgram continues...");
    }
}
