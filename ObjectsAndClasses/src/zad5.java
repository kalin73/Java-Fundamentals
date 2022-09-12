
import java.util.ArrayList;
import java.util.Scanner;

public class zad5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Students> students = new ArrayList<>();

		int count = 0;
		while (true) {

			String[] arr = s.nextLine().split(" ");
			if (arr[0].equals("end")) {
				break;
			}
			String fname = arr[0];
			String lname = arr[1];
			String age = arr[2];
			String htown = arr[3];

			Students std = new Students();
			if (count == 0) {
				std.setFirstName(fname);
				std.setLastName(lname);
				std.setAge(age);
				std.setHomeTown(htown);

				students.add(std);
			} else {
				int index = 0;
				for (Students st : students) {
					if (st.getFirstName().equals(fname) && st.getLastName().equals(lname)) {
						students.remove(index);
						std.setFirstName(fname);
						std.setLastName(lname);
						std.setAge(age);
						std.setHomeTown(htown);

						students.add(std);
					} else {
						std.setFirstName(fname);
						std.setLastName(lname);
						std.setAge(age);
						std.setHomeTown(htown);

						students.add(std);
						break;
					}
					index++;
				}
			}
			count++;
		}
		System.out.println(students.toArray());
		/*String homeTown = s.nextLine();
		for (Students st : students) {
			if (st.getHomeTown().equals(homeTown)) {
				System.out.println(st.getFirstName() + " " + st.getLastName() + " is " + st.getAge() + " years old");
			}
		}*/
		s.close();
	}

}

class Students {
	private String first_name;
	private String last_name;
	private String age;
	private String home_town;

	public void setFirstName(String fname) {
		first_name = fname;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setLastName(String lname) {
		last_name = lname;
	}

	public String getLastName() {
		return last_name;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAge() {
		return age;
	}

	public void setHomeTown(String htown) {
		home_town = htown;
	}

	public String getHomeTown() {
		return home_town;
	}

}