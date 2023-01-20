import java.util.Scanner;

public class zad18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		System.out.println(GetFibonacci(n));
		sc.close();
	}

	static int GetFibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}

		return GetFibonacci(n - 1) + GetFibonacci(n - 2);
	}
}
