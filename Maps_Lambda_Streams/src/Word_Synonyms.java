import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import java.util.Scanner;

public class Word_Synonyms {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		LinkedHashMap<String, List<String>> synonyms = new LinkedHashMap<>();
		String word = "";
		String synonym = "";
		for (int i = 0; i < n; i++) {

			word = sc.nextLine();
			synonym = sc.nextLine();

			List<String> syn = synonyms.get(word);

			if (syn == null) {
				syn = new ArrayList<>();
				synonyms.put(word, syn);
			}

			syn.add(synonym);

		}

		for (Map.Entry<String, List<String>> en : synonyms.entrySet()) {
			String print = String.format("%s - %s", en.getKey(), en.getValue());
			print = print.replace("[", "");
			print = print.replace("]", "");
			System.out.print(print);
			System.out.println();

		}
		sc.close();
	}

}
