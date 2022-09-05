import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class List_of_Products {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<String> products = createArrayList(sc, n);
		sortArrayList(products);
		int i = 1;
		for (String s : products) {

			System.out.println(i + "." + s);
			i++;
		}
	}

	static ArrayList<String> createArrayList(Scanner sc, int n) {
		ArrayList<String> prod = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			prod.add(sc.nextLine());
		}
		return prod;
	}

	static ArrayList<String> sortArrayList(ArrayList<String> products) {
		Collections.sort(products);
		return products;
	}
}
