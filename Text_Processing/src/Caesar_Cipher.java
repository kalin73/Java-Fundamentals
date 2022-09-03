import java.util.Scanner;

public class Caesar_Cipher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder str = new StringBuilder(sc.nextLine());
		for (int i = 0; i < str.length(); i++) {
			int value = str.charAt(i);
			char cipher = (char) (value + 3);
			String word = String.valueOf(cipher);
			str = str.replace(i, i + 1, word);
		}
		System.out.println(str);
		sc.close();
	}

}
