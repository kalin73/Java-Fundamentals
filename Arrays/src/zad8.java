import java.util.Arrays;
import java.util.Scanner;

public class zad8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] array = createArray(sc, n);
		for (int arr : array) {
			System.out.print(arr + " ");
		}
		int sum = Arrays.stream(array).reduce(0, (a, b) -> a + b);
		System.out.println("\n" + sum);
	}

	public static int[] createArray(Scanner s, int n) {

		String[] array = new String[n];

		int size = array.length;
		int[] numbers = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = s.nextLine();
			numbers[i] = Integer.parseInt(array[i]);

		}
		return numbers;
	}

}
