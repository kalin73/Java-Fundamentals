import java.util.*;

public class zad12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = createArray(sc);
		findEqualSums(array);

	}

	public static int[] createArray(Scanner s) {
		int[] arr = Arrays.stream(s.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		return arr;
	}

	public static void findEqualSums(int[] arr) {

		boolean isEqual = false;
		int res = 0;
		int leftSum = 0;
		int rightSum = 0;

		for (int i = 0; i < arr.length; i++) {
			leftSum = 0;
			rightSum = 0;

			for (int k = 0; k < i; k++) {
				leftSum += arr[k];
			}
			for (int j = i + 1; j < arr.length; j++) {
				rightSum += arr[j];
			}

			if (leftSum == rightSum) {
				res = i;
				isEqual = true;
				break;
			}
			leftSum = 0;
			rightSum = 0;
		}
		if (isEqual) {
			System.out.println(res);

		} else {
			System.out.println("no");
		}
	}
}
