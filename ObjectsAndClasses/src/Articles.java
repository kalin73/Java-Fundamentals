import java.util.Scanner;

public class Articles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] article = sc.nextLine().split(",");
		String title = article[0].trim();
		String content = article[1];
		String author = article[2];
		int n = Integer.parseInt(sc.nextLine());
		Article art = new Article(title, content, author);

		for (int i = 0; i < n; i++) {
			String[] commands = sc.nextLine().split(":");
			String command = commands[0].trim();
			String newContent = commands[1];
			switch (command) {
			case "Edit":
				art.edit(newContent);
				break;

			case "ChangeAuthor":
				art.changeAuthor(newContent);
				break;

			case "Rename":
				art.rename(newContent);
				break;

			}
		}
		System.out.println(art.toString());
		sc.close();

	}

}

class Article {

	String title = "";
	String content = "";
	String author = "";

	public Article(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public void edit(String newContent) {
		content = newContent;
	}

	public void changeAuthor(String newAuthor) {
		author = newAuthor;
	}

	public void rename(String newTitle) {
		title = newTitle;
	}

	@Override
	public String toString() {
		return (title + " -" + content + ":" + author).trim();
	}
}