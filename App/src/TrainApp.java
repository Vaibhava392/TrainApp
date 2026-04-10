class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bogie Type: " + type + ", Capacity: " + capacity;
    }
}

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Passenger Bogie Validation (UC14) ===");

        // Test Case: Valid Capacity
        try {
            System.out.println("Attempting to create bogie with capacity 72...");
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Success: " + b1);
        } catch (InvalidCapacityException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Testing Invalid Scenarios ---");

        // Test Case: Zero Capacity
        try {
            System.out.println("Attempting to create bogie with capacity 0...");
            PassengerBogie b2 = new PassengerBogie("General", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        // Test Case: Negative Capacity
        try {
            System.out.println("\nAttempting to create bogie with capacity -10...");
            PassengerBogie b3 = new PassengerBogie("AC Chair", -10);
        } catch (InvalidCapacityException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        System.out.println("\nProgram execution continues safely...");
    }
}