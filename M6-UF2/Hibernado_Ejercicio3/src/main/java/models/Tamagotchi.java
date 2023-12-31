package models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tamagotchi")

public class Tamagotchi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom", length = 50, nullable = false)
	private String nom;

	@Column(name = "descripcio", length = 50, nullable = false)
	private String descripcio;

	@Column(name = "gana", columnDefinition = "double(6,2)")
	private double gana = 50.00;

	@Column(name = "viu")
	private boolean viu;

	@Column(name = "felicitat")
	private int felicitat = 50;

	@Enumerated(EnumType.STRING)
	@Column(name = "etapa")
	private Etapa etapa;

	@Column(name = "dataNaixement")
	private LocalDateTime dataNaixement;
	
	@ManyToOne
	@JoinColumn(name="id_Aliment")
	private Aliment aliment;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_joguina", unique = true)
	private Joguina joguina;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="TamaAmics", //NOM COLUMNA 
			joinColumns = @JoinColumn(name="id_tama"), //NOM CLAU QUE PORTA EL PES
			inverseJoinColumns = @JoinColumn(name="id_amic") //NOM DE LA CLAU QUE NO PORTA EL PES
	)
	private Set<Tamagotchi> amics = new HashSet<Tamagotchi>();

	public Tamagotchi() {

		this.dataNaixement = LocalDateTime.now();
	}

	public Tamagotchi(String nom, String desc, Etapa et) {

		this.nom = nom;
		this.descripcio = desc;
		this.etapa = et;
		this.dataNaixement = LocalDateTime.now();
		this.viu = true;
	}
	
	public Tamagotchi(int id, String nom, String descripcio, double gana, boolean viu, int felicitat, Etapa etapa,
			LocalDateTime dataNaixement) {
		super();
		this.id = id;
		this.nom = nom;
		this.descripcio = descripcio;
		this.gana = gana;
		this.viu = viu;
		this.felicitat = felicitat;
		this.etapa = etapa;
		this.dataNaixement = dataNaixement;
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

	public double getGana() {
		return gana;
	}

	public void setGana(double gana) {
		this.gana = gana;
	}

	public boolean isViu() {
		return viu;
	}

	public void setViu(boolean viu) {
		this.viu = viu;
	}

	public int getFelicitat() {
		return felicitat;
	}

	public void setFelicitat(int felicitat) {
		this.felicitat = felicitat;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public LocalDateTime getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(LocalDateTime dataNaixement) {
		this.dataNaixement = dataNaixement;
	}
	
	public void agregarAmic (Tamagotchi frien) {
		//FRIEN :>
		this.amics.add(frien);
	}
	
	public Aliment getAliment() {
		return aliment;
	}

	public void setAliment(Aliment aliment) {
		this.aliment = aliment;
	}

	public Joguina getJoguina() {
		return joguina;
	}

	public void setJoguina(Joguina joguina) {
		this.joguina = joguina;
	}

	@Override
	public String toString() {
		String customString = "";
		
		customString = "[Nom: " + this.nom + " Descripccio: " + this.descripcio + 
					" Gana: " + this.gana + " Viu: " + this.viu + " Felicitat: "  + this.felicitat
					+ " Etapa: " + this.etapa + " Data Naixament: " + this.dataNaixement 
					+ " Aliment: " + this.aliment + " Joguina: " + this.joguina + " Amics: ";
		
		Iterator<Tamagotchi> frien = this.amics.iterator(); 
		while (frien.hasNext()) {
			customString = customString + frien.next().getNom() + " ";
		}
		customString = customString + "]";
		
		return customString;
	}

	
	
}

