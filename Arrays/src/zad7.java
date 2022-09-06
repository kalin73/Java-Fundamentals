import java.util.Scanner;

public class zad7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = createArray(sc);
		print(numbers);
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

	public static void print(int[] arr) {
	;
		while (arr.length>=1) {
			int[] sumArray = new int[arr.length-1];
			if (arr.length > 1) {
				for (int i = 0; i < arr.length - 1; i++) {

					sumArray[i] = arr[i] + arr[i + 1];
				}
				arr = sumArray;

			}else {
				break;
			}
		}
		System.out.println(arr[0]);
	}
}