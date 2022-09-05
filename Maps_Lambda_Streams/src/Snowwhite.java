import java.util.LinkedHashMap;
import java.util.Scanner;

public class Snowwhite {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		LinkedHashMap<String, LinkedHashMap<String, Integer>> order = new LinkedHashMap<>();
		LinkedHashMap<String, Integer> dwarfs = new LinkedHashMap<>();

		while (!input.equals("Once upon a time")) {
			String[] dwarf = input.split("<:>");
			String name = dwarf[0].trim();
			String hatColor = dwarf[1].trim();
			int physics = Integer.parseInt(dwarf[2].trim());

			dwarfs = new LinkedHashMap<>();
			dwarfs.put(name, physics);

			order.putIfAbsent(hatColor, dwarfs);
			if (order.get(hatColor).containsKey(name)) {
				order.get(hatColor).put(name, Math.max(order.get(hatColor).get(name), physics));
			} else {
				order.get(hatColor).put(name, physics);
			}

			input = sc.nextLine();
		}

		order.entrySet().stream().sorted((f, s) -> s.getValue().size() - f.getValue().size()).forEach(x -> {

			x.getValue().entrySet().stream().sorted((fs, se) -> se.getValue() - fs.getValue())
					.forEach(z -> System.out.printf("(%s) %s <-> %d%n", x.getKey(), z.getKey(), z.getValue()));

		});

	}

}
