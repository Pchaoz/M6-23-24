package Targetes;

public class Client {
	
	private String name;
	private double salary;
	private Tarjeta tarjeta;
	
	public Client(String n, double s) {
		this.name = n;
		this.salary = s;
		this.tarjeta = null;
	}
	
	public Client(String n, double s, Tarjeta t) {
		this.name = n;
		this.salary = s;
		this.tarjeta = t;
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

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
}
