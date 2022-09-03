import java.util.Scanner;

public class HTML {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String title = sc.nextLine();
		String content = sc.nextLine();
		String comments = sc.nextLine();
		StringBuilder html = new StringBuilder();
		title = String.format("<h1>\n    %s\n</h1>\n", title);
		content = String.format("<article>\n    %s\n</article>\n", content);
		html.append(title);
		html.append(content);

		while (!comments.equals("end of comments")) {

			comments = String.format("<div>\n    %s\n</div>\n", comments);
			html.append(comments);
			comments = sc.nextLine();
		}
		System.out.println(html);
		sc.close();
	}

}
