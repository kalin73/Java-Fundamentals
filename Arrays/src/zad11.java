import java.util.Arrays;
import java.util.Scanner;

public class zad11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = createArray(sc);
		String res = "";
		res = topNumbers(arr, res);
		System.out.println(res);

	}

	public static int[] createArray(Scanner s) {
		int[] arr = Arrays.stream(s.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		return arr;
	}

	public static String topNumbers(int[] arr, String res) {
		boolean bigN = false;

		for (int i = 0; i < arr.length; i++) {
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[i] > arr[k]) {
					bigN = true;

				} else {
					bigN = false;
					i = k - 1;
					break;
				}

			}
			if (i == arr.length - 1) {
				res += arr[i];
			} else if (bigN) {
				res += arr[i] + " ";
			} else if (arr.length == 1) {
				res += arr[0];
			}

		}
		return res;
	}

}
