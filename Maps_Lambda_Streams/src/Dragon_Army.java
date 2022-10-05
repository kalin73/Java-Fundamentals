
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Dragon_Army {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		LinkedHashMap<String, TreeMap<String, List<Stats>>> types = new LinkedHashMap<>();

		for (int i = 0; i < n; i++) {
			String[] input = sc.nextLine().split(" ");
			String type = input[0];
			String name = input[1];
			int damage = 0;
			int health = 0;
			int armor = 0;

			if (input[2].equals("null")) {
				damage = 45;
			} else {
				damage = Integer.parseInt(input[2]);
			}

			if (input[3].equals("null")) {
				health = 250;
			} else {
				health = Integer.parseInt(input[3]);
			}

			if (input[4].equals("null")) {
				armor = 10;
			} else {
				armor = Integer.parseInt(input[4]);
			}
			addData(types, type, name, damage, health, armor);
		}
		print(types);
		sc.close();

	}

	public static void addData(LinkedHashMap<String, TreeMap<String, List<Stats>>> types, String type, String name,
			int damage, int health, int armor) {

		TreeMap<String, List<Stats>> names = new TreeMap<>();
		List<Stats> stats = new ArrayList<>();

		if (!types.containsKey(type)) {
			stats = new ArrayList<>();
			stats.add(new Stats(damage, health, armor));
			names = new TreeMap<>();
			names.put(name, stats);
			types.put(type, names);
			return;

		} else if (!types.get(type).containsKey(name)) {
			stats = new ArrayList<>();
			stats.add(new Stats(damage, health, armor));

			names = types.get(type);
			names.put(name, stats);
			types.put(type, names);
			return;

		}
		stats = types.get(type).get(name);
		stats.clear();
		stats.add(new Stats(damage, health, armor));

		names = types.get(type);
		names.put(name, stats);

		types.put(type, names);

	}

	public static void print(LinkedHashMap<String, TreeMap<String, List<Stats>>> types) {

		for (String s : types.keySet()) {
			double avgD = 0;
			double avgH = 0;
			double avgA = 0;
			int count = 0;

			for (String st : types.get(s).keySet()) {

				avgD += types.get(s).get(st).stream().map(x -> x.getDamage()).mapToDouble(x -> x).findFirst()
						.getAsDouble();

				avgH += types.get(s).get(st).stream().map(x -> x.getHealth()).mapToDouble(x -> x).findFirst()
						.getAsDouble();

				avgA += types.get(s).get(st).stream().map(x -> x.getArmor()).mapToDouble(x -> x).findFirst()
						.getAsDouble();

				count++;
			}
			System.out.printf("%s::(%.2f/%.2f/%.2f)%n", s, avgD / count, avgH / count, avgA / count);

			for (String st : types.get(s).keySet()) {

				types.get(s).get(st).stream()
						.forEach(x -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", st, x.getDamage(),
								x.getHealth(), x.getArmor()));
			}
		}
	}

}

class Stats {
	private int damage = 0;
	private int health = 0;
	private int armor = 0;

	public Stats(int damage, int health, int armor) {
		this.damage = damage;
		this.health = health;
		this.armor = armor;
	}

	public Stats() {

	}

	public int getDamage() {
		return damage;
	}

	public int getHealth() {
		return health;
	}

	public int getArmor() {
		return armor;
	}
}