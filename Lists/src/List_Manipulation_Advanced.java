import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class List_Manipulation_Advanced {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numbers = createArrayList(sc);
		operations(numbers, sc);

	}

	static ArrayList<Integer> createArrayList(Scanner sc) {
		ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(sc.nextLine().split(" "))
				.map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		return numbers;
	}

	static void operations(ArrayList<Integer> numbers, Scanner s) {
		while (true) {
			String[] ins = s.nextLine().split(" ");

			if (ins[0].equals("end")) {
				break;
			}

			if (ins[0].equals("Contains")) {

				int values = Integer.parseInt(ins[1]);
				boolean contains = false;
				for (Integer i : numbers) {
					if (i == values) {
						contains = true;
						break;
					}

				}
				if (contains) {
					System.out.println("Yes");
				} else {
					System.out.println("No such number");
				}

			} else if ("Print".equals(ins[0]) && "even".equals(ins[1])) {

				for (Integer i : numbers) {
					if (i % 2 == 0) {
						System.out.print(i + " ");
					}
				}
				System.out.println();

			} else if ("Print".equals(ins[0]) && "odd".equals(ins[1])) {
				for (Integer i : numbers) {
					if (i % 2 != 0) {
						System.out.print(i + " ");
					}
				}
				System.out.println();

			} else if ("Get".equals(ins[0]) || "sum".equals(ins[1])) {
				int sum = 0;
				for (Integer i : numbers) {
					sum += i;
				}
				System.out.println(sum);

			} else if ("Filter".equals(ins[0])) {
				if (ins[1].equals("<")) {
					numbers.stream().filter(x -> x < Integer.parseInt(ins[2])).forEach(x -> System.out.print(x + " "));
					System.out.println();

				} else if (ins[1].equals(">")) {
					numbers.stream().filter(x -> x > Integer.parseInt(ins[2])).forEach(x -> System.out.print(x + " "));
					System.out.println();

				} else if (ins[1].equals(">=")) {
					numbers.stream().filter(x -> x >= Integer.parseInt(ins[2])).forEach(x -> System.out.print(x + " "));
					System.out.println();

				} else if (ins[1].equals("<=")) {
					numbers.stream().filter(x -> x <= Integer.parseInt(ins[2])).forEach(x -> System.out.print(x + " "));
					System.out.println();

				}

			}
		}
	}
}
