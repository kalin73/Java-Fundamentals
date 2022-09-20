import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Raw_Data {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Car cr = new Car();
		List<Car> cars = cr.addCar(sc);
		cr.info(sc, cars);
		sc.close();
	}

}

class Car {
	Scanner sc = new Scanner(System.in);
	Engine en = new Engine();
	Tyres tr = new Tyres();
	Cargo cr = new Cargo();
	String model = "";

	public Car(String model, Engine en, Tyres tr, Cargo cr) {
		this.en = en;
		this.tr = tr;
		this.cr = cr;
		this.model = model;
	}

	public Car() {

	}

	public String getTyrePresure() {

		return tr.getAvgPresure();
	}

	public double getEnginePower() {
		return en.getPower();

	}

	public String carType() {
		return cr.getType();
	}

	public List<Car> addCar(Scanner sc) {
		int n = Integer.parseInt(sc.nextLine());
		List<Car> cars = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] car = sc.nextLine().split(" ");
			String model = car[0];
			int speed = Integer.parseInt(car[1]);
			int power = Integer.parseInt(car[2]);
			int weight = Integer.parseInt(car[3]);
			String cargoType = car[4];
			double tyre1Presure = Double.parseDouble(car[5]);
			int tyre1Age = Integer.parseInt(car[6]);
			double tyre2Presure = Double.parseDouble(car[7]);
			int tyre2Age = Integer.parseInt(car[8]);
			double tyre3Presure = Double.parseDouble(car[9]);
			int tyre3Age = Integer.parseInt(car[10]);
			double tyre4Presure = Double.parseDouble(car[11]);
			int tyre4Age = Integer.parseInt(car[12]);
			Engine eng = new Engine(speed, power);
			Tyres tyr = new Tyres(tyre1Presure, tyre1Age, tyre2Presure, tyre2Age, tyre3Presure, tyre3Age, tyre4Presure,
					tyre4Age);
			Cargo crg = new Cargo(weight, cargoType);

			cars.add(new Car(model, eng, tyr, crg));

		}
		return cars;
	}

	public String getModel() {
		return model;
	}

	public void info(Scanner sc, List<Car> cars) {

		String cargoType = sc.nextLine();
		List<Car> vehicles = cars;
		if ("fragile".equals(cargoType)) {

			vehicles.stream().filter(x -> x.carType().equals("fragile"))
					.filter(x -> x.getTyrePresure().equals("fragile")).forEach(x -> System.out.println(x.getModel()));

		} else {

			vehicles.stream().filter(x -> x.carType().equals("flamable")).filter(x -> x.getEnginePower() > 250)
					.forEach(x -> System.out.println(x.getModel()));

		}

	}

}

class Engine {
	private int speed = 0;
	private int power = 0;

	public Engine() {

	}

	public Engine(int speed, int power) {
		this.speed = speed;
		this.power = power;
	}

	public int getSpeed() {
		return speed;
	}

	public int getPower() {
		return power;
	}

}

class Tyres {
	private double tire1Pressure = 0.0;

	private int tire1Age = 0;
	private double tire2Pressure = 0.0;
	private int tire2Age = 0;
	private double tire3Pressure = 0.0;
	private int tire3Age = 0;
	private double tire4Pressure = 0.0;
	private int tire4Age = 0;
	List<Double> tyrePresures = new ArrayList<>();

	public Tyres(double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age, double tire3Pressure,
			int tire3Age, double tire4Pressure, int tire4Age) {
		this.tire1Pressure = tire1Pressure;
		this.tire1Age = tire1Age;
		this.tire2Pressure = tire2Pressure;
		this.tire2Age = tire2Age;
		this.tire3Pressure = tire3Pressure;
		this.tire3Age = tire3Age;
		this.tire4Pressure = tire4Pressure;
		this.tire4Age = tire4Age;
	}

	public Tyres() {

	}

	public String getAvgPresure() {
		tyrePresures.add(tire1Pressure);
		tyrePresures.add(tire2Pressure);
		tyrePresures.add(tire3Pressure);
		tyrePresures.add(tire4Pressure);
		String type = "";
		for (Double d : tyrePresures) {
			if (d < 1) {
				type = "fragile";
				break;
			} else {
				type = "no";
			}
		}

		return type;
	}

	public int getTire1Age() {
		return tire1Age;
	}

	public int getTire2Age() {
		return tire2Age;
	}

	public int getTire3Age() {
		return tire3Age;
	}

	public int getTire4Age() {
		return tire4Age;
	}
}

class Cargo {

	private int weight = 0;
	private String type = "";

	public Cargo(int weight, String type) {
		this.weight = weight;
		this.type = type;
	}

	public Cargo() {

	}

	public int getWeight() {
		return weight;
	}

	public String getType() {
		return type;
	}

}