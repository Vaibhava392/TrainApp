import java.util.Arrays;

public class TrainApp {

    public static void main(String[] args) {
        // 1. Create an array of bogie type names
        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("=== Bogie Name Sorting (UC17 - Arrays.sort) ===");
        System.out.println("Before Sorting: " + Arrays.toString(bogieTypes));

        // 2. Use Arrays.sort() for optimized alphabetical sorting (O(n log n))
        Arrays.sort(bogieTypes);

        // 3. Display the sorted result
        System.out.println("After Sorting : " + Arrays.toString(bogieTypes));

        System.out.println("\n--- Testing Unsorted & Duplicates ---");

        // Test Case: Unsorted Input with Duplicates
        String[] unsortedBogies = {"Luxury", "General", "Sleeper", "AC Chair", "General"};
        Arrays.sort(unsortedBogies);
        System.out.println("Sorted Result : " + Arrays.toString(unsortedBogies));

        // Test Case: Single Element Array
        String[] singleBogie = {"Sleeper"};
        Arrays.sort(singleBogie);
        System.out.println("Single Element: " + Arrays.toString(singleBogie));
    }
}