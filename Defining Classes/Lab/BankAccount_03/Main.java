package Advanced.DefiningClasses.Lab.BankAccount_03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> person = new HashMap<>();

        //•	Create
        //•	Deposit {ID} {Amount}
        //•	SetInterest {Interest}
        //•	GetInterest {ID} {Years}
        //•	End

        while (true) {
            String input = scanner.nextLine();

            String command = input.split(" ")[0];
            if (command.equals("Create")) {
                BankAccount account = new BankAccount();
                person.put(account.getId(), account);
                System.out.println("Account ID" + account.getId() + " created");
            } else if (command.equals("Deposit")) {
                int amount = Integer.parseInt((input.split(" ")[2]));
                int id = Integer.parseInt(input.split(" ")[1]);
                if (!isExist(person, id)){
                    System.out.println("Account does not exist");
                    continue;
                }
                BankAccount account = person.get(id);
                account.deposit(amount);
                System.out.printf("Deposited %s to ID%s\n", amount, id);
            } else if (command.equals("SetInterest")) {
               BankAccount.setInterestRate(Double.parseDouble(input.split(" ")[1]));
            } else if (command.equals("GetInterest")) {
                int id = Integer.parseInt(input.split(" ")[1]);
                int years = Integer.parseInt(input.split(" ")[2]);
                if (!isExist(person, id)){
                    System.out.println("Account does not exist");
                    continue;
                }
                BankAccount account = person.get(id);
                System.out.printf("%.2f\n", account.getInterest(years));
            } else {
                break;
            }
        }
    }
    public static boolean isExist(Map<Integer, BankAccount> person, int id){
        return person.containsKey(id);
    }
}
