import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> numbers = createList(sc);
		int seats = Integer.parseInt(sc.nextLine());
		instrucions(numbers, sc, seats);
	}

	static List<Integer> createList(Scanner sc) {
		List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).map(x -> Integer.parseInt(x))
				.collect(Collectors.toList());
		return list;
	}

	static void instrucions(List<Integer> l, Scanner sc, int seats) {

		while (true) {
			String[] arr = sc.nextLine().split(" ");
			if (arr[0].equals("end")) {
				break;

			} else if (arr[0].equals("Add")) {
				l.add(Integer.parseInt(arr[1]));

			} else {

				for (int i = 0; i < l.size(); i++) {
					if (seats - l.get(i) >= Integer.parseInt(arr[0])) {

						l.set(i, l.get(i) + Integer.parseInt(arr[0]));
						break;

					}
				}
			}

		}
		l.forEach(x -> System.out.print(x + " "));
	}
}
