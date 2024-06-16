package Advanced.DefiningClasses.Exercise.CarSalesman_05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engineMap = new HashMap<>();

        int number = Integer.parseInt(scanner.nextLine());

        while (number-- > 0) {
            String[] engineData = scanner.nextLine().split(" ");
            String model = engineData[0];
            String power = engineData[1];
            Engine engine;

            if (engineData.length == 4) {
                String displacement = engineData[2];
                String efficiency = engineData[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (engineData.length == 3) {
                if (Character.isDigit(engineData[2].charAt(0))) {
                    String displacement = engineData[2];
                    engine = new Engine(model, power, displacement, "n/a");
                } else {
                    String efficiency = engineData[2];
                    engine = new Engine(model, power, "n/a", efficiency);
                }
            } else {
                engine = new Engine(model, power, "n/a", "n/a");
            }
            engineMap.put(model, engine);
        }

        number = Integer.parseInt(scanner.nextLine());

        while (number-- > 0) {
            String[] carData = scanner.nextLine().split(" ");
            String model = carData[0];
            String engine = carData[1];

            Car car;
            if (carData.length == 4) {
                String weight = carData[2];
                String color = carData[3];
                car = new Car(model, engineMap.get(engine), weight, color);
            } else if (carData.length == 3) {
                if (Character.isDigit(carData[2].charAt(0))) {
                    String weight = carData[2];
                    car = new Car(model, engineMap.get(engine), weight, "n/a");
                } else {
                    String color = carData[2];
                    car = new Car(model, engineMap.get(engine), "n/a", color);
                }
            } else {
                car = new Car(model, engineMap.get(engine), "n/a", "n/a");
            }
            System.out.printf("%s:\n%s:\nPower: %s\nDisplacement: %s\nEfficiency: %s\nWeight: %s\nColor: %s\n",
                    car.getModel(),
                    car.getEngine().getModel(),
                    car.getEngine().getPower(),
                    car.getEngine().getDisplacement(),
                    car.getEngine().getEfficiency(),
                    car.getWeight(),
                    car.getColor());

        }
    }
}
