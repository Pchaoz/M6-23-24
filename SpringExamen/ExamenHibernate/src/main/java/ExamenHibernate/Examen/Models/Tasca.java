package ExamenHibernate.Examen.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table(name="tasca")
public class Tasca {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idtasca;
	
	@Column(name="titol", length = 50)
	String titol;
	
	@Column(name="dedicacio")
	double dedicacio = 0.0;
	
	@Column(name="recompensa")
	int recompensa = 0;
	
	@Column(name="recurs")
	Recurs recurs;
	
	@ManyToMany(mappedBy = "tasques")
	Set<Habitant> habitants = new HashSet<Habitant>();

	public Tasca() {
	}

	public Tasca(String titol, double dedicacio, int recompensa, Recurs recurs) {
		this.titol = titol;
		this.dedicacio = dedicacio;
		this.recompensa = recompensa;
		this.recurs = recurs;
	}

	public int getIdtasca() {
		return idtasca;
	}

	public void setIdtasca(int idtasca) {
		this.idtasca = idtasca;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public double getDedicacio() {
		return dedicacio;
	}

	public void setDedicacio(double dedicacio) {
		this.dedicacio = dedicacio;
	}

	public int getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(int recompensa) {
		this.recompensa = recompensa;
	}
	
	public void AddRecompensa(int suma) {
		this.recompensa += suma;
	}

	public Recurs getRecurs() {
		return recurs;
	}

	public void setRecurs(Recurs recurs) {
		this.recurs = recurs;
	}

	public Set<Habitant> getHabitants() {
		return habitants;
	}

	public void setHabitants(Set<Habitant> habitants) {
		this.habitants = habitants;
	}

	@Override
	public String toString() {
		return "Tasca [idtasca=" + idtasca + ", titol=" + titol + ", dedicacio=" + dedicacio + ", recompensa="
				+ recompensa + ", recurs=" + recurs + ", habitants=" + habitants + "]";
	}
	
	
}
