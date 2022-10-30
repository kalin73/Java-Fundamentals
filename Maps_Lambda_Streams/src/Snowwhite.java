import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		LinkedHashMap<String, LinkedHashMap<String, Integer>> hats = new LinkedHashMap<>();
		LinkedHashMap<String, Integer> dwarfs = new LinkedHashMap<>();
		String[] dwarf = input.split("<:>");

		while (!input.equals("Once upon a time")) {
			dwarf = input.split("<:>");
			String name = dwarf[0].trim();
			String hatColor = dwarf[1].trim();
			int physics = Integer.parseInt(dwarf[2].trim());

			if (!hats.containsKey(hatColor)) {
				dwarfs = new LinkedHashMap<>();
				dwarfs.put(name, physics);
				hats.put(hatColor, dwarfs);
				input = sc.nextLine();
				continue;

			} else if (hats.get(hatColor).containsKey(name)) {
				dwarfs = hats.get(hatColor);
				dwarfs.put(name, Math.max(dwarfs.get(name), physics));
				hats.put(hatColor, dwarfs);
				input = sc.nextLine();
				continue;

			}
			dwarfs = hats.get(hatColor);
			dwarfs.put(name, physics);
			hats.put(hatColor, dwarfs);
			input = sc.nextLine();

		}

		Map<String, Integer> hatSorted = new LinkedHashMap<>();
		hats.entrySet()
		        .stream()
		        .sorted((f, s) -> Integer.compare(s.getValue().size(), f.getValue().size()))
				.forEach(x -> {
					x.getValue().forEach((k, v) -> {
						hatSorted.put(x.getKey() + " " + k, v);});

				});
		
		hatSorted.entrySet()
		         .stream()
		         .sorted((f, s) -> Integer.compare(s.getValue(), f.getValue()))
		         .forEach(x -> {
			              String[] arr = x.getKey().split(" ");
			              System.out.printf("(%s) %s <-> %d%n", arr[0], arr[1], x.getValue());
		});
		sc.close();
		
	}
}
