import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Remove_Negatives_and_Reverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numbers = createArrayList(sc);
		removeNegative(numbers);

		if (numbers.isEmpty()) {
			System.out.println("empty");
		} else {
			Collections.reverse(numbers);
			for (Integer in : numbers) {
				System.out.print(in + " ");
			}
		}

	}

	static ArrayList<Integer> createArrayList(Scanner sc) {
		ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(sc.nextLine().split(" "))
				.map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		return numbers;
	}

	static ArrayList<Integer> removeNegative(ArrayList<Integer> ar) {

		Integer[] arr = new Integer[ar.size()];
		arr = ar.toArray(arr);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				ar.removeAll(Arrays.asList(arr[i]));
			}
		}
		return ar;
	}
}
