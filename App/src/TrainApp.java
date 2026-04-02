import java.util.LinkedHashSet;
import java.util.Set;

/**
 * TrainApp UC5: Ordered Unique Formation.
 * Demonstrates how LinkedHashSet prevents duplicates while keeping the
 * physical attachment sequence intact.
 */
public class TrainApp {

    public static void main(String[] args) {
        System.out.println("=== Train Formation (LinkedHashSet) ===");

        // 1. Create a LinkedHashSet for the formation
        // Key Concept: Set interface ensures uniqueness; LinkedHashSet ensures order.
        Set<String> formation = new LinkedHashSet<>();

        // 2. Attach bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // 3. Attempt to attach a duplicate bogie (Sleeper)
        // Key Concept: The system will identify the duplicate and ignore it.
        System.out.println("Attempting to add duplicate: 'Sleeper'...");
        boolean isAdded = formation.add("Sleeper");

        System.out.println("Was duplicate Sleeper added? " + isAdded);

        // 4. Display the final formation
        // Key Concept: Insertion Order Preservation.
        // Unlike UC3, this will ALWAYS print in the order added.
        System.out.println("\nFinal Train Formation:");
        System.out.println(formation);

        // 5. Verification
        System.out.println("Total unique bogies in sequence: " + formation.size());
    }
}