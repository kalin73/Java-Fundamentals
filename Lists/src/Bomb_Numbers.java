import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb_Numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = createArrayList(sc);

		int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();

		detonate(arr, array[0], array[1]);

		System.out.println(arr.stream().mapToLong(Integer::longValue).sum());
	}

	static ArrayList<Integer> createArrayList(Scanner s) {
		ArrayList<Integer> arr = (ArrayList<Integer>) Arrays.stream(s.nextLine().split(" "))
				.map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		return arr;
	}

	static void detonate(ArrayList<Integer> arr, int bomb, int power) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == bomb) {
				arr.set(i, 0);
				for (int k = 1; k <= power; k++) {
					if (i + k < arr.size()) {
						arr.set(i + k, 0);
					}
					if (i - k >= 0) {
						arr.set(i - k, 0);
					}
				}
			}
		}
	}
}
