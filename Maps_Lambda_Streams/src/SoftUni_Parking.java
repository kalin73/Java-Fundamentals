import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUni_Parking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Map<String, String> parking = new LinkedHashMap<>();
		for (int i = 0; i < n; i++) {
			String[] reg = sc.nextLine().split(" ");

			if (reg[0].equals("register") && parking.containsKey(reg[1])) {
				System.out.println("ERROR: already registered with plate number " + reg[2]);

			} else if (reg[0].equals("register") && !parking.containsKey(reg[1])) {
				parking.put(reg[1], reg[2]);
				System.out.printf("%s registered %s successfully\n", reg[1], reg[2]);

			} else if (reg[0].equals("unregister") && !parking.containsKey(reg[1])) {
				System.out.printf("ERROR: user %s not found\n", reg[1]);
			} else {
				System.out.printf("%s unregistered successfully\n", reg[1]);
				parking.remove(reg[1]);
			}

		}

		for (String s : parking.keySet()) {

			System.out.printf("%s => %s\n", s, parking.get(s));

		}
		sc.close();

	}

}
