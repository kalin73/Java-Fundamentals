import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Word_Filter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<String> words = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());

		List<String> evenLength = words.stream().filter(x -> x.length() % 2 == 0).collect(Collectors.toList());
		evenLength.forEach(x -> System.out.println(x));

		sc.close();
	}

}
