import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Merging_Lists {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list1 = createList(sc);
		List<Integer> list2 = createList(sc);
		List<Integer> result = result(list1, list2);

		for (Integer i : result) {
			System.out.print(i + " ");
		}

	}

	static List<Integer> createList(Scanner s) {
		ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(s.nextLine().split(" ")).map(x -> Integer.parseInt(x))
				.collect(Collectors.toList());
		return numbers;
	}

	static List<Integer> result(List<Integer> l1, List<Integer> l2) {

		List<Integer> result = new ArrayList<>();

		if (l1.size() > l2.size()) {

			for (int i = 0; i < l2.size(); i++) {
				result.add(l1.get(i));
				result.add(l2.get(i));
			}
			for (int i = l2.size(); i < l1.size(); i++) {
				result.add(l1.get(i));
			}

		} else if (l2.size() > l1.size()) {
			for (int i = 0; i < l1.size(); i++) {
				result.add(l1.get(i));
				result.add(l2.get(i));
			}
			for (int i = l1.size(); i < l2.size(); i++) {
				result.add(l2.get(i));
			}
		} else {
			for (int i = 0; i < l1.size(); i++) {
				result.add(l1.get(i));
				result.add(l2.get(i));
			}
		}
		return result;
	}
}
