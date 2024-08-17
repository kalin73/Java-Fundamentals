import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		final String regex = "_\\.+(?<pass>[A-Z][A-Za-z0-9]{4,}[A-Z])_\\.+";
		final String regex2 = "\\d+";

		Pattern pattern = null;
		Matcher matcher = null;
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(input);

			if (matcher.find()) {
				result.append("Group: ");
				pattern = Pattern.compile(regex2);
				matcher = pattern.matcher(matcher.group("pass"));

				if (!matcher.find()) {
					result.append("default");
				}

				matcher.reset();

				while (matcher.find()) {
					result.append(matcher.group());
					
				}

			} else {
				result.append("Invalid pass!");
				
			}

			result.append(System.lineSeparator());
		}
		System.out.println(result);

		sc.close();
	}

}
