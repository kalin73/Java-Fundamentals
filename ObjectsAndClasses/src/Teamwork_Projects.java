import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Teamwork_Projects {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Team tm = new Team();
		List<Team> teams = tm.creatingTeams(sc);
		tm.addMembers(sc, teams);
		tm.print(teams);

	}

}

class Team {
	private String creatorName = "";
	private String teamName = "";
	List<String> members = new ArrayList<>();

	public Team() {

	}

	public Team(String creatorName, String teamName, List<String> members) {
		this.creatorName = creatorName;
		this.teamName = teamName;
		this.members = members;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public String getTeamName() {
		return teamName;
	}

	public List<String> getMembers() {
		return members;
	}

	public List<Team> creatingTeams(Scanner sc) {
		List<Team> team = new ArrayList<>();
		int n = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n; i++) {
			boolean creatorExist = false;
			boolean teamExist = false;
			String[] input = sc.nextLine().split("-");
			String creatorName = input[0];
			String teamName = input[1];
			for (Team t : team) {
				if (t.getCreatorName().equals(creatorName)) {
					creatorExist = true;
					break;
				}
				if (t.getTeamName().equals(teamName)) {
					teamExist = true;
					break;
				}
			}
			if (creatorExist) {
				System.out.printf("%s cannot create another team!%n", creatorName);

			} else if (teamExist) {

				System.out.printf("Team %s was already created!%n", teamName);
			} else {

				team.add(new Team(creatorName, teamName, new ArrayList<>()));
				System.out.printf("Team %s has been created by %s!%n", teamName, creatorName);

			}
		}
		return team;
	}

	public void addMembers(Scanner sc, List<Team> teams) {
		String[] input = sc.nextLine().split("->");

		while (!input[0].equals("end of assignment")) {
			boolean teamExist = false;
			boolean memberExist = false;
			String member = input[0];
			String team = input[1];

			for (Team t : teams) {
				if (t.getTeamName().equals(team)) {
					teamExist = true;

				}
				if (t.getCreatorName().equals(member) || t.getMembers().contains(member)) {
					memberExist = true;

				}
			}
			if (!teamExist) {
				System.out.printf("Team %s does not exist!%n", team);

			} else if (memberExist) {

				System.out.printf("Member %s cannot join team %s!%n", member, team);
			} else {

				for (Team t : teams) {

					if (t.getTeamName().equals(team)) {
						t.getMembers().add(member);
					}
				}
			}
			input = sc.nextLine().split("->");
		}
	}

	public void print(List<Team> teams) {
		Collections.sort(teams, Comparator.comparing(Team::getTeamName));
		Collections.sort(teams, new Sorting());
		String disbanded = "";
		for (Team x : teams) {
			if (x.getMembers().size() > 0) {
				Collections.sort(x.getMembers());
				System.out.println(x.getTeamName());
				System.out.println("- " + x.getCreatorName());

				for (String st : x.getMembers()) {
					System.out.println("-- " + st);
				}
			} else {
				disbanded += x.getTeamName() + "\n";
			}
		}
		System.out.println("Teams to disband:\n" + disbanded);

	}

}

class Sorting implements Comparator<Team> {
	@Override
	public int compare(Team o1, Team o2) {
		if (o2.getMembers().size() > o1.getMembers().size()) {
			return 1;
		} else if (o2.getMembers().size() < o1.getMembers().size()) {
			return -1;
		} else {
			return 0;
		}
	}
}