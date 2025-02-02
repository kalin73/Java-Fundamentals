import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        final String countingRegex = "[starSTAR]";
        final String decryptingRegex = "@(?<name>[a-zA-Z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<type>[AD])![^@\\-!:>]*->(?<count>\\d+)";

        Pattern countingPattern = Pattern.compile(countingRegex);
        Pattern decryptingPattern = Pattern.compile(decryptingRegex);
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        int apCount = 0;
        int dpCount = 0;


        for (int i = 0; i < n; i++) {
            int count = 0;
            String message = sc.nextLine();
            Matcher matcher = countingPattern.matcher(message);
            StringBuilder sb = new StringBuilder();

            while (matcher.find()) {
                count++;
            }

            for (char c : message.toCharArray()) {
                sb.append((char) (c - count));
            }

            matcher = decryptingPattern.matcher(sb.toString());

            while (matcher.find()) {
                String planetName = matcher.group("name");
                String type = matcher.group("type");

                switch (type) {
                    case "A":
                        attackedPlanets.add(planetName);
                        apCount++;
                        break;
                    case "D":
                        destroyedPlanets.add(planetName);
                        dpCount++;
                        break;
                }
            }

        }
        attackedPlanets.sort(Comparator.naturalOrder());
        destroyedPlanets.sort(Comparator.naturalOrder());

        printResult(attackedPlanets, destroyedPlanets, apCount, dpCount);

        sc.close();
    }

    private static void printResult(List<String> attackedPlanets, List<String> destroyedPlanets, int apCount, int dpCount) {
        System.out.println("Attacked planets: " + apCount);
        attackedPlanets.forEach(p -> System.out.println("-> " + p));

        System.out.println("Destroyed planets: " + dpCount);
        destroyedPlanets.forEach(p -> System.out.println("-> " + p));
    }
}
