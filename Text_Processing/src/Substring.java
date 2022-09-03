import java.util.Scanner;

public class Substring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.nextLine();
		String str = sc.nextLine();

		while (str.indexOf(word) >= 0) {
			str = str.replace(word, "");
		}
		System.out.println(str);
		sc.close();
	}

}
