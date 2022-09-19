import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Car_Salesman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Engines eng = new Engines();
		Cars cr = new Cars();
		int m = Integer.parseInt(sc.nextLine());
		eng.addEngines(m, sc);
		int n = Integer.parseInt(sc.nextLine());
		List<Engines> engines = eng.getEngines();
		cr.addCars(n, sc, engines);
		cr.print();
	}

}

class Cars {

	Engines eng = new Engines();
	String model;
	String weight;
	String color;
	List<Cars> cars = new ArrayList<>();

	public Cars(String model, Engines eng, String weight, String color) {
		this.model = model;
		this.eng = eng;
		this.weight = weight;
		this.color = color;
	}

	public Cars() {

	}

	public String getModel() {
		return model;
	}

	public String getWeight() {
		return weight;
	}

	public String getColor() {
		return color;
	}

	public Engines getEng() {
		return eng;
	}

	public void addCars(int n, Scanner sc, List<Engines> engine) {

		for (int i = 0; i < n; i++) {
			Engines engs = new Engines();
			String[] input = sc.nextLine().split(" ");
			String model = input[0];
			String weight = "";
			String color = "";
			for (Engines en : engine) {
				if (en.getModel().equals(input[1])) {
					engs = en;
				}
			}
			if (input.length < 3) {
				color = "n/a";
				weight = "n/a";

			} else if (input.length == 3) {
				if (Character.isDigit(input[2].charAt(0))) {
					weight = input[2];
					color = "n/a";

				} else if (!Character.isDigit(input[2].charAt(0))) {
					color = input[2];
					weight = "n/a";
				}

			} else {
				weight = input[2];
				color = input[3];
			}
			cars.add(new Cars(model, engs, weight, color));

		}
	}

	public void print() {

		cars.forEach(x -> {

			System.out.println(x.getModel() + ":");
			System.out.println("  " + x.getEng().getModel()+":");
			System.out.println("    Power: " + x.getEng().getPower());
			System.out.println("    Displacement: " + x.getEng().getDisplacements());
			System.out.println("    Efficiency: " + x.getEng().getEfficiency());
			System.out.println("  Weight: " + x.getWeight());
			System.out.println("  Color: " + x.getColor());

		});

	}

}

class Engines {

	String model;
	String power;
	String displacements;
	String efficiency;
	List<Engines> engines = new ArrayList<>();

	public String getModel() {
		return model;
	}

	public String getPower() {
		return power;
	}

	public String getDisplacements() {
		return displacements;
	}

	public String getEfficiency() {
		return efficiency;
	}

	public Engines(String model, String power, String displacements, String efficiency) {
		this.model = model;
		this.power = power;
		this.displacements = displacements;
		this.efficiency = efficiency;
	}

	public Engines() {

	}

	public void addEngines(int n, Scanner sc) {

		for (int i = 0; i < n; i++) {
			List<String> input = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
			String model = input.get(0);
			String power = input.get(1);
			String displacements = "";
			String efficiency = "";
			if (input.size() < 3) {
				displacements = "n/a";
				efficiency = "n/a";
			} else if (input.size() == 3) {

				if (Character.isDigit(input.get(2).charAt(0))) {
					displacements = input.get(2);
					efficiency = "n/a";

				} else if (!Character.isDigit(input.get(2).charAt(0))) {

					displacements = "n/a";
					efficiency = input.get(2);
				}
			} else {
				displacements = input.get(2);
				efficiency = input.get(3);
			}
			engines.add(new Engines(model, power, displacements, efficiency));
		}

	}

	public List<Engines> getEngines() {
		return engines;
	}
}