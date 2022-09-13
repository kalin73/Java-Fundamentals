import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehicle_Catalogue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vehicle v = new Vehicle();
		v.createCatalog(sc);
		v.search(sc);
		v.avgHorsepower();

	}

}

class Vehicle {

	private String type = "";
	private String model = "";
	private String color = "";
	private int horsepower = 0;
	List<Vehicle> catalog = new ArrayList<>();

	public Vehicle() {

	}

	public Vehicle(String type, String model, String color, int horsepower) {
		this.type = type;
		this.model = model;
		this.color = color;
		this.horsepower = horsepower;
	}

	public String getType() {
		return type;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void createCatalog(Scanner sc) {

		String[] input = sc.nextLine().split(" ");

		while (!input[0].equals("End")) {
			type = input[0];
			model = input[1];
			color = input[2];
			horsepower = Integer.parseInt(input[3]);
			catalog.add(new Vehicle(type, model, color, horsepower));
			input = sc.nextLine().split(" ");
		}
	}

	public void search(Scanner sc) {

		String input = sc.nextLine();
		while (!input.equals("Close the Catalogue")) {
			for (Vehicle v : catalog) {

				if (v.getModel().equals(input)) {
					System.out.println("Type: " + v.getType().substring(0, 1).toUpperCase() + v.getType().substring(1));
					System.out.println("Model: " + v.getModel());
					System.out.println("Color: " + v.getColor());
					System.out.println("Horsepower: " + v.getHorsepower());
				}

			}

			input = sc.nextLine();
		}
	}

	public void avgHorsepower() {

		double avgCar = 0;
		int countCars = 0;
		double avgTruck = 0;
		int countTrucks = 0;
		for (Vehicle v : catalog) {
			if (v.getType().equals("car")) {
				avgCar += v.getHorsepower();
				countCars++;
			} else {
				avgTruck += v.getHorsepower();
				countTrucks++;
			}
		}
		if (countCars > 0) {
			avgCar /= countCars;
		} else {
			countCars = 1;
		}
		if (countTrucks > 0) {
			avgTruck /= countTrucks;
		} else {
			countTrucks = 1;
		}
		System.out.printf("Cars have average horsepower of: %.2f.%n", avgCar);
		System.out.printf("Trucks have average horsepower of: %.2f.", avgTruck);

	}

}