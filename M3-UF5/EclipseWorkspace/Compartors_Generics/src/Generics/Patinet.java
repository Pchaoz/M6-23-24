package Generics;

public class Patinet {

	String nomPropietari;
	String marca;
	String model;
	int potencia;

	public Patinet(String nomPropietari, String marca, String model, int potencia) {
		super();
		this.nomPropietari = nomPropietari;
		this.marca = marca;
		this.model = model;
		this.potencia = potencia;
	}
	
	@Override
	public String toString() {
		return "Patinet [nomPropietari=" + nomPropietari + ", marca=" + marca + ", model=" + model + ", potencia="
				+ potencia + "]";
	}	
	
}
