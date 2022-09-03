import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Odd_Occurrences {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String result = "";
		String[] words = sc.nextLine().split(" ");
		Map<String, Integer> mp = new LinkedHashMap<>();

		for (int i = 0; i < words.length; i++) {
			Integer curCount = mp.get(words[i].toLowerCase());
			if (curCount != null) {
				mp.put(words[i].toLowerCase(), curCount + 1);
			} else {
				mp.put(words[i].toLowerCase(), 1);
			}
		}

		for (String i : mp.keySet()) {
			if (mp.get(i) % 2 != 0) {
				result += i.toLowerCase() + ", ";
			}

		}
		result = result.substring(0, result.lastIndexOf(","));
		System.out.println(result);
		sc.close();
	}

}
