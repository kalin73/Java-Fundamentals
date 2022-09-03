import java.util.Scanner;

public class Text_Filter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] banned_words = sc.nextLine().split(", ");
		String text = sc.nextLine();
		for (int i = 0; i < banned_words.length; i++) {
			String word = banned_words[i];
			int length = word.length();
			while (text.contains(word)) {
				text = text.replace(word, asterix(length));
			}
		}
		System.out.println(text);
		sc.close();
	}

	public static StringBuilder asterix(int length) {
		StringBuilder symbols = new StringBuilder("");
		for (int i = 0; i < length; i++) {
			symbols.append("*");
		}
		return symbols;
	}

}
