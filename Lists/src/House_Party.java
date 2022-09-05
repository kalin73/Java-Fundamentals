import java.util.ArrayList;

import java.util.Scanner;

public class House_Party {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int index = 0;
		String name;
		ArrayList<String> names = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String word = sc.nextLine();
			if (word.contains("is not")) {
				index = word.indexOf("is not");
				name = word.substring(0, index - 1);
				if (names.contains(name)) {
					names.remove(name);
				} else {
					System.out.printf("%s is not in the list!\n", name);
				}
			} else if (word.contains("is going")) {

				index = word.indexOf("is going");
				name = word.substring(0, index - 1);
				if (names.contains(name)) {
					System.out.printf("%s is already in the list!\n", name);
				} else {
					names.add(name);
				}

			}

		}
		for(String s:names) {
			System.out.println(s);
		}
		sc.close();
	}

}
