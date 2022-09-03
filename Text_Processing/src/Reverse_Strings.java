import java.util.Scanner;

public class Reverse_Strings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder reversedWord = new StringBuilder("");
		StringBuilder sb = new StringBuilder(sc.nextLine());
		
		while (!"end".equals(String.valueOf(sb))) {
			int size = sb.length() - 1;
			for (int i = size; i >= 0; i--) {
				reversedWord.append(sb.charAt(i));
			}
			System.out.println(sb + " = " + reversedWord);
			sb = new StringBuilder(sc.nextLine());
			reversedWord = new StringBuilder("");
		}
		sc.close();
	}

}
