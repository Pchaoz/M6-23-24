package Generics2;

import java.util.ArrayList;
import java.util.List;

public class Garatge <T extends Vehicle> {
	
	private List<T> garatge = new ArrayList<T>();
	
	public Garatge() {	}
	
	public void afegirVehicle(T vehicle) {
		garatge.add(vehicle);
	}
	public void mostrarVehicles() {
		for (T t : garatge) {
			System.out.println("TIPUS VEHICLE: " + t.getClass() + " INFORMACIO: " + t.toString());
		}
	}
}
