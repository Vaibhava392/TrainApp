import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainApp {

    static class Bogie {
        String id;
        int capacity;

        Bogie(String id, int capacity) {
            this.id = id;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        List<Bogie> train = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            train.add(new Bogie("B-" + i, (int) (Math.random() * 100)));
        }

        System.out.println("=== Performance Benchmarking (UC13) ===");

        long startTimeLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : train) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;

        long startTimeStream = System.nanoTime();
        List<Bogie> streamFiltered = train.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;

        System.out.println("Loop Filtered Count: " + loopFiltered.size());
        System.out.println("Stream Filtered Count: " + streamFiltered.size());

        System.out.println("\nExecution Time Results:");
        System.out.println("Loop-Based Timing  : " + durationLoop + " ns");
        System.out.println("Stream-Based Timing: " + durationStream + " ns");

        if (loopFiltered.size() == streamFiltered.size()) {
            System.out.println("\nConsistency Check: PASSED (Results Match)");
        } else {
            System.out.println("\nConsistency Check: FAILED");
        }
    }
}