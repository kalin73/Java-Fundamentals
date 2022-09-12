
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random rn = new Random();
		String[] arr = CreateArray(s);
		shuffleArray(arr);
		
		for(String st:arr) {
			System.out.println(st);
		}
		

	}

	public static String[] CreateArray(Scanner s) {

		String[] inputAsArray = s.nextLine().split(" ");
		return inputAsArray;
	}

	public static String[] shuffleArray(String[] arr) {
		List<String> arrlist = Arrays.asList(arr);
		Collections.shuffle(arrlist);
		arrlist.toArray(arr);
		return arr;
	}

}
