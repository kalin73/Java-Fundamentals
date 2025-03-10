import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line;
        Pattern pattern = Pattern.compile("@([A-Za-z]+)[^@\\-!:>]+!([GN])!");

        while (!(line = sc.nextLine()).equals("end")) {
            StringBuilder decrypted = new StringBuilder();
            for (char c : line.toCharArray()) {
                decrypted.append((char) (c - n));
            }
            Matcher matcher = pattern.matcher(decrypted);

            if (matcher.find()) {
                if (matcher.group(2).equals("G")) {
                    System.out.println(matcher.group(1));
                }
            }
        }

        sc.close();
    }
}
