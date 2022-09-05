import java.util.Scanner;

public class Append_Arrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String numbers = sc.nextLine();
		String result = "";
		int lastIndex = 0;
		int last = numbers.lastIndexOf('|');
		for (int i = 0; i < numbers.length(); i++) {
			if (numbers.charAt(i) == '|') {
				result = numbers.substring(lastIndex, i)+" " + result;
				lastIndex = i + 1;
			}

		}
		
		result = numbers.substring(last + 1, numbers.length())+" " + result;
		result=result.trim();
		String[] arr = result.split("\\s+");
		for (String st : arr) {
			System.out.print(st + " ");
		}
		sc.close();
	}
}
