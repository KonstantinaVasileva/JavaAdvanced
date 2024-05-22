package Advanced.SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class UserLogs_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> messenger = new TreeMap<>();

        while (true){
            String[] dataForMessenger = scanner.nextLine().split(" ");
            if (dataForMessenger[0].equals("end")){
                break;
            }
            int index = dataForMessenger[2].indexOf("=");
            String user = dataForMessenger[2].substring(index + 1);
            messenger.putIfAbsent(user, new LinkedHashMap<>());
            Map<String, Integer> ipCounter;
            ipCounter = messenger.get(user);
            index = dataForMessenger[0].indexOf("=");
            String ip = dataForMessenger[0].substring(index + 1);
            ipCounter.putIfAbsent(ip, 0);
            ipCounter.put(ip, ipCounter.get(ip) + 1);
            messenger.put(user, ipCounter);
        }

        messenger.forEach((key, value)->{
            System.out.printf("%s: \n", key);
            String output = value.entrySet().stream()
                    .map(entry -> entry.getKey() + " => " + entry.getValue())
                    .collect(Collectors.joining(", "));
            System.out.println(output + ".");
        });

    }
}
