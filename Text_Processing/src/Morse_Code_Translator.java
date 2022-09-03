import java.util.Scanner;

public class Morse_Code_Translator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split("[|]");
		StringBuilder text = new StringBuilder("");

		for (int i = 0; i < str.length; i++) {
			String[] code = str[i].split(" ");

			for (int k = 0; k < code.length; k++) {

				switch (code[k]) {
				case ".-":
					text.append("A");
					break;

				case "-...":
					text.append("B");
					break;

				case "-.-.":
					text.append("C");
					break;

				case "-..":
					text.append("D");
					break;

				case ".":
					text.append("E");
					break;

				case "..-.":
					text.append("F");
					break;

				case "--.":
					text.append("G");
					break;

				case "....":
					text.append("H");
					break;

				case "..":
					text.append("I");
					break;

				case ".---":
					text.append("J");
					break;

				case "-.-":
					text.append("K");
					break;

				case ".-..":
					text.append("L");
					break;

				case "--":
					text.append("M");
					break;

				case "-.":
					text.append("N");
					break;

				case "---":
					text.append("O");
					break;

				case ".--.":
					text.append("P");
					break;

				case "--.-":
					text.append("Q");
					break;

				case ".-.":
					text.append("R");
					break;

				case "...":
					text.append("S");
					break;

				case "-":
					text.append("T");
					break;

				case "..-":
					text.append("U");
					break;

				case "...-":
					text.append("V");
					break;

				case ".--":
					text.append("W");
					break;

				case "-..-":
					text.append("X");
					break;

				case "-.--":
					text.append("Y");
					break;

				case "--..":
					text.append("Z");
					break;

				default:
					break;

				}
			}
			text.append(" ");
		}
		System.out.println(text);
		sc.close();
	}

}
