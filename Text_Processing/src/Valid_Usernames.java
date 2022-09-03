import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valid_Usernames {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pattern = "[a-zA-Z0-9-_]+";

		String[] usernames = sc.nextLine().split(", ");
		for (int i = 0; i < usernames.length; i++) {
			
			Pattern pt = Pattern.compile(pattern);
			Matcher match = pt.matcher(usernames[i]);
			if (usernames[i].length() >= 3 && usernames[i].length() < 16) {
				if (match.matches()) {
					System.out.println(usernames[i]);

				}
			}
		}
		sc.close();
	}

}
