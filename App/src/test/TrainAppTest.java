package test;

import java.util.ArrayList;
import java.util.List;

/**
 * TrainApp UC10: Numeric Reduction.
 * Demonstrates transforming objects into values and reducing them to a sum.
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
            return String.format("%s (%d)", name, capacity);
        }
    }

    public static void main(String[] args) {
        // --- SETUP: Data Initialized ---
        List<Bogie> train = new ArrayList<>();
        train.add(new Bogie("Sleeper", 72));
        train.add(new Bogie("AC Chair", 56));
        train.add(new Bogie("First Class", 24));
        train.add(new Bogie("General", 90));

        System.out.println("Running UC10 Test Case: Total Capacity Calculation...");

        // --- EXECUTION: map() and reduce() ---
        // Step 1: mapToInt extracts the capacity
        // Step 2: sum() (a specialized reduction) or reduce(0, Integer::sum)
        int totalCapacity = train.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // --- VERIFICATION ---
        int expectedSum = 72 + 56 + 24 + 90; // 242

        System.out.println("------------------------------------");
        System.out.println("Train Composition: " + train);
        System.out.println("Calculated Total Capacity: " + totalCapacity);

        if (totalCapacity == expectedSum) {
            System.out.println("TEST STATUS: PASSED ✅");
            System.out.println("Reason: Reduction correctly summed all 4 bogies to " + expectedSum);
        } else {
            System.out.println("TEST STATUS: FAILED ❌");
        }
        System.out.println("------------------------------------");
    }
}
