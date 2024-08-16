import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final String input = sc.nextLine();
        final String regex = "(?<day>\\d{2})([.\\-/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.print("Day: " + matcher.group("day") + ", ");
            System.out.print("Month: " + matcher.group("month") + ", ");
            System.out.println("Year: " + matcher.group("year"));
        }

    }

}
