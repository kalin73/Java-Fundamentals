import java.util.Scanner;

public class Multiply_Big_Number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String numbers = sc.nextLine();
		int multiplier = Integer.parseInt(sc.nextLine());
		String result = "";
		int multi = 0;
		int firstDigit = 0;
		int lastDigit = 0;
		int combo = 0;
		int number = 0;
		int n = numbers.length() - 1;
		for (int i = n; i >= 0; i--) {
			if (i == 0) {
				multi = number * multiplier;

				result = String.valueOf(multi + firstDigit) + result;
				break;
			}
			number = Character.getNumericValue(numbers.charAt(i));
			multi = number * multiplier;

			if (String.valueOf(multi).length() > 1) {
				lastDigit = multi % 10;
				combo = lastDigit + firstDigit;
				if (combo > 9) {

					lastDigit = combo % 10;
					result = String.valueOf(lastDigit + firstDigit) + result;
					firstDigit = combo / 10;
					continue;
				}
				result = String.valueOf(lastDigit + firstDigit) + result;
				firstDigit = multi / 10;

			} else {
				combo = multi + firstDigit;
				if (combo > 9) {
					lastDigit = combo % 10;
					result = String.valueOf(lastDigit + firstDigit) + result;
					firstDigit = combo / 10;
					continue;
				}
				result = String.valueOf(multi + firstDigit) + result;
				firstDigit = 0;
			}

		}
		System.out.println(result);

		sc.close();
	}

}
