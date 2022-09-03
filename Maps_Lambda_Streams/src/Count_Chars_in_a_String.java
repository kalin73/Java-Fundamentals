import java.util.LinkedHashMap;
import java.util.Scanner;

public class Count_Chars_in_a_String {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String words = sc.nextLine();
		LinkedHashMap<Character, Integer> count = new LinkedHashMap<>();
		for (int i = 0; i < words.length(); i++) {
			if (words.charAt(i) != ' ') {
				Character ch = words.charAt(i);

				if (count.get(ch) == null) {

					count.put(ch, 1);

				} else {
					count.put(ch, count.get(ch) + 1);
				}

			}
		}
		for (Character c : count.keySet()) {

			System.out.println(c + " -> " + count.get(c));

		}
		sc.close();
	}

}
