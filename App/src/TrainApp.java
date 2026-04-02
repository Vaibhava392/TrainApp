import java.util.ArrayList;
import java.util.List;

/**
 * TrainApp: A Management System for Train Consists.
 * This class demonstrates the entry point of a Java application and
 * the initialization of dynamic collections.
 */
public class TrainApp {

    public static void main(String[] args) {
        // 1. Application prints welcome message
        System.out.println("=== Train Consist Management App ===");

        /* * 2. Train consist is initialized
         * Key Concept: Using the List interface with ArrayList implementation.
         * This allows the consist to grow dynamically as bogies are added.
         */
        List<String> trainConsist = new ArrayList<>();

        // 3. Initial bogie count is displayed
        // Key Concept: Using the size() method to get the current count.
        int initialCount = trainConsist.size();
        System.out.println("Initial bogie count: " + initialCount);

        // 4. Program continues
        System.out.println("System initialized and ready for operation.");
    }
}
