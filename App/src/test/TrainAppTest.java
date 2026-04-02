package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TrainApp UC9 Test: Data Aggregation with groupingBy().
 * Verifies that flat list data can be transformed into a structured Map.
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
            return String.format("[Cap: %d]", capacity);
        }
    }

    public static void main(String[] args) {
        // --- SETUP: Create the test data with duplicate names for grouping ---
        List<Bogie> train = new ArrayList<>();
        train.add(new Bogie("Sleeper", 72));
        train.add(new Bogie("Sleeper", 72));
        train.add(new Bogie("AC Chair", 56));
        train.add(new Bogie("General", 90));
        train.add(new Bogie("AC Chair", 56));

        System.out.println("Running UC9 Test Case: Grouping by Name...");

        // --- EXECUTION: Apply groupingBy() ---
        // Classification function: b -> b.name (The Key in the Map)
        // Values: List of Bogie objects belonging to that name
        Map<String, List<Bogie>> groupedBogies = train.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        // --- VERIFICATION: Validate the Map structure ---
        boolean hasThreeGroups = (groupedBogies.size() == 3);
        int sleeperCount = groupedBogies.get("Sleeper").size();

        System.out.println("------------------------------------");
        System.out.println("Grouped Result:");
        groupedBogies.forEach((name, list) ->
                System.out.println(name + " Type -> " + list));

        if (hasThreeGroups && sleeperCount == 2) {
            System.out.println("\nTEST STATUS: PASSED ✅");
            System.out.println("Reason: Data correctly aggregated into 3 distinct categories.");
        } else {
            System.out.println("\nTEST STATUS: FAILED ❌");
        }
        System.out.println("------------------------------------");
    }
}
