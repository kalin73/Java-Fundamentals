import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MOBA_Challenger {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Map<String, TreeMap<String, Integer>> players = new TreeMap<>();
		TreeMap<String, Integer> skills = new TreeMap<>();

		while (!s.contains("Season end")) {

			if (s.contains("->")) {

				String[] arr = s.split("->");
				String name = arr[0].trim();
				String position = arr[1].trim();
				int points = Integer.parseInt(arr[2].trim());

				skills = new TreeMap<>();
				skills.put(position, points);
				players.putIfAbsent(name, skills);
				players.get(name).putIfAbsent(position, points);
				if (players.get(name).containsKey(position)) {
					players.get(name).put(position, Math.max(players.get(name).get(position), points));
				}

			} else if (s.contains("vs")) {
				String[] arr = s.split("vs");
				String name1 = arr[0].trim();
				String name2 = arr[1].trim();

				if (players.containsKey(name1) && players.containsKey(name2)) {
					String positions1 = players.get(name1).keySet().toString();
					System.out.println(positions1);

				}

			}
			 s = sc.nextLine();
		}

	}
}
