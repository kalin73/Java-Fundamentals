import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ForceBook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Map<String, List<String>> forceUsers = new LinkedHashMap<>();
		List<String> names = new ArrayList<>();

		while (!"Lumpawaroo".equals(input)) {
			if (input.contains("|")) {
				String[] arr = input.split("\\|");
				String force = arr[0].trim();
				String name = arr[1].trim();
				names = new ArrayList<>();
				names.add(name);
				if (forceUsers.containsKey(force)) {
					boolean contains = false;
					for (String s : forceUsers.keySet()) {
						contains = forceUsers.get(s).contains(name);
						if (contains) {
							break;
						}
					}
					if (!contains) {
						forceUsers.get(force).add(name);
					} else {
						input = sc.nextLine();
						continue;
					}
				}
				forceUsers.putIfAbsent(force, names);

			} else if (input.contains("->")) {
				String[] arr = input.split("->");
				String name = arr[0].trim();
				String force = arr[1].trim();
				names = new ArrayList<>();
				names.add(name);

				boolean contains = false;
				for (String s : forceUsers.keySet()) {
					contains = forceUsers.get(s).contains(name);

					if (contains && forceUsers.containsKey(force)) {
						forceUsers.get(s).remove(name);
						forceUsers.get(force).add(name);
						System.out.printf("%s joins the %s side!%n", name, force);
						break;

					} else if (contains && !forceUsers.containsKey(force)) {
						forceUsers.get(s).remove(name);
						forceUsers.put(force, names);
						System.out.printf("%s joins the %s side!%n", name, force);
						break;
					}
				}
				if (!contains && forceUsers.containsKey(force)) {

					forceUsers.get(force).add(name);
					System.out.printf("%s joins the %s side!%n", name, force);
					input = sc.nextLine();
					continue;

				} else if (!contains && !forceUsers.containsKey(force)) {
					forceUsers.put(force, names);
					System.out.printf("%s joins the %s side!%n", name, force);
				}

			}
			input = sc.nextLine();
		}

		forceUsers.forEach((key, value) -> {
			if (!value.isEmpty()) {
				System.out.printf("Side: %s, Members: %d%n", key, value.size());
				value.forEach(x -> System.out.println("! " + x));
			}
		});
		sc.close();
	}

}
