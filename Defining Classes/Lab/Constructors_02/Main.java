package Advanced.DefiningClasses.Lab.Constructors_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        while (n-->0){
            String[] data = scanner.nextLine().split(" ");

            Car car = new Car(data[0], "unknown", -1);
            if (data.length==2){
                if (Character.isDigit(data[1].charAt(0))){
                    car.setHorsepower(Integer.parseInt(data[1]));
                } else {
                    car.setModel(data[1]);
                }
            } else if (data.length==3){
                car.setModel(data[1]);
                car.setHorsepower(Integer.parseInt(data[2]));
            }
            cars.add(car);
        }
        cars.forEach(Car::carInfo);

    }
}
