import java.util.*;
import java.util.stream.Collectors;

public class Messaging {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<String> numbers = (ArrayList<String>) Arrays.stream(sc.nextLine().split(" "))
				.collect(Collectors.toList());
		String words = sc.nextLine();
		int wordsLength = words.length();
		int sum = 0;
		String number;
		String result = "";

		for (int i = 0; i < numbers.size(); i++) {
			number = numbers.get(i);
			sum = 0;
			for (int k = 0; k < number.length(); k++) {
				sum += Character.getNumericValue(number.charAt(k));
			}
			while (sum > wordsLength) {

				sum -= wordsLength;

			}
			result += "" + words.charAt(sum);
			words = words.substring(0, sum) + words.substring(sum + 1);
		}
		System.out.println(result);
		sc.close();
	}
}
