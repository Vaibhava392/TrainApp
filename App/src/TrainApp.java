import java.util.LinkedList;

/**
 * TrainApp UC4: Physical Train Coupling (LinkedList).
 * Demonstrates node-based insertion and deletion at specific positions.
 */
public class TrainApp {

    public static void main(String[] args) {
        System.out.println("=== Train Assembly (LinkedList) ===");

        // 1. Create a LinkedList for the consist
        // Note: We use LinkedList type to access specific methods like addFirst/addLast
        LinkedList<String> train = new LinkedList<>();

        // 2. Add initial bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("Initial Train: " + train);

        // 3. Insert a Pantry Car at position 2 (Index 2)
        // Key Concept: LinkedList easily makes room for new nodes in the middle.
        train.add(2, "Pantry Car");
        System.out.println("After adding Pantry Car: " + train);

        // 4. Remove the first and last bogie
        // Key Concept: removeFirst() and removeLast() are unique to LinkedList/Deque.
        train.removeFirst(); // Removes Engine
        train.removeLast();  // Removes Guard

        // 5. Display the final ordered train consist
        System.out.println("Final Operational Consist: " + train);
        System.out.println("Current Head: " + train.peekFirst());
    }
}
