package Advanced.DefiningClasses.Exercise.CompanyRoster_02;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> employees = new HashMap<>();

        while (number-- > 0) {
            String[] employeeData = scanner.nextLine().split(" ");
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];

            employees.putIfAbsent(department, new ArrayList<>());
            employees.get(department).add(new Employee(name, salary, position, department));

            if (employeeData.length == 6) {
                String email = employeeData[4];
                int age = Integer.parseInt(employeeData[5]);
                int idx = employees.get(department).size() - 1;
                employees.get(department).get(idx).setEmail(email);
                employees.get(department).get(idx).setAge(age);
            } else if (employeeData.length==5){
                if (Character.isDigit(employeeData[4].charAt(0))){
                    int age = Integer.parseInt(employeeData[4]);
                    int idx = employees.get(department).size() - 1;
                    employees.get(department).get(idx).setAge(age);
                } else {
                    String email = employeeData[4];
                    int idx = employees.get(department).size() - 1;
                    employees.get(department).get(idx).setEmail(email);
                }
            }

        }

        //his name, salary, email, and age - sorted by salary in descending order

        Map.Entry<String, List<Employee>> highestDept = employees.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, List<Employee>> e) -> e.getValue().stream().mapToDouble(Employee::getSalary).sum()).reversed())
                .collect(Collectors.toList()).get(0);

        System.out.printf("Highest Average Salary: %s\n", highestDept.getKey());
        highestDept.getValue().stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(e-> System.out.printf("%s %.2f %s %d\n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
    }
}
