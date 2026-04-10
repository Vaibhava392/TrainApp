import java.util.Arrays;

public class TrainApp {

    public static void main(String[] args) {
        System.out.println("=== Bogie ID Search (UC19 - Binary Search) ===");

        // Initial Unsorted Data
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        // 1. Precondition: Data must be sorted for Binary Search
        Arrays.sort(bogieIds);
        System.out.println("Sorted Bogie IDs: " + Arrays.toString(bogieIds));

        // Test Case: Search Match Found (Middle/Random)
        performBinarySearch(bogieIds, "BG309");

        // Test Case: First Element Match
        performBinarySearch(bogieIds, "BG101");

        // Test Case: Last Element Match
        performBinarySearch(bogieIds, "BG550");

        // Test Case: Search Match Not Found
        performBinarySearch(bogieIds, "BG999");

        // Test Case: Empty Array Handling
        performBinarySearch(new String[]{}, "BG101");
    }

    public static void performBinarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;
        int foundIndex = -1;

        System.out.print("Searching for " + key + ": ");

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = key.compareTo(arr[mid]);

            if (comparison == 0) {
                foundIndex = mid;
                break; // Found
            } else if (comparison > 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        if (foundIndex != -1) {
            System.out.println("FOUND at index " + foundIndex);
        } else {
            System.out.println("NOT FOUND");
        }
    }
}