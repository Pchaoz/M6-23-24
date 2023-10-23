package Generics;

public class Moto {

	String matricula;
	String marca;
	String model;
	double llargada;
	
	public Moto(String matricula, String marca, String model, double llargada) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.model = model;
		this.llargada = llargada;
	}

	@Override
	public String toString() {
		return "Moto [matricula=" + matricula + ", marca=" + marca + ", model=" + model + ", llargada=" + llargada
				+ "]";
	}
	
	
	
}
