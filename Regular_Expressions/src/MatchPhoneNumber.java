import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		String regex = "\\+359([- ])2\\1[\\d]{3}\\1[\\d]{4}\\b";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		
		List<String> phoneNumbers = new ArrayList<>();

		while (matcher.find()) {
			phoneNumbers.add(matcher.group());
		}
		
		System.out.println(String.join(", ", phoneNumbers));
		sc.close();

	}

}
