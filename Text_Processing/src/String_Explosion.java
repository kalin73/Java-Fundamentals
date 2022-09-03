import java.util.Scanner;

public class String_Explosion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bomb = 0;
		StringBuilder str = new StringBuilder(sc.nextLine());
		for (int i = 0; i < str.length(); i++) {

			if (bomb > 0 && str.charAt(i) != '>') {
				str = str.deleteCharAt(i);
				bomb--;
				i--;
			} else if (str.charAt(i) == '>') {
				bomb += Character.getNumericValue(str.charAt(i + 1));
			}
		}
		System.out.println(str);
		sc.close();
	}

}
