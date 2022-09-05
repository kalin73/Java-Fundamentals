import java.util.*;


public class proj {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			currSum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (currSum > maxSum) {
					maxSum = currSum;
				}
				currSum += arr[j];
				
			}
			if (currSum > maxSum ) {
				maxSum = currSum;
			}

		}
		if(-1>-2) {
		System.out.println("yes");
		}
		System.out.println(maxSum);
		sc.close();

		// List<Integer> arr = Arrays.stream(sc.nextLine().split(" ")).map(x ->
		// Integer.parseInt(x)).toList();
		/*
		 * ArrayList<Integer> arrList = (ArrayList<Integer>)
		 * Arrays.stream(sc.nextLine().split(" ")) .map(x ->
		 * Integer.parseInt(x)).collect(Collectors.toList()); arrList.stream().sorted();
		 * arrList.sort(null);
		 */
		// System.out.println(arr);
		// System.out.println(arrList);

	}

}
