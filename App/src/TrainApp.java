import java.util.Arrays;

public class TrainApp {

    public static void main(String[] args) {
        System.out.println("=== Bogie Search with State Validation (UC20) ===");

        String[] activeBogies = {"BG101", "BG205", "BG309"};
        String[] emptyBogies = {};

        try {
            System.out.println("Test: Searching in valid data...");
            performValidatedSearch(activeBogies, "BG205");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\nTest: Searching in empty data...");
            performValidatedSearch(emptyBogies, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        try {
            System.out.println("\nTest: Searching for non-existent bogie...");
            performValidatedSearch(activeBogies, "BG999");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\nTest: Single element case...");
            performValidatedSearch(new String[]{"BG101"}, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void performValidatedSearch(String[] bogies, String key) {
        if (bogies == null || bogies.length == 0) {
            throw new IllegalStateException("Search operation failed: No bogies available in the collection.");
        }

        Arrays.sort(bogies);

        int low = 0;
        int high = bogies.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comp = key.compareTo(bogies[mid]);

            if (comp == 0) {
                found = true;
                break;
            } else if (comp > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (found) {
            System.out.println("Result: Bogie " + key + " identified in system.");
        } else {
            System.out.println("Result: Bogie " + key + " not found.");
        }
    }
}