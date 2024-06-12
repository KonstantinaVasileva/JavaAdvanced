package Advanced.DefiningClasses.Lab.CarInfo_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            Car car = new Car();
            car.setBrand(data[0]);
            car.setModel(data[1]);
            car.setHorsepower(Integer.parseInt(data[2]));
            cars.add(car);
        }

        cars.stream().forEach(car -> {
            car.carInfo();
            System.out.println();
        });

    }
}
