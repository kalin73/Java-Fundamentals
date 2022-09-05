import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sum_Adjacent_Equal_Numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Double> numbers = createArrayList(sc);
	
		
		for (int i = 0; i < numbers.size() - 1; i++) {
			if (Double.compare( numbers.get(i), numbers.get(i + 1))==0) {
				numbers.set(i,numbers.get(i)+numbers.get(i+1));
				numbers.remove(i+1);
				i=-1;
			}
		}
		for(Double d:numbers ) {
			System.out.print(new DecimalFormat("0.#").format(d)+" ");
		}
	}

	public static List<Double> createArrayList(Scanner s) {
		List<Double> numbers = Arrays.stream(s.nextLine().split(" ")).map(x->Double.parseDouble(x))
				.collect(Collectors.toList());
		return numbers;

	}
}
