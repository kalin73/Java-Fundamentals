
import java.util.Arrays;
import java.util.Scanner;

public class zad10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		int[] arr1 = new int[n];
		int[] arr2 = new int[n];

		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {

				int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();

				arr2[i - 1] = arr[0];
				arr1[i - 1] = arr[1];
			} else {
				int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();

				arr1[i - 1] = arr[0];
				arr2[i - 1] = arr[1];
			}
		}
		for (int ar : arr1) {
			System.out.print(ar + " ");
		}
		System.out.println();

		for (int ar : arr2) {
			System.out.print(ar + " ");
		}
		sc.close();
	}

}
