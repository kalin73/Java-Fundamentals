import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Studentss {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String[] student = sc.nextLine().split(" ");
			students.add(new Student(student[0], student[1], Double.parseDouble(student[2])));

		}

		Collections.sort(students, Comparator.comparingDouble(Student::getGrade));
		Collections.reverse(students);
		students.forEach(x -> System.out.println(x));
		sc.close();
	}

}

class Student {

	String firstName = "";
	String secondName = "";
	double grade = 0;

	public Student(String fName, String sName, double grade) {
		firstName = fName;
		secondName = sName;
		this.grade = grade;

	}

	public String getFname() {
		return firstName;
	}

	public String getSname() {
		return secondName;
	}

	public double getGrade() {
		return grade;
	}

	@Override
	public String toString() {

		return String.format("%s %s: %.2f", getFname(), getSname(), getGrade());
	}

}