package Advanced.SetsAndMaps.Exercise;

import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String name = scanner.nextLine();
            if (name.equals("stop")){
                break;
            }
            String email = scanner.nextLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                System.out.printf("%s -> %s\n", name, email);
            }
        }
    }
}
