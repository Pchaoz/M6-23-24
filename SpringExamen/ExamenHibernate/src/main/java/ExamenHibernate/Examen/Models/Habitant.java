package ExamenHibernate.Examen.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
@Entity
@Table(name="habitant")
public class Habitant {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idhabitant")
	int idhabitant;
	
	@Column(name="nom", length = 35)
	String nom;
	
	@Enumerated(EnumType.STRING)
	@Column(name="especie")
	Especie especie;

	@Column(name="energia")
	int energia = 100;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE}, targetEntity = Tasca.class)
	Set<Tasca> tasques = new HashSet<Tasca>();

	public Habitant() {
	}

	public Habitant(String nom, Especie especie, int energia) {
		this.nom = nom;
		this.especie = especie;
		this.energia = energia;
	}

	public int getIdhabitant() {
		return idhabitant;
	}

	public void setIdhabitant(int idhabitant) {
		this.idhabitant = idhabitant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
	public void AddTasca(Tasca tsk) {
		
		this.tasques.add(tsk);
	}

	public Set<Tasca> getTasques() {
		return tasques;
	}

	public void setTasques(Set<Tasca> tasques) {
		tasques = tasques;
	}

	@Override
	public String toString() {
		return "Habitant [idhabitant=" + idhabitant + ", nom=" + nom + ", especie=" + especie + ", energia=" + energia
				+ ", Tasques=" + tasques + "]";
	}
}
