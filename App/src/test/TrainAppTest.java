import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TrainApp UC8 Test: Filtering Logic Verification.
 * This class simulates a test case to ensure the Stream filter correctly
 * identifies bogies with capacity > 60.
 */
public class TrainApp {

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
        // --- SETUP: Create the test data ---
        List<Bogie> train = new ArrayList<>();
        train.add(new Bogie("Sleeper", 72));      // Expected: Pass
        train.add(new Bogie("AC Chair", 56));     // Expected: Fail
        train.add(new Bogie("First Class", 24));  // Expected: Fail
        train.add(new Bogie("General", 90));       // Expected: Pass

        System.out.println("Running UC8 Test Case...");

        // --- EXECUTION: Apply Stream API logic ---
        // We filter for capacity > 60
        List<Bogie> result = train.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // --- VERIFICATION: Check if results match expectations ---
        boolean isCorrectSize = (result.size() == 2);
        boolean containsSleeper = result.stream().anyMatch(b -> b.name.equals("Sleeper"));
        boolean containsGeneral = result.stream().anyMatch(b -> b.name.equals("General"));

        System.out.println("------------------------------------");
        System.out.println("Filtered Bogies: " + result);
        
        if (isCorrectSize && containsSleeper && containsGeneral) {
            System.out.println("TEST STATUS: PASSED ✅");
            System.out.println("Reason: Correctly identified 2 bogies (Sleeper & General) with capacity > 60.");
        } else {
            System.out.println("TEST STATUS: FAILED ❌");
            System.out.println("Reason: The filtered list does not match the expected criteria.");
        }
        System.out.println("------------------------------------");
        
        System.out.println("Program continues...");
    }
}
