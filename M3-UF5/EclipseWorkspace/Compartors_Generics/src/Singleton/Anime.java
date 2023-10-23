package Singleton;

public class Anime {

	private String nom;
	private int anyEstrena;
	private double mitjanaDuracio;
	
	
	public Anime(String n, int ry, double cl) {
		this.nom = n;
		this.anyEstrena = ry;
		this.mitjanaDuracio = cl;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getAnyEstrena() {
		return anyEstrena;
	}


	public void setAnyEstrena(int anyEstrena) {
		this.anyEstrena = anyEstrena;
	}


	public double getMitjanaDuracio() {
		return mitjanaDuracio;
	}


	public void setMitjanaDuracio(double mitjanaDuracio) {
		this.mitjanaDuracio = mitjanaDuracio;
	}


	@Override
	public String toString() {
		return "Anime [nom=" + nom + ", anyEstrena=" + anyEstrena + ", mitjanaDuracio=" + mitjanaDuracio + "]";
	}
	
	
}
