import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class List_Manipulation_Basics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numbers = createList(sc);
		while (true) {
			String[] in = sc.nextLine().split(" ");

			if (in[0].equals("end")) {
				break;
			}

			switch (in[0]) {
			case "Add":
				int values = Integer.parseInt(in[1]);
				numbers.add(numbers.size(), values);
				break;

			case "Remove":
				values = Integer.parseInt(in[1]);
				numbers.removeAll(Arrays.asList(values));

				break;

			case "RemoveAt":
				values = Integer.parseInt(in[1]);
				numbers.remove(values);
				break;

			case "Insert":
				values = Integer.parseInt(in[1]);
				int values2 = Integer.parseInt(in[2]);
				numbers.add(values2, values);
				break;
			}

		}
		for (Integer i : numbers) {
			System.out.print(i + " ");
		}
	}

	static ArrayList<Integer> createList(Scanner s) {
		ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(s.nextLine().split(" "))
				.map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		return numbers;
	}

}
