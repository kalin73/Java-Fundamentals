import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Student_Academy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Map<String, Double> grades = new LinkedHashMap<>();
		List<String> names = new ArrayList<>();
		for (int i = 0; i < n; i++) {

			String name = sc.nextLine();
			Double grade = Double.parseDouble(sc.nextLine());

			if (grades.containsKey(name)) {
				grade = (grades.get(name) + grade) / 2;
				grades.put(name, grade);
				continue;

			}

			grades.put(name, grade);

		}

		for (Map.Entry<String, Double> entry : grades.entrySet()) {

			if (entry.getValue() < 4.5) {
				names.add(entry.getKey());
				continue;
			}
		}
		for (String s : names) {

			grades.remove(s);

		}

		grades.forEach((key, value) -> {System.out.printf("%s -> %.2f\n", key, value);});

		sc.close();

	}

}
