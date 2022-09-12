import java.math.BigInteger;
import java.util.Scanner;

public class zad3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		BigInteger nF = new BigInteger("1");

		System.out.println(nFactorial(n, nF));

		s.close();
	}

	static BigInteger nFactorial(int n, BigInteger nF) {

		for (int i = 1; i <= n; i++) {

			nF = nF.multiply(BigInteger.valueOf(i));
		}
		return nF;
	}
}
