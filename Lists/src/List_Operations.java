import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class List_Operations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = createList(sc);
		operations(arr, sc);
		arr.forEach(x -> System.out.print(x + " "));
	}

	static ArrayList<Integer> createList(Scanner sc) {
		ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(sc.nextLine().split(" "))
				.map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		return list;
	}

	static void operations(ArrayList<Integer> ar, Scanner sc) {
		boolean invalid = false;
		while (true) {
			String[] arr = sc.nextLine().split(" ");

			if (arr[0].equals("End")) {
				break;
			}

			switch (arr[0]) {

			case "Add":
				ar.add(Integer.parseInt(arr[1]));
				break;

			case "Insert":
				if (Integer.parseInt(arr[2]) >= ar.size() || Integer.parseInt(arr[2]) < 0) {
					System.out.println("Invalid index");
					break;

				} else {
					ar.add(Integer.parseInt(arr[2]), Integer.parseInt(arr[1]));
					break;
				}
			case "Remove":
				if (Integer.parseInt(arr[1]) >= ar.size() || Integer.parseInt(arr[1]) < 0) {
					System.out.println("Invalid index");
					break;

				} else {
					ar.remove(Integer.parseInt(arr[1]));
					break;
				}
			case "Shift":
				if (arr[1].equals("left")) {
					for (int i = 0; i < Integer.parseInt(arr[2]); i++) {
						ar.add(ar.get(0));
						ar.remove(0);

					}
					break;
				} else if (arr[1].equals("right")) {

					for (int i = 0; i < Integer.parseInt(arr[2]); i++) {
						int n = ar.get(ar.size() - 1);

						ar.remove(ar.get(ar.size() - 1));
						ar.add(0, n);
					}
					break;
				}

			}
		}

		if (invalid) {
			System.out.println("Invalid index");
		}
	}
}
