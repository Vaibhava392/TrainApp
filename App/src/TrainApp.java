import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: UC2 ===");

        // 1. Create an ArrayList for passenger bogies
        List<String> bogies = new ArrayList<>();

        // 2. Add bogies: Sleeper, AC Chair, First Class
        // Key Concept: add() appends elements and preserves insertion order.
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");

        // 3. Print the list after insertion
        System.out.println("Current Bogies: " + bogies);

        // 4. Remove one bogie (AC Chair)
        // Key Concept: remove() shifts subsequent elements to fill the gap.
        bogies.remove("AC Chair");
        System.out.println("After removing AC Chair: " + bogies);

        // 5. Use contains() to check if 'Sleeper' exists
        // Key Concept: contains() returns a boolean (true/false).
        boolean hasSleeper = bogies.contains("Sleeper");
        System.out.println("Is 'Sleeper' in the consist? " + hasSleeper);

        // 6. Print final list state
        System.out.println("Final Train Consist: " + bogies);
        System.out.println("Total bogies remaining: " + bogies.size());
    }
}
