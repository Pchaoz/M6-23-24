package Generics2;

public class Bicicleta implements Vehicle {

	String nomPropietari;
	String marca;
	String model;
	double llarg;
	
	public Bicicleta(String nomPropietari, String marca, String model, double llarg) {
		super();
		this.nomPropietari = nomPropietari;
		this.marca = marca;
		this.model = model;
		this.llarg = llarg;
	}

	@Override
	public String toString() {
		return "Bicicleta [nomPropietari=" + nomPropietari + ", marca=" + marca + ", model=" + model + ", llarg="
				+ llarg + "]";
	}
}
