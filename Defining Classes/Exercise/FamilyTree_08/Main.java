package Advanced.DefiningClasses.Exercise.FamilyTree_08;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String namePerson = scanner.nextLine();
        Map<String, List<String>> parentsWithChildren = new LinkedHashMap<>();
        List<Person> personList = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }

            if (input.contains("-")) {
                String parentsData = input.split(" - ")[0];
                String childData = input.split(" - ")[1];
                parentsWithChildren.putIfAbsent(parentsData, new ArrayList<>());
                parentsWithChildren.get(parentsData).add(childData);
//                if (Character.isDigit(parentsData.charAt(0))) {
//                    parent.setBirthday(parentsData);
//                } else {
//                    parent.setName(parentsData);
//                }
//                if (Character.isDigit(childData.charAt(0))) {
//                    child.setBirthday(childData);
//                } else {
//                    child.setName(childData);
//                }
//                parent.setChild(child);
//                personList.add(parent);

            } else {
                String name = input.split(" ")[0] + input.split(" ")[1];
                String birthday = input.split(" ")[2];
                Person person = new Person();
                person.setName(name);
                person.setBirthday(birthday);
                personList.add(person);
            }
        }
        String output = "";
        Map<Person, List<Person>> personListMap = new HashMap<>();
        Person thatPerson = new Person();
        for (String entry : parentsWithChildren.keySet()) {
            for (Person person : personList) {
                if (person.getName().equals(entry) || person.getBirthday().equals(entry)) {
                    personListMap.putIfAbsent(person, new ArrayList<>());
                    Person child = new Person();
                    for (String children : parentsWithChildren.get(entry)) {
                        if (Character.isDigit(children.charAt(0))) {
                            child.setBirthday(children);
                        } else {
                            child.setName(children);
                        }
                    }
                    personListMap.get(person).add(child);
                }
            }
        }


        System.out.println();

    }

}
