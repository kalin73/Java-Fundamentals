import java.util.Scanner;

public class Letters_Change_Numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		double sum = 0;
		double total = 0;
		String[] arr = st.split("[^a-zA-Z0-9]+");
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[i].length(); k += arr[i].length() - 1) {
				int number = Integer.parseInt(arr[i].substring(1, arr[i].length() - 1));
				if (k != arr[i].length() - 1) {
					if (!Character.isLowerCase(arr[i].charAt(k))) {
						double position = arr[i].charAt(k) - 64;

						sum += number / position;
					} else if (Character.isLowerCase(arr[i].charAt(k))) {
						double position = arr[i].charAt(k) - 96;

						sum += number * position;

					}

				} else if (k == arr[i].length() - 1) {

					if (!Character.isLowerCase(arr[i].charAt(k))) {
						double position = arr[i].charAt(k) - 64;

						sum -= position;
					} else if (Character.isLowerCase(arr[i].charAt(k))) {

						double position = arr[i].charAt(k) - 96;
						sum += position;

					}
				}
			}
			total += sum;
			sum = 0;

		}
		System.out.printf("%.2f", total);
		sc.close();
	}

}
