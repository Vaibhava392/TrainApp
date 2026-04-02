import java.util.HashMap;
import java.util.Map;

/**
 * TrainApp UC6: Bogie Capacity Mapping.
 * Demonstrates the use of Key-Value pairs to store operational data.
 */
public class TrainApp {

    public static void main(String[] args) {
        System.out.println("=== Train Capacity Registry (HashMap) ===");

        // 1. Create a HashMap: String (Bogie Name) -> Integer (Capacity)
        // Key Concept: Map interface used for declaration.
        Map<String, Integer> capacityMap = new HashMap<>();

        // 2. Insert bogie-capacity mapping using put()
        // Key-Value Association: Key (Unique) -> Value (Can be duplicates)
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);
        capacityMap.put("First Class", 24);
        capacityMap.put("General", 90);

        // 3. System iterates through the map
        // Key Concept: entrySet() allows us to access both Key and Value in a loop.
        System.out.println("\nBogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            String bogieType = entry.getKey();
            Integer capacity = entry.getValue();

            // 4. Display details
            System.out.println("Bogie: " + bogieType + " | Capacity: " + capacity + " seats");
        }

        // 5. Fast Lookup Demonstration
        // HashMap allows instant retrieval if you know the key.
        System.out.println("\nChecking specific capacity for 'AC Chair'...");
        System.out.println("Result: " + capacityMap.get("AC Chair") + " seats");
    }
}