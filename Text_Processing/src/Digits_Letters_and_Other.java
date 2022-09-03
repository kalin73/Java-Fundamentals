import java.util.Scanner;

public class Digits_Letters_and_Other {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		String digits = "";
		String letters = "";
		String symbols = "";
		for (int i = 0; i < text.length(); i++) {
			char letter = text.charAt(i);
			if (Character.isDigit(letter)) {
				digits += letter;

			} else if (Character.isLetter(letter)) {
				letters += letter;

			} else if (!Character.isDigit(letter) && !Character.isLetter(letter)) {
				symbols += letter;
			}
		}
		System.out.println(digits + "\n" + letters + "\n" + symbols);
		sc.close();
	}

}
