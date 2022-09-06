
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class zad16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		String[] array = createArray(sc, n);
		BigInteger[] cryptedArr = cryptedArray(array, n);
		printArray(cryptedArr);
	}

	public static String[] createArray(Scanner sc, int n) {
		String[] arr2 = new String[n];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = sc.nextLine();
		}
		return arr2;
	}

	public static BigInteger[] cryptedArray(String[] arr2, int n) {
		int ascii;
		char a;
		BigInteger[] arr = new BigInteger[n];
		BigInteger code1 = new BigInteger("0");
		BigInteger code2 = new BigInteger("0");
		for (int i = 0; i < arr2.length; i++) {

			for (int k = 0; k < arr2[i].length(); k++) {

				if (arr2[i].charAt(k) == 'a' || arr2[i].charAt(k) == 'A') {

					a = arr2[i].charAt(k);
					ascii = a;
					code1 = code1.add(BigInteger.valueOf(ascii * arr2[i].length()));

				} else if (arr2[i].charAt(k) == 'e' || arr2[i].charAt(k) == 'E') {

					a = arr2[i].charAt(k);
					ascii = a;
					code1 = code1.add(BigInteger.valueOf(ascii * arr2[i].length()));

				} else if (arr2[i].charAt(k) == 'i' || arr2[i].charAt(k) == 'I') {

					a = arr2[i].charAt(k);
					ascii = a;
					code1 = code1.add(BigInteger.valueOf(ascii * arr2[i].length()));
				} else if (arr2[i].charAt(k) == 'o' || arr2[i].charAt(k) == 'O') {

					a = arr2[i].charAt(k);
					ascii = a;
					code1 = code1.add(BigInteger.valueOf(ascii * arr2[i].length()));

				} else if (arr2[i].charAt(k) == 'u' || arr2[i].charAt(k) == 'U') {

					a = arr2[i].charAt(k);
					ascii = a;
					code1 = code1.add(BigInteger.valueOf(ascii * arr2[i].length()));
				} else {

					a = arr2[i].charAt(k);
					ascii = a;
					code1 = code1.add(BigInteger.valueOf(ascii / arr2[i].length()));

				}
			}
			arr[i] = code1.add(code2);
			code1 = new BigInteger("0");
			code1 = new BigInteger("0");
		}
		return arr;
	}

	public static void printArray(BigInteger[] ar) {
		Arrays.sort(ar);
		for (BigInteger i : ar) {
			System.out.println(i);
		}

	}
}
