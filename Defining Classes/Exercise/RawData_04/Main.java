package Advanced.DefiningClasses.Exercise.RawData_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Map<String, List<Car>> cars = new LinkedHashMap<>();

        cars.put("fragile", new ArrayList<>());
        cars.put("flamable", new ArrayList<>());

        while (number-- > 0) {
            String[] data = scanner.nextLine().split(" ");
//"{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType}
// {Tire1Pressure} {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire3Age} {Tire4Pressure} {Tire4Age}"

            String model = data[0];
            Engine engine = new Engine(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            Cargo cargo = new Cargo(Integer.parseInt(data[3]), data[4]);
            Tire[] tires = new Tire[]{new Tire(Double.parseDouble(data[5]), Integer.parseInt(data[6])),
                    new Tire(Double.parseDouble(data[7]), Integer.parseInt(data[8])),
                    new Tire(Double.parseDouble(data[9]), Integer.parseInt(data[10])),
                    new Tire(Double.parseDouble(data[11]), Integer.parseInt(data[12]))};

            Car car = new Car(model, engine, cargo, tires);

            cars.get(data[4]).add(car);
        }
        String cargoType = scanner.nextLine();
        if (cargoType.equals("fragile")) {

            cars.values().stream().flatMap(List::stream)
                    .filter(c -> Arrays.stream(c.getTires()).anyMatch(t -> t.getPressure() < 1))
                    .forEach(c -> System.out.println(c.getModel()));
        } else if (cargoType.equals("flamable")) {
            cars.values().stream().flatMap(List::stream)
                    .filter(c -> c.getEngine().getPower() > 250)
                    .forEach(c -> System.out.println(c.getModel()));
        }
    }
}
