import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class zad19 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int length = 1;
		int max = 0;
		int index = 0;
		for (int i = 0; i < nums.length - 1; i++) {

			if (nums[i] < nums[i + 1]) {
				length++;

			} else {
				if (length > max) {
					max = length;
					index = i;
					length = 1;
				}
			}

		}
		int[] result = Arrays.copyOfRange(nums, index - (max - 1), index + 1);
		for (int i : result) {
			System.out.println(i + " ");
		}

	}

}
