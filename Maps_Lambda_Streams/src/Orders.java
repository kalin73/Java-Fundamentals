import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] products = sc.nextLine().split(" ");
		Map<String, Double> prices = new LinkedHashMap<>();
		Map<String, Integer> quant = new LinkedHashMap<>();
		Double result = 0.0;
		while (!products[0].equals("buy")) {

			if (prices.containsKey(products[0])) {

				prices.put(products[0], Double.parseDouble(products[1]));
				quant.put(products[0], quant.get(products[0]) + Integer.parseInt(products[2]));
			} else {
				prices.put(products[0], Double.parseDouble(products[1]));
				quant.put(products[0], Integer.parseInt(products[2]));
			}
			products = sc.nextLine().split(" ");
		}
		for (String s : prices.keySet()) {
			Double prc = prices.get(s);
			Integer quan = quant.get(s);
			result = prc * quan;
			System.out.printf("%s -> %.2f\n", s, result);
		}
		sc.close();
	}

}
