package Advanced.DefiningClasses.Exercise.Google_07;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new HashMap<>();

        while (true) {
            String[] data = scanner.nextLine().split(" ");
            if (data[0].equals("End")) {
                break;
            }
            String name = data[0];
            people.putIfAbsent(name, new Person(name));
            String clazz = data[1];
            switch (clazz) {
                case "company" -> {
                    Company company = new Company(data[2], data[3], Double.parseDouble(data[4]));
                    people.get(name).setCompany(company);
                }
                case "pokemon" -> {
                    Pokemon pokemon = new Pokemon(data[2], data[3]);
                    if (people.get(name).getPokemons() == null) {
                        people.get(name).setPokemons(new ArrayList<>());
                    }
                    people.get(name).getPokemons().add(pokemon);
                }
                case "parents" -> {
                    Parents parents = new Parents(data[2], data[3]);
                    if (people.get(name).getParents() == null) {
                        people.get(name).setParents(new ArrayList<>());
                    }
                    people.get(name).getParents().add(parents);
                }
                case "children" -> {
                    Children children = new Children(data[2], data[3]);
                    if (people.get(name).getChildren() == null) {
                        people.get(name).setChildren(new ArrayList<>());
                    }
                    people.get(name).getChildren().add(children);
                }
                default -> {
                    Car car = new Car(data[2], Integer.parseInt(data[3]));
                    people.get(name).setCar(car);
                }
            }
        }
        String name = scanner.nextLine();
        Person person = people.get(name);

        System.out.println(person);
    }
}
