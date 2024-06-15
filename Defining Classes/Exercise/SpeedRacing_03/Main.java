package Advanced.DefiningClasses.Exercise.SpeedRacing_03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        while (number-->0){
            String[] carsInfo = scanner.nextLine().split(" ");
            String model = carsInfo[0];
            double fuelAmount = Double.parseDouble((carsInfo[1]));
            double fuelCostFor1km = Double.parseDouble(carsInfo[2]);

            cars.put(model, new Car(model, fuelAmount, fuelCostFor1km));
        }

        while (true){
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("End")){
                break;
            }
            String model = command[1];
            int amountOfKm = Integer.parseInt(command[2]);
            Car car = cars.get(model);
            if (car.isEnoughFuel(amountOfKm)){
                car.setDistanceTraveled(amountOfKm);
                car.setFuelAmount(amountOfKm);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
        }
        cars.forEach((key, value) -> System.out.printf("%s %.2f %d\n", key, value.getFuelAmount(), value.getDistanceTraveled()));
    }
}
