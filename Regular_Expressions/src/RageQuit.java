import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] frequency = new int[266];
        int unique = 0;
        String input = sc.nextLine();
        String regex = "(?<msg>\\D+)(?<count>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            String msg = matcher.group("msg").toUpperCase();
            int count = Integer.parseInt(matcher.group("count"));

            if (count > 0) {
                sb.repeat(msg, count);

                for (char c : msg.toCharArray()) {
                    if (frequency[c] == 0) {
                        frequency[c]++;
                        unique++;
                    }
                }
            }
        }
        System.out.println("Unique symbols used: " + unique);
        System.out.println(sb);

        sc.close();

    }
}
