import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Change_List {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> numbers = createList(sc);
		moderateArray(numbers, sc);
		numbers.forEach(x -> System.out.print(x + " "));

	}

	static List<Integer> createList(Scanner sc) {
		List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).map(x -> Integer.parseInt(x))
				.collect(Collectors.toList());
		return list;
	}

	static void moderateArray(List<Integer> l, Scanner sc) {
		while (true) {
			
			String[] arr = sc.nextLine().split(" ");
			
			if (arr[0].equals("end")) {
				break;
			} else if (arr[0].equals("Delete")) {
				l.removeAll(Arrays.asList(Integer.parseInt(arr[1])));
			} else {
				l.add(Integer.parseInt(arr[2]), Integer.parseInt(arr[1]));
			}
		}
	}
}
