package Advanced.SetsAndMaps.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopsData = new TreeMap<>();

        while (true){
            String[] input = scanner.nextLine().split(", ");
            if (input[0].equals("Revision")){
                break;
            }
            String shopName = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);
            shopsData.putIfAbsent(shopName, new LinkedHashMap<>());
            shopsData.get(shopName).put(product, price);
        }

        shopsData.forEach((key1, value1) -> {
            System.out.printf("%s->\n", key1);
            value1.forEach((key, value) -> System.out.printf("Product: %s, Price: %.1f\n", key, value));
        });

    }
}
