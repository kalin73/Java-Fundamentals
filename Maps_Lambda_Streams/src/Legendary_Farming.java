import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Legendary_Farming {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean crafted = true;

		Map<String, Integer> items = new LinkedHashMap<>();
		items.put("shards", 0);
		items.put("fragments", 0);
		items.put("motes", 0);

		int quant = 0;
		String material = "";
		String item = "";

		while (crafted) {
			String[] materials = sc.nextLine().toLowerCase().split(" ");
			for (int i = 0; i < materials.length; i += 2) {

				quant = Integer.parseInt(materials[i]);
				material = materials[i + 1].toLowerCase();

				if (items.get(material) != null) {

					items.put(material, items.get(material) + quant);

				} else {
					items.put(material, quant);
				}

				if (material.equals("shards")) {
					if (items.get(material) >= 250) {

						crafted = false;
						items.put(material, items.get(material) - 250);
						item = "Shadowmourne obtained!";
						break;
					}

				} else if (material.equals("fragments")) {
					if (items.get(material) >= 250) {

						crafted = false;
						items.put(material, items.get(material) - 250);
						item = "Valanyr obtained!";
						break;
					}

				} else if (material.equals("motes")) {
					if (items.get(material) >= 250) {

						crafted = false;
						items.put(material, items.get(material) - 250);
						item = "Dragonwrath obtained!";
						break;
					}

				}

			}

		}
		System.out.println(item);
		System.out.println("shards: " + items.get("shards"));
		items.remove("shards");
		System.out.println("fragments: " + items.get("fragments"));
		items.remove("fragments");
		System.out.println("motes: " + items.get("motes"));
		items.remove("motes");

		for (String s : items.keySet()) {
			System.out.println(s + ": " + items.get(s));
		}
		sc.close();
	}
}
