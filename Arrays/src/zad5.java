import java.util.Scanner;

public class zad5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = createArray(sc);
		System.out.println(sumDiff(numbers));

	}

	public static int[] createArray(Scanner s) {
		String[] arr = s.nextLine().split(" ");
		int size = arr.length;
		int[] numbArray = new int[size];
		for (int i = 0; i < numbArray.length; i++) {
			numbArray[i] = Integer.parseInt(arr[i]);
		}
		return numbArray;
	}

	public static int sumDiff(int[] arr) {
		int oddSum = 0;
		int evenSum = 0;
		int diff = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] % 2 == 0) {
				evenSum += arr[i];
			} else {
				oddSum += arr[i];
			}
			diff = evenSum - oddSum;
		}
		return diff;
	}
}
