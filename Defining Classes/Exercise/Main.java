package Advanced.DefiningClasses.Exercise.OpinionPoll_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();

        while (number-- > 0) {
            String[] input = scanner.nextLine().split(" ");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            persons.add(person);
        }
        persons.stream()
                .filter(person -> person.getAge()>30).sorted(Comparator.comparing(Person::getName))
                .forEach(e-> System.out.printf("%s - %s\n", e.getName(), e.getAge()));

    }
}
