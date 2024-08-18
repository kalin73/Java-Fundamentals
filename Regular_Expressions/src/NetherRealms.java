import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final String[] names = sc.nextLine().split(",\\s*");

		for (int i = 0; i < names.length; i++) {
			final String name = names[i];
			int hp = getHp(name);
			double dmg = getDmg(name);

			dmg = alterDmg(name, dmg);

			System.out.printf("%s - %d health, %.2f damage", name, hp, dmg);
		}

		sc.close();
	}

	private static int getHp(String name) {
		final String regex = "[^-\\+\\*/0-9\\.]";
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(name);
		final StringBuilder sb = new StringBuilder();
		int hp = 0;

		while (matcher.find()) {
			sb.append(matcher.group());
		}

		for (char c : sb.toString().toCharArray()) {
			hp += c;
		}

		return hp;
	}

	private static double getDmg(String name) {
		final String regex = "\\-?\\d+\\.?\\d*";
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(name);
		double dmg = 0.0;

		while (matcher.find()) {
			dmg += Double.parseDouble(matcher.group());
		}

		return dmg;
	}

	private static double alterDmg(String name, double dmg) {
		final String regex = "[*/]";
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(name);

		while (matcher.find()) {
			final String symbol = matcher.group();

			dmg = switch (symbol) {
				case "*" -> dmg * 2;
				default -> dmg / 2;
			};
		}
		
		return dmg;
	}

}
