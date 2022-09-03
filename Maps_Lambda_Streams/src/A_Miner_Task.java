import java.util.LinkedHashMap;
import java.util.Scanner;

public class A_Miner_Task {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
		int count = 1;
		String resource = "";
		Integer quant = 0;
		while (!word.equals("stop")) {

			if (count % 2 != 0) {
				resource = word;
				if (!resources.containsKey(resource)) {
					resources.put(resource, 0);
				}

			} else {
				quant = Integer.parseInt(word);
				resources.put(resource, resources.get(resource) + quant);
			}
			word = sc.nextLine();
			count++;
		}
		for (String s : resources.keySet()) {

			System.out.println(s + " -> " + resources.get(s));

		}
		sc.close();
	}

}
