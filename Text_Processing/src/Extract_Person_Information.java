import java.util.Scanner;

public class Extract_Person_Information {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String str = "";

		String name = "";
		String age = "";
		for (int i = 0; i < n; i++) {
			str = sc.nextLine();
			int s1 = str.indexOf("@");
			int s2 = str.indexOf("|");
			int s3 = str.indexOf("#");
			int s4 = str.indexOf("*");
			name = str.substring(s1 + 1, s2);
			age = str.substring(s3 + 1, s4);
			System.out.printf("%s is %s years old.\n", name, age);
		}
		sc.close();
	}

}
