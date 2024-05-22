package Advanced.SetsAndMaps.Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        while (true){
            String[] input = scanner.nextLine().split("-");
            if (input[0].equals("search")){
                break;
            }
            phonebook.put(input[0], input[1]);
        }

        while (true){
            String name = scanner.nextLine();
            if (name.equals("stop"))
                break;

            if (phonebook.containsKey(name)){
                System.out.println(name + " -> " + phonebook.get(name));
            }else {
                System.out.printf("Contact %s does not exist.\n", name);
            }
        }
    }
}
