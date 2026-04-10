class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String shape;
    private String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargo) {
        System.out.println("Attempting to assign " + cargo + " to " + shape + " bogie...");
        try {
            if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("SAFETY VIOLATION: Petroleum cannot be carried in a Rectangular bogie!");
            }
            this.cargo = cargo;
            System.out.println("Success: Cargo assigned successfully.");
        } catch (CargoSafetyException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        } finally {
            System.out.println("[System Log]: Cargo validation process completed for " + shape + " bogie.");
        }
    }

    @Override
    public String toString() {
        return "Bogie [Shape=" + shape + ", Cargo=" + (cargo == null ? "None" : cargo) + "]";
    }
}

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Cargo Assignment Safety System (UC15) ===");

        // Case 1: Safe Assignment
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        b1.assignCargo("Petroleum");
        System.out.println(b1);

        System.out.println("\n-------------------------------------------");

        // Case 2: Unsafe Assignment
        GoodsBogie b2 = new GoodsBogie("Rectangular");
        b2.assignCargo("Petroleum");
        System.out.println(b2);

        System.out.println("\n-------------------------------------------");

        // Case 3: Safe Assignment for Rectangular
        GoodsBogie b3 = new GoodsBogie("Rectangular");
        b3.assignCargo("Coal");
        System.out.println(b3);

        System.out.println("\nProgram execution finished safely.");
    }
}