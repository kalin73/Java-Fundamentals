import java.util.Scanner;

public class Replace_Repeating_Chars {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder str = new StringBuilder(sc.nextLine());

		int firstIndex = 0;
		int lastIndex = 0;

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				firstIndex = i;
				for (int k = i; k < str.length() - 1; k++) {

					if (str.charAt(k) == str.charAt(k + 1)) {
						lastIndex = k + 1;
						continue;
					}
					lastIndex = k;
					break;
				}
				str = str.replace(firstIndex, lastIndex + 1, String.valueOf(str.charAt(i)));
				i = firstIndex;

			}
		}
		System.out.println(str);
		sc.close();
	}

}
