import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split("\\|");
        final String capital = "([#$%*&])([A-Z]+)\\1";
        Pattern pattern = Pattern.compile(capital);
        Matcher matcher = pattern.matcher(data[0]);
        String letters = "";

        if (matcher.find()) {
            letters = matcher.group(2);
        }

        for (char c : letters.toCharArray()) {
            String regex = "%d:(\\d{2})".formatted((int) c);
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(data[1]);
            int len = -1;

            if (matcher.find()) len = Integer.parseInt(matcher.group(1));

            pattern = Pattern.compile(" %c[^\\s]{%d}\\b".formatted(c, len));
            matcher = pattern.matcher(" " + data[2]);

            if (matcher.find()) System.out.println(matcher.group().trim());
        }

        sc.close();
    }
}
