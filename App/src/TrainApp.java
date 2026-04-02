import java.util.HashSet;
import java.util.Set;

/**
 * TrainApp UC3: Unique Bogie ID Management.
 * Demonstrates the behavior of Sets: Uniqueness and Unordered storage.
 */
public class TrainApp {

    public static void main(String[] args) {
        System.out.println("=== Train ID Registry (HashSet) ===");

        // 1. Create a HashSet for bogie IDs
        // Key Concept: Set interface is used for the reference type.
        Set<String> bogieIds = new HashSet<>();

        // 2. Add bogie IDs (including intentional duplicates)
        bogieIds.add("B-101");
        bogieIds.add("B-102");
        bogieIds.add("B-103");

        // Attempting to add a duplicate ID
        System.out.println("Adding duplicate ID: B-101...");
        bogieIds.add("B-101");

        // 3. Observe Automatic Deduplication
        // Key Concept: The add() method returns false if the item already exists.
        boolean addedAgain = bogieIds.add("B-102");
        System.out.println("Was B-102 added again? " + addedAgain);

        // 4. Display Unique IDs
        // Key Concept: Unordered Storage. The output order may differ from insertion.
        System.out.println("\nRegistered Unique Bogie IDs:");
        System.out.println(bogieIds);

        System.out.println("Total Unique Bogies: " + bogieIds.size());
    }
}
