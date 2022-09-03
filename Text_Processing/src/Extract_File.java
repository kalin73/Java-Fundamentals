import java.util.Scanner;
import java.util.regex.Pattern;

public class Extract_File {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] url = sc.nextLine().split(Pattern.quote("\\"));
		String file = url[url.length - 1];
		String fileName = "";
		String fileExtension = "";

		for (int i = 0; i < file.length(); i++) {
			if (file.charAt(i) == '.') {
				fileName = file.substring(0, i);
				fileExtension = file.substring(i + 1, file.length());
			}

		}
		System.out.println("File name: " + fileName);
		System.out.println("File extension: " + fileExtension);
		sc.close();
	}

}
