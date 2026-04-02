import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * TrainApp UC7: Custom Sorting with Comparator.
 * Demonstrates how to sort objects based on specific internal fields.
 */
public class TrainApp {

    // 1. Create a Bogie class (Static nested class for this example)
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        // Overriding toString to make printing easy
        @Override
        public String toString() {
            return String.format("%s (%d seats)", name, capacity);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Passenger Bogie Sorting (Comparator) ===");

        // 2. Create a List<Bogie> and add objects
        List<Bogie> train = new ArrayList<>();
        train.add(new Bogie("Sleeper", 72));
        train.add(new Bogie("AC Chair", 56));
        train.add(new Bogie("First Class", 24));
        train.add(new Bogie("General", 90));

        System.out.println("Before Sorting: " + train);

        // 3. Apply a Comparator to sort by capacity (Ascending)
        // Key Concept: Lambda Expression used for concise sorting logic
        train.sort(Comparator.comparingInt(b -> b.capacity));

        // 4. Sorted bogies are displayed
        System.out.println("After Sorting (Capacity Low to High): " + train);

        // Optional: Sorting in reverse (High to Low)
        train.sort(Comparator.comparingInt((Bogie b) -> b.capacity).reversed());
        System.out.println("After Sorting (Capacity High to Low): " + train);
    }
}