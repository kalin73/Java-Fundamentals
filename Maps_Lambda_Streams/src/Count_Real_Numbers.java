import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Count_Real_Numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToDouble(x -> Double.parseDouble(x)).toArray();
		Map<Double, Integer> numb = new TreeMap<>();
		for (int i = 0; i < numbers.length; i++) {

			if (numb.containsKey(numbers[i])) {

				numb.put(numbers[i], numb.get(numbers[i]) + 1);

			} else {
				numb.put(numbers[i], 1);
			}
		}
		for (Map.Entry<Double, Integer> n : numb.entrySet()) {
			DecimalFormat df = new DecimalFormat("#.#######");
			System.out.printf("%s -> %d\n", df.format(n.getKey()), n.getValue());

		}
		sc.close();
	}

}
