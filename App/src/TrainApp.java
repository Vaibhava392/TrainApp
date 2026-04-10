import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {
        List<GoodsBogie> train = new ArrayList<>();

        train.add(new GoodsBogie("Cylindrical", "Petroleum"));
        train.add(new GoodsBogie("Box", "Coal"));
        train.add(new GoodsBogie("Open", "Grain"));
        train.add(new GoodsBogie("Cylindrical", "Petroleum"));

        System.out.println("=== Train Safety Compliance Check (UC12) ===");

        boolean isSafe = train.stream().allMatch(bogie -> {
            if (bogie.type.equalsIgnoreCase("Cylindrical")) {
                return bogie.cargo.equalsIgnoreCase("Petroleum");
            }
            return true;
        });

        if (isSafe) {
            System.out.println("Result: Train is SAFETY COMPLIANT. All rules satisfied.");
        } else {
            System.out.println("Result: Train is UNSAFE. Safety violation detected in cargo configuration.");
        }

        System.out.println("\nTesting Invalid Configuration...");
        train.add(new GoodsBogie("Cylindrical", "Chemicals"));

        boolean isStillSafe = train.stream().allMatch(bogie ->
                !bogie.type.equalsIgnoreCase("Cylindrical") || bogie.cargo.equalsIgnoreCase("Petroleum")
        );

        if (!isStillSafe) {
            System.out.println("Result: Train is UNSAFE. (Cylindrical bogies must only carry Petroleum).");
        }
    }
}