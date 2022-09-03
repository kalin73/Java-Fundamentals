import java.util.Scanner;

public class Repeat_Strings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(" ");
		String newWord = "";
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[i].length(); k++) {
				newWord += arr[i];
			}
		}
		System.out.println(newWord);
		sc.close();
	}

}
