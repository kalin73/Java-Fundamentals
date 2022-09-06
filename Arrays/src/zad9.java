
import java.util.Scanner;

public class zad9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr1 = sc.nextLine().split(" ");
		String[] arr2 = sc.nextLine().split(" ");
		String res = "";
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				if (arr2[i].equals(arr1[j])) {

					res += arr2[i] + " ";

				}
			}

		}
		System.out.println(res);
		sc.close();
	}

}
