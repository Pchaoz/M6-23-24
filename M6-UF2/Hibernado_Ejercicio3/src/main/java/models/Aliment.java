package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Aliments")
public class Aliment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nom", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "descripcio", length = 50, nullable = false)
	private String descripció;
	
	@Column(name = "gana", columnDefinition = "double(6,2)")
	private double valorNutricional = 10.00;
	
	@OneToMany(mappedBy = "aliment")
	private Set<Tamagotchi> tamaList = new HashSet<Tamagotchi>();

	public Aliment(String n, String des, double valor) {

		this.nom = n;
		this.descripció = des;
		this.valorNutricional = valor;
	}

	public Aliment() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescripció() {
		return descripció;
	}

	public void setDescripció(String descripció) {
		this.descripció = descripció;
	}

	public double getValorNutricional() {
		return valorNutricional;
	}

	public void setValorNutricional(int valorNutricional) {
		this.valorNutricional = valorNutricional;
	}

	@Override
	public String toString() {
		return "Aliment [id=" + id + ", nom=" + nom + ", descripció=" + descripció + ", valorNutricional="
				+ valorNutricional + "]";
	}

}
