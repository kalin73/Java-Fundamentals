import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ranking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] contest = sc.nextLine().split(":");

		Map<String, String> contests = new LinkedHashMap<>();
		LinkedHashMap<String, Integer> student = new LinkedHashMap<>();
		TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();
		while (!contest[0].equals("end of contests")) {

			contests.put(contest[0], contest[1]);
			contest = sc.nextLine().split(":");
		}
		String[] arr = sc.nextLine().split("=>");

		while (!arr[0].equals("end of submissions")) {
			if (contests.containsKey(arr[0]) && contests.containsValue(arr[1])) {

				student = new LinkedHashMap<>();
				student.put(arr[0], Integer.parseInt(arr[3]));
				if (!map.containsKey(arr[2])) {

					map.put(arr[2], student);

				} else {
					if (!map.get(arr[2]).containsKey(arr[0])) {
						map.get(arr[2]).put(arr[0], Integer.parseInt(arr[3]));
					} else {
						map.get(arr[2]).put(arr[0], Math.max(Integer.parseInt(arr[3]), map.get(arr[2]).get(arr[0])));
					}
				}

			}
			arr = sc.nextLine().split("=>");
		}
		int total = 0;

		for (Map.Entry<String, LinkedHashMap<String, Integer>> user : map.entrySet()) {
			int sum = user.getValue().values().stream().mapToInt(i ->i).sum();
			if (sum > total) {
				total = sum;
			}

		}

		for (Map.Entry<String, LinkedHashMap<String, Integer>> user : map.entrySet()) {

			if (user.getValue().values().stream().mapToInt(i -> i).sum() == total) {
				System.out.printf("Best candidate is %s with total %d points.%n", user.getKey(), total);
			}

		}

		System.out.println("Ranking: ");
		map.forEach((key, value) -> {
			System.out.printf("%s%n", key);
			value.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue())
					.forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
		});
		
		sc.close();
	}

}
