public class TrainApp {

    public static void main(String[] args) {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        System.out.println("=== Bogie ID Search (UC18 - Linear Search) ===");

        // Test Case: Search Match Found
        String searchKey1 = "BG309";
        performLinearSearch(bogieIds, searchKey1);

        // Test Case: Search Match Not Found
        String searchKey2 = "BG999";
        performLinearSearch(bogieIds, searchKey2);

        // Test Case: First Element Match
        String searchKey3 = "BG101";
        performLinearSearch(bogieIds, searchKey3);

        // Test Case: Last Element Match
        String searchKey4 = "BG550";
        performLinearSearch(bogieIds, searchKey4);
    }

    public static void performLinearSearch(String[] arr, String key) {
        boolean found = false;
        int indexFound = -1;

        System.out.print("Searching for " + key + ": ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                found = true;
                indexFound = i;
                break; // Early Termination
            }
        }

        if (found) {
            System.out.println("FOUND at index " + indexFound);
        } else {
            System.out.println("NOT FOUND");
        }
    }
}