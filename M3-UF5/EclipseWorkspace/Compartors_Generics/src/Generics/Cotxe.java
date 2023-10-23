package Generics;

public class Cotxe  {
	
	String matricula;
	String marca;
	String model;
	double amplada;
	double llargada;
	
	public Cotxe(String matricula, String marca, String model, double amplada, double llargada) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.model = model;
		this.amplada = amplada;
		this.llargada = llargada;
	}

	@Override
	public String toString() {
		return "Cotxe [matricula=" + matricula + ", marca=" + marca + ", model=" + model + ", amplada=" + amplada
				+ ", llargada=" + llargada + "]";
	}
		
}
