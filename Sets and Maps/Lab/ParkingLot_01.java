package Advanced.SetsAndMaps.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        while (true) {
            String[] input = scanner.nextLine().split(", ");
            if (input[0].equals("END")) {
                break;
            }

            switch (input[0]) {
                case "IN":
                    parking.add(input[1]);
                    break;
                case "OUT":
                    parking.remove(input[1]);
                    break;
            }
        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parking) {
                System.out.println(car);
            }
        }

    }
}
