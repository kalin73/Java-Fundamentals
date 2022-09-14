import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Company_Roster {

	public static void main(String[] args) {
		Employee emp = new Employee();

		emp.createRoaster();
		emp.print();
	}

}

class Employee {
	Scanner sc = new Scanner(System.in);
	private String name = "";
	private double salary = 0.0;
	private String position = "";
	private String department = "";
	private String email = "";
	private int age = 0;

	List<Employee> roster = new ArrayList<>();
	Map<String, List<Double>> dep = new HashMap<>();
	Map<String, Double> map = new HashMap<>();

	public Employee(String name, double salary, String position, String department, String email, int age) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.department = department;
		this.email = email;
		this.age = age;
	}

	public Employee() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	void createRoaster() {
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<String> input = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			input = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
			String name = input.get(0);
			double salary = Double.parseDouble(input.get(1));
			String position = input.get(2);
			String depart = input.get(3);
			String email = "";
			int age = 0;
			if (input.size() < 5) {
				email = "n/a";
				age = -1;

			} else if (input.size() == 5) {
				if (Character.isAlphabetic(input.get(4).charAt(0))) {
					age = -1;
					email = input.get(4);

				} else {
					age = Integer.parseInt(input.get(4));
					email = "n/a";

				}

			} else {
				email = input.get(4);
				age = Integer.parseInt(input.get(5));

			}
			roster.add(new Employee(name, salary, position, depart, email, age));
			List<Double> salaries = dep.get(depart);
			if (salaries == null) {
				salaries = new ArrayList<>();
				salaries.add(salary);
				dep.putIfAbsent(depart, salaries);
			} else {
				salaries.add(salary);
				dep.put(depart, salaries);
			}

		}

	}

	@Override
	public String toString() {

		return String.format("%s %.2f %s %s", getName(), getSalary(), getEmail(), getAge());
	}

	void print() {
		dep.forEach((key, value) -> {
			double size = dep.get(key).size();
			double sum = dep.get(key).stream().reduce(0.0, (a, b) -> {
				return a + b;
			});

			map.put(key, sum / size);

		});

		Map.Entry<String, Double> entry = map.entrySet().stream()
				.sorted((f, s) -> Double.compare(s.getValue(), f.getValue())).findFirst().get();
		String key = entry.getKey();

		Collections.sort(roster, Comparator.comparingDouble(Employee::getSalary));
		Collections.reverse(roster);
		System.out.println("Highest Average Salary: " + key);
		roster.forEach(x -> {

			if (x.getDepartment().equals(key)) {

				System.out.println(x);
			}

		});

	}

}