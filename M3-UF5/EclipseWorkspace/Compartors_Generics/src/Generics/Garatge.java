package Generics;

import java.util.ArrayList;

public class Garatge <T> {
	
	private ArrayList<T> garatge;
	
	public Garatge() {
		garatge = new ArrayList<T>();
	}
	
	public void afegirVehicle(T vehicle) {
		garatge.add(vehicle);
	}
	public void mostrarVehicles() {
		System.out.println(garatge);
	}
}
