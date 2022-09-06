import java.util.*;

public class zad2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numbers = Integer.parseInt(sc.nextLine());

		int[] numbs = createArray(numbers, sc);
		printReverseArray(numbs);
	}

	public static int[] createArray(int n, Scanner sc) {
		int numb;
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numb = Integer.parseInt(sc.nextLine());
			numbers[i] = numb;

		}
		return numbers;
	}

	public static void printReverseArray(int[] arr) {

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}

	}
}
