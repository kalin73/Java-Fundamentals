import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		final String regex = "%(?<user>[A-Z][a-z]+)%[A-Za-z]*<(?<product>[A-Za-z]+)>[A-Za-z]*\\|(?<count>\\d+)\\|[A-Za-z]*(?<price>\\d+\\.?\\d*)\\$";

		final Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;

		double total = 0.0;

		while (!"end of shift".equals(input)) {
			matcher = pattern.matcher(input);

			if (matcher.find()) {
				final String name = matcher.group("user");
				final String product = matcher.group("product");
				final int count = Integer.parseInt(matcher.group("count"));
				final double sum = Double.parseDouble(matcher.group("price")) * count;
				System.out.printf("%s: %s - %.2f%n", name, product, sum);
				total += sum;
			}

			input = sc.nextLine();
		}

		System.out.printf("Total income: %.2f", total);

		sc.close();

	}

}
