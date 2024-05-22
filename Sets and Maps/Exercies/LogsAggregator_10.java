package Advanced.SetsAndMaps.Exercise;

import java.util.*;

public class LogsAggregator_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number  = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> usersTotalTime = new TreeMap<>();
        Map<String, Set<String>> usersIp = new TreeMap<>();

        for (int i = 0; i < number; i++) {
            String[] input = scanner.nextLine().split(" ");
            String ip = input[0];
            String username = input[1];
            int time = Integer.parseInt(input[2]);

            usersTotalTime.putIfAbsent(username, 0);
            usersTotalTime.put(username, usersTotalTime.get(username) + time);

            usersIp.putIfAbsent(username, new TreeSet<>());
             usersIp.get(username).add(ip);

        }

        // Order the users alphabetically. Order the IPs alphabetically

        usersTotalTime.forEach((key, value) ->
        System.out.printf("%s: %s %s%n", key, value, usersIp.get(key).toString())
);

    }
}
