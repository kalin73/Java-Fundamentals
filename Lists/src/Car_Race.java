import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Car_Race {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(sc.nextLine().split(" "))
				.map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		double left = 0.0;
		double right = 0.0;

		for (int i = 0; i < (numbers.size() / 2); i++) {
			if (numbers.get(i) == 0) {
				left = left - (left * 0.2);
			} else {
				left += numbers.get(i);
			}
		}
		for (int k = numbers.size() - 1; k > ((numbers.size()/2)); k--) {
			if (numbers.get(k) == 0) {
				right = right - (right * 0.2);
			} else {
				right += numbers.get(k);
			}
		}
		if (left > right) {
			System.out.printf("The winner is right with total time: %.1f", right);
		} else {
			System.out.printf("The winner is left with total time: %.1f", left);
		}
		sc.close();
	}

}
