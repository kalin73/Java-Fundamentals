import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		final String regex = ">>(?<name>[A-Za-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;

		System.out.println("Bought furniture:");
		double total = 0.0;

		while (!"Purchase".equals(input)) {
			matcher = pattern.matcher(input);

			if (matcher.find()) {
				System.out.println(matcher.group("name"));

				double price = Double.parseDouble(matcher.group("price"));
				int quantity = Integer.parseInt(matcher.group("quantity"));

				total += price * quantity;
			}

			input = sc.nextLine();
		}

		System.out.printf("Total money spend: %.2f", total);

		sc.close();
	}

}
