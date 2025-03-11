import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tickets = sc.nextLine().split("\\s*,\\s+");
        String regex = "\\${6,}|#{6,}|@{6,}|\\^{6,}";
        Pattern pattern = Pattern.compile(regex);

        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }
            String leftHalf = ticket.substring(0, 10);
            String rightHalf = ticket.substring(10);
            String leftSymbols = " ";
            String rightSymbols = ".";

            Matcher matcher = pattern.matcher(leftHalf);
            if (matcher.find()) leftSymbols = matcher.group();

            matcher = pattern.matcher(rightHalf);
            if (matcher.find()) rightSymbols = matcher.group();

            boolean hasMatch = leftSymbols.charAt(0) == rightSymbols.charAt(0);

            if (!hasMatch) {
                System.out.printf("ticket \"%s\" - no match%n", ticket);

            } else if (leftSymbols.length() + rightSymbols.length() == 20) {
                System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", ticket, 10, leftSymbols.charAt(0));

            } else {
                int matchLength = Math.min(leftSymbols.length(), rightSymbols.length());
                System.out.printf("ticket \"%s\" - %d%c%n", ticket, matchLength, leftSymbols.charAt(0));
            }
        }

        sc.close();
    }
}
