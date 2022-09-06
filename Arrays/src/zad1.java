import java.util.*;

public class zad1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dayNumber = Integer.parseInt(sc.nextLine());
		sc.close();
		String[] array = new String[7];
		array[0] = "Monday";
		array[1] = "Tuesday";
		array[2] = "Wednesday";
		array[3] = "Thursday";
		array[4] = "Friday";
		array[5] = "Saturday";
		array[6] = "Sunday";

		if (dayNumber > 0 && dayNumber < 8) {
			for (int i = 1; i <= array.length; i++) {
				if (dayNumber == i) {
					System.out.println(array[i - 1]);
					break;
				}

			}

		} else {
			System.out.println("Invalid day!");
		}

	}

}
