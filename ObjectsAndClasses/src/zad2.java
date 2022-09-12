import java.math.BigInteger;
import java.util.Scanner;

public class zad2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BigInteger n1 = new BigInteger(s.nextLine());
		BigInteger n2 = new BigInteger(s.nextLine());

		System.out.println(sumBigInt(n1, n2));

		s.close();
	}

	public static BigInteger sumBigInt(BigInteger n1, BigInteger n2) {
		BigInteger result;
		result = n1.add(n2);
		return result;
	}
}
