import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Company_Users {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] users = sc.nextLine().split("->");
		String[] names;
		Map<String, String> company = new LinkedHashMap<>();
		while (!users[0].equals("End")) {
			if (company.containsKey(users[0]) && !company.get(users[0]).contains(users[1])) {
				company.put(users[0], company.get(users[0]) + ":" + users[1]);
				users = sc.nextLine().split("->");
				continue;
			} else if (!company.containsKey(users[0])) {
				company.put(users[0], users[1]);
				users = sc.nextLine().split("->");
				continue;
			}

			users = sc.nextLine().split("->");

		}
		for (String s : company.keySet()) {
			names = company.get(s).split(":");
			System.out.println(s.trim());
			for (String st : names) {
				System.out.println("--" + st);
			}
		}
		sc.close();

	}

}
