import java.util.Scanner;

public class zad18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		System.out.println(GetFibonacci(n));

	}

	 static int GetFibonacci(int n) {
		int result = 0;
		int fstN = 1;
		int secN = 2;
		if (n == 2 || n == 1) {
			return 1;
		} else if (n == 3) {
			return 2;
		}

		for (int i = n - 3; i > 0; i--) {

			result = fstN + secN;
			fstN = secN;
			secN = result;

		}

		return result;
	}

}
