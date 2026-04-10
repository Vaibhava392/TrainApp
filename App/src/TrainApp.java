import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Train System Validation (UC11) ===");

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainIdInput = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCodeInput = scanner.nextLine();

        Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");

        Matcher trainIdMatcher = trainIdPattern.matcher(trainIdInput);
        Matcher cargoCodeMatcher = cargoCodePattern.matcher(cargoCodeInput);

        boolean isTrainIdValid = trainIdMatcher.matches();
        boolean isCargoCodeValid = cargoCodeMatcher.matches();

        System.out.println("\n--- Validation Results ---");

        if (isTrainIdValid) {
            System.out.println("Train ID [" + trainIdInput + "]: VALID");
        } else {
            System.out.println("Train ID [" + trainIdInput + "]: INVALID (Required format: TRN-xxxx)");
        }

        if (isCargoCodeValid) {
            System.out.println("Cargo Code [" + cargoCodeInput + "]: VALID");
        } else {
            System.out.println("Cargo Code [" + cargoCodeInput + "]: INVALID (Required format: PET-XX)");
        }

        scanner.close();
    }
}