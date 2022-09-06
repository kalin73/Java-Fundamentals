import java.util.Scanner;

public class zad4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] array = createArray(sc);
		
		reverseArray(array);
		printArray(array);
		
	}

	public static String[] createArray(Scanner s) {

		String[] array = s.nextLine().split(" ");
		return array;
	}

	public static String[] reverseArray(String[] ar) {
		int lastElement = ar.length - 1;
		String temp;
		for (int i = 0; i < ar.length / 2; i++) {
			temp = ar[i];
			ar[i] = ar[lastElement];
			ar[lastElement] = temp;
			lastElement--;
		}
		return ar;
	}

	public static void printArray(String[] ar) {
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
	}
}
