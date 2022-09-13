import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Order_by_Age {

	public static void main(String[] args) {
		Info in = new Info();
		in.addingPeople();
		in.print();

	}

}

class Info {
	String name = "";
	String id = "";
	int age = 0;
	Scanner sc = new Scanner(System.in);

	List<Info> people = new ArrayList<>();

	public Info() {

	}

	public Info(String name, String id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;

	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public void addingPeople() {
		String[] input = sc.nextLine().split(" ");
		while (!input[0].equals("End")) {

			name = input[0];
			id = input[1];
			age = Integer.parseInt(input[2]);

			people.add(new Info(name, id, age));
			input = sc.nextLine().split(" ");
		}

	}

	public void print() {

		Collections.sort(people, Comparator.comparingInt(Info::getAge));

		people.forEach(x -> System.out.printf("%s with ID: %s is %d years old.%n", x.getName(), x.getId(), x.getAge()));

	}

}