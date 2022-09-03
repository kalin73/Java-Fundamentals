import java.util.Scanner;

public class Character_Multiplier {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int sum = 0;
		String[] usernames = sc.nextLine().split(" ");
		int length1 = usernames[0].length();
		int length2 = usernames[1].length();

		if (length1 >= length2) {
			for (int i = 0; i < length1; i++) {
				if (i >= length2) {
					int charV = usernames[0].charAt(i);
					sum += charV;
					continue;
				}
				int charValue1 = usernames[0].charAt(i);
				int charValue2 = usernames[1].charAt(i);
				sum += charValue1 * charValue2;
			}
		} else {

			for (int i = 0; i < length2; i++) {
				if (i >= length1) {
					int charV = usernames[1].charAt(i);
					sum += charV;
					continue;
				}
				int charValue1 = usernames[0].charAt(i);
				int charValue2 = usernames[1].charAt(i);
				sum += charValue1 * charValue2;
			}

		}
		System.out.println(sum);
		sc.close();
	}

}
