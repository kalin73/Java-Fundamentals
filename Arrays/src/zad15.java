import java.util.Arrays;
import java.util.Scanner;

public class zad15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = createArray(sc);
		int n = Integer.parseInt(sc.nextLine());
		int temp = 0;

		for (int i = 0; i < n; i++) {
			temp = arr[0];
			for (int j = 0; j < arr.length - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[arr.length - 1] = temp;

		}
		for (int ar : arr) {
			System.out.print(ar + " ");
		}
	}

	public static int[] createArray(Scanner s) {
		int[] array = Arrays.stream(s.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		return array;
	}
}
