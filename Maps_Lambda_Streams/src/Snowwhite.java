
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

//NOT FINISHED!!!
public class Snowwhite {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		LinkedHashMap<String, Dwarf> map = new LinkedHashMap<>();
		List<String> list = new ArrayList<>();
		String[] dwarf = input.split("<:>");

		while (!input.equals("Once upon a time")) {
			dwarf = input.split("<:>");
			String name = dwarf[0].trim();
			String hatColor = dwarf[1].trim();
			int physics = Integer.parseInt(dwarf[2].trim());
			Dwarf dw = map.get(hatColor);

			if (!map.containsKey(hatColor)) {
				map.put(hatColor, new Dwarf(name, physics, 1));
				input = sc.nextLine();
				continue;

			} else if (map.get(hatColor).getName().equals(name)) {
				dw.setPhysics(Math.max(physics, map.get(hatColor).getPhysics()));
				map.put(hatColor, dw);
				input = sc.nextLine();
				continue;

			}

			map.put(hatColor, new Dwarf(name, physics, 1));
			input = sc.nextLine();

		}
		Collections.sort(list, (s, f) -> s.compareTo(f));
////map.entrySet().stream().sorted((f,s)->s.getValue().g)
//		map.entrySet().stream().sorted((f, s) -> Integer.compare(s.getKey().getHatCount(), f.getKey().getHatCount()))
//				.sorted((fs, se) -> Integer.compare(se.getValue().getPhysics(), fs.getValue().getPhysics()))
//				.forEach(x -> System.out.println(x.getKey().getHatColor() + " " + x.getValue().getName() + " "
//						+ x.getValue().getPhysics() + " " + x.getKey().getHatCount()));

//		Collections.sort(dwarfs, (x1, x2) -> Integer.compare(x2.getPhysics(), x1.getPhysics()));
//		dwarfs.forEach((x) -> {
//
//			System.out.println(x.getName() + " " + x.getPhysics());
//
//		});
	}
}

class Dwarf {
	private String name;
	private int physics;
	int counter;

	public Dwarf() {

	}

	public Dwarf(String name, int physics, int counter) {
		this.name = name;
		this.physics = physics;
	}

	public Dwarf(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPhysics() {
		return physics;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getCounter() {
		return counter;
	}
}

class HatCounter {

	String hatColor;
	int hatCount;

	public HatCounter(String hatColor, int hatCount) {

		this.hatColor = hatColor;
		this.hatCount = hatCount;
	}

	public HatCounter() {

	}

	public String getHatColor() {
		return hatColor;
	}

	public void setHatColor(String hatColor) {
		this.hatColor = hatColor;
	}

	public int getHatCount() {
		return hatCount;
	}

	public void setHatCount(int hatCount) {
		this.hatCount = hatCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hatColor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HatCounter other = (HatCounter) obj;
		return Objects.equals(hatColor, other.hatColor);
	}

}