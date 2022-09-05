import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cards_Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> arr1 = create(sc);
		ArrayList<Integer> arr2 = create(sc);

		cardGame(arr1, arr2);

	}

	static ArrayList<Integer> create(Scanner s) {
		ArrayList<Integer> arr = (ArrayList<Integer>) Arrays.stream(s.nextLine().split(" "))
				.map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		return arr;
	}

	static void cardGame(ArrayList<Integer> ar1, ArrayList<Integer> ar2) {
		int j = -1;
		for (int i = 0; i < ar1.size(); i++) {
			j++;
			if (ar1.get(i) > ar2.get(j)) {
				ar1.add(ar1.get(i));
				ar1.remove(i);
				ar1.add(ar2.get(j));
				ar2.remove(j);
				j -= 1;
				i -= 1;
			} else if (ar1.get(i) < ar2.get(j)) {
				ar2.add(ar2.get(j));
				ar2.remove(j);
				ar2.add(ar1.get(i));
				ar1.remove(i);
				j -= 1;
				i -= 1;
			} else {
				ar2.remove(j);
				ar1.remove(i);
				j -= 1;
				i -= 1;

			}
			if (ar2.isEmpty()) {
				long sum = ar1.stream().mapToLong(Integer::longValue).sum();
				System.out.println("First player wins! Sum: " + sum);
				break;
			} else if (ar1.isEmpty()) {
				long sum = ar2.stream().mapToLong(Integer::longValue).sum();
				System.out.println("Second player wins! Sum: " + sum);
				break;
			}

		}
	}
}
