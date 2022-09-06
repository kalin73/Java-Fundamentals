import java.util.Scanner;

public class zad17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] arr2 = null;
		for (int i = 1; i <= n; i++) {
			int[] arr1 = new int[i];
			for (int k = 0; k < i; k++) {
				if (k == 0 || k == arr1.length - 1) {
					arr1[k] = 1;
				} else {
					arr1[k] = arr2[k - 1] + arr2[k];
				}
			}
			for (int j : arr1) {
				System.out.print(j + " ");
			}
			arr2 = arr1;
			System.out.println();
		}
		sc.close();
	}

}
