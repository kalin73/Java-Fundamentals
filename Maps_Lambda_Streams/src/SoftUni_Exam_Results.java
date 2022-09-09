import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUni_Exam_Results {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		Map<String, Integer> exam = new LinkedHashMap<>();
		LinkedHashMap<String, Integer> count = new LinkedHashMap<>();

		while (!"exam finished".equals(input)) {
			String[] arr = input.split("-");
			if (input.contains("banned")) {
				String name = arr[0];
				exam.remove(name);
				input = sc.nextLine();
				continue;

			}
			String name = arr[0];
			String language = arr[1];
			Integer points = Integer.parseInt(arr[2]);

			exam.putIfAbsent(name, points);
			if (count.containsKey(language)) {
				count.put(language, count.get(language) + 1);
			}
			count.putIfAbsent(language, 1);

			if (exam.containsKey(name)) {
				exam.put(name, Math.max(exam.get(name), points));
			}

			input = sc.nextLine();
		}

		System.out.println("Results:");
		exam.forEach((key, value) -> {

			System.out.printf("%s | %d%n", key, value);

		});

		System.out.println("Submissions:");
		count.forEach((key, value) -> {

			System.out.printf("%s - %d%n", key, value);

		});
		sc.close();
	}

}
