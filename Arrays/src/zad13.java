import java.util.Arrays;
import java.util.Scanner;

public class zad13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = createArray(sc);
		System.out.println(printSequnce(array));

	}

	public static int[] createArray(Scanner s) {
		int[] array = Arrays.stream(s.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		return array;
	}

	public static String printSequnce(int[] ar) {
		String sequence = "";
		String maxS = "";
		int count = 1;
		int max = 0;

		for (int i = 0; i < ar.length - 1; i++) {

			if (ar[i] == ar[i + 1]) {
				
				count += 1;
				sequence += ar[i] + " " + ar[i] + " ";
				
				for (int j = i + 2; j < ar.length; j++) {
					
					if (ar[i] == ar[j]) {
						count += 1;
						sequence += ar[i] + " ";

					} else {
						i = j - 1;
						break;
					}
				}

				if (count > max) {

					maxS = sequence;
					max = count;

				}
				sequence = "";
				count = 1;
			}

		}
		return maxS;
	}

}
