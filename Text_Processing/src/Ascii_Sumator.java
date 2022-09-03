import java.util.Scanner;

public class Ascii_Sumator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char char1 = sc.nextLine().charAt(0);
		char char2 = sc.nextLine().charAt(0);
		String str = sc.nextLine();
		int ascii1 = char1;
		int ascii2 = char2;
		int sum = 0;
		int currChar = 0;

		for (int i = 0; i < str.length(); i++) {
			if (ascii1 < str.charAt(i) && ascii2 > str.charAt(i)) {

				currChar = str.charAt(i);
				sum += currChar;

			}
		}
		System.out.println(sum);
		sc.close();
	}

}
