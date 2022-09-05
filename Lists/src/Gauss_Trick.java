import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Gauss_Trick {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> numbers = createList(sc);
		List<Integer> sum = sum(numbers);
		for (Integer i : sum) {
			System.out.print(i + " ");
		}

	}

	static List<Integer> createList(Scanner s) {
		List<Integer> numbers = Arrays.stream(s.nextLine().split(" ")).map(x -> Integer.parseInt(x))
				.collect(Collectors.toList());
		return numbers;
	}

	static List<Integer> sum(List<Integer> l) {
		List<Integer> numbers = l;
		List<Integer> sum = new ArrayList<>();
		int count = numbers.size() - 1;
		for (int i = 0; i < numbers.size() / 2; i++) {
			sum.add(numbers.get(i) + numbers.get(count));
			count--;
		}
		if (numbers.size() % 2 != 0) {
			sum.add(numbers.get((numbers.size() / 2)));
		}
		return sum;
	}

}
