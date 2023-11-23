package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Joguina")
public class Joguina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "descripcio", length = 100, nullable = false)
	private String descripcio;
	
	@Column(name = "nivellDiversio")
	private int nivellDiversio = 5;
	
	@OneToOne(mappedBy = "joguina", cascade = CascadeType.PERSIST)
	private Tamagotchi tama;
	
	public Joguina( String nom, String descripcio, int nivellDiversio) {
		super();
		this.nom = nom;
		this.descripcio = descripcio;
		this.nivellDiversio = nivellDiversio;
	}

	public Joguina() {
		super();
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

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public int getNivellDiversio() {
		return nivellDiversio;
	}

	public void setNivellDiversio(int nivellDiversio) {
		this.nivellDiversio = nivellDiversio;
	}

	@Override
	public String toString() {
		return "Joguina [id=" + id + ", nom=" + nom + ", descripcio=" + descripcio + ", nivellDiversio="
				+ nivellDiversio + "]";
	}
		
}
