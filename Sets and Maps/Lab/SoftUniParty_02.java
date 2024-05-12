package Advanced.SetsAndMaps.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guest = new TreeSet<>();

        while (true){
            String input = scanner.nextLine();
            if (input.equals("PARTY")){
                break;
            }
            guest.add(input);
        }
        while (true){
            String input = scanner.nextLine();
            if (input.equals("END")){
                break;
            }
            guest.remove(input);
        }
        System.out.println(guest.size());
        for (String g : guest) {
            System.out.println(g);
        }
    }
}
