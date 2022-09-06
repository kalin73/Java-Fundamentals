import java.util.Scanner;

public class zad3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = createArray(sc);
		printSumOfEvenNumbers(numbers);
	}

	public static int[] createArray(Scanner s) {

		String[] numbers = s.nextLine().split(" ");
		int size = numbers.length;
		int[] numbs = new int[size];
		for (int i = 0; i < numbs.length; i++) {
			numbs[i] = Integer.parseInt(numbers[i]);
		}
		return numbs;
	}

	public static void printSumOfEvenNumbers(int[] n) {
		int sum = 0;
		for (int i = 0; i < n.length; i++) {
			if (n[i] % 2 == 0) {
				sum += n[i];
			}
		}
		System.out.println(sum);
	}
}
