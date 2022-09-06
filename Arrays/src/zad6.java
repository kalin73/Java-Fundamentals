import java.util.Scanner;

public class zad6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers1 = createArray(sc);
		int[] numbers2 = createArray(sc);
		print(numbers1, numbers2);
	}

	public static int[] createArray(Scanner s) {

		String[] array = s.nextLine().split(" ");

		int size = array.length;
		int[] numbers = new int[size];
		for (int i = 0; i < size; i++) {
			numbers[i] = Integer.parseInt(array[i]);
		}
		return numbers;
	}

	public static void print(int[] arr1, int[] arr2) {
		boolean equal = false;
		int diff = 0;
		int sum = 0;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == arr2[i]) {
				equal = true;

			} else {
				diff = i;
				equal = false;
				break;
			}

		}
		if (equal) {
			for (int i = 0; i < arr1.length; i++) {
				sum += arr1[i];
			}
			System.out.println("Arrays are identical. Sum: " + sum);
		} else {
			System.out.printf("Arrays are not identical. Found difference at %d index.", diff);

		}
	}

}
