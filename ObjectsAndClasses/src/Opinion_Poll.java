import java.util.Scanner;

public class Opinion_Poll {

	public static void main(String[] args) {
		Person pr = new Person();
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		pr.print(n, sc);
		sc.close();

	}

}

class Person {
	String name = "";
	int age = 0;

	public void print(int n, Scanner sc) {

		for (int i = 0; i < n; i++) {
			String[] person = sc.nextLine().split(" ");
			this.name = person[0];
			this.age = Integer.parseInt(person[1]);
			if (age > 30) {
				System.out.println(name + " - " + age);
			}

		}

	}

}