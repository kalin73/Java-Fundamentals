import java.util.Arrays;
import java.util.Scanner;

public class zad14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = createArray(sc);
		int n = Integer.parseInt(sc.nextLine());
		printMagicSum(array, n);
	}

	public static int[] createArray(Scanner s) {
		int[] array = Arrays.stream(s.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		return array;
	}

	public static void printMagicSum(int[] arr, int n) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {
				res = arr[i] + arr[j];
				if (res == n) {
					System.out.println(arr[i] + " " + arr[j]);
				}
			}

		}

	}

}
