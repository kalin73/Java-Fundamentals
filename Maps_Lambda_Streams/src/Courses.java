import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Courses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] students = sc.nextLine().split(":");
		String[] names;
		Map<String, String> course = new LinkedHashMap<>();
		while (!students[0].equals("end")) {
			if (course.containsKey(students[0])) {
				course.put(students[0], course.get(students[0]) + ":" + students[1]);
				students = sc.nextLine().split(":");
				continue;
			}

			course.put(students[0], students[1]);

			students = sc.nextLine().split(":");

		}
		for (String s : course.keySet()) {
			names = course.get(s).split(":");
			System.out.println(s.trim() + ": " + names.length);
			for (String st : names) {
				System.out.println("--" + st);
			}
		}
		sc.close();

	}

}
