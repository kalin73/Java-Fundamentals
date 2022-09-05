import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
//NOT FINISHED!!!!
public class Judge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] arr = sc.nextLine().split("->");
		LinkedHashMap<String, LinkedHashMap<String, Integer>> map = new LinkedHashMap<>();

		while (!arr[0].equals("no more time")) {
			String username = arr[0].trim();
			String contest = arr[1].trim();
			Integer points = Integer.parseInt(arr[2].trim());

			LinkedHashMap<String, Integer> map2 = new LinkedHashMap<>();
			map2.put(username, points);

			map.putIfAbsent(contest, map2);
			map.get(contest).putIfAbsent(username, points);
			map.get(contest).put(username, Math.max(map2.get(username), points));

			arr = sc.nextLine().split("->");
		}

		map.forEach((key, value) -> {
			System.out.printf("%s: %d participants%n", key, value.size());
			AtomicInteger counter = new AtomicInteger();
			counter.set(1);

			value.entrySet().stream()

					.sorted((fst, sec) -> {
						int sort = Integer.compare(sec.getValue(), fst.getValue());
						if (sort == 0) {
							sort = fst.getKey().compareTo(sec.getKey());

						}
						return sort;
					}).forEach(i -> {
						System.out.printf("%d. %s <::> %d%n", counter.getAndIncrement(), i.getKey(), i.getValue());
					});

		});
		LinkedHashMap<String, Integer> standings = new LinkedHashMap<>();

		map.forEach((key, value) -> {
			value.forEach((key2, value2) -> {
				if (!standings.containsKey(key2)) {
					standings.put(key2, value2);
				} else {
					standings.put(key2, standings.get(key2) + value2);
				}

			});
		});
		AtomicInteger counter = new AtomicInteger();
		counter.set(1);
		System.out.println("Individual standings:");
		standings.entrySet().stream().sorted((f, s) -> {
			int sort = Integer.compare(s.getValue(), f.getValue());
			if (sort == 0) {
				sort = f.getKey().compareTo(s.getKey());
			}
			return sort;

		}).forEach(i -> {
			System.out.printf("%d. %s -> %d%n", counter.getAndIncrement(), i.getKey(), i.getValue());
		});

	}

}
