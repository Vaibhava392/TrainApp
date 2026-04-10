import java.util.Arrays;

public class TrainApp {

    public static void main(String[] args) {
        int[] capacities = {72, 56, 24, 70, 60, 90, 15};

        System.out.println("=== Passenger Bogie Capacity Sort (UC16 - Bubble Sort) ===");
        System.out.println("Before Sorting: " + Arrays.toString(capacities));

        bubbleSort(capacities);

        System.out.println("After Sorting : " + Arrays.toString(capacities));

        System.out.println("\n--- Additional Test Cases ---");

        int[] duplicates = {72, 56, 56, 24};
        bubbleSort(duplicates);
        System.out.println("Duplicate Handling: " + Arrays.toString(duplicates));

        int[] single = {50};
        bubbleSort(single);
        System.out.println("Single Element   : " + Arrays.toString(single));
    }

    public static void columnSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swapping Logic
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Explicitly using the Bubble Sort Logic as per requirements
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}