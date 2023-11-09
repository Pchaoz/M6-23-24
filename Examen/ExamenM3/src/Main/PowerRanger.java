package Main;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PowerRanger implements PropertyChangeListener, HeroiEquipat {
	String nom;
	String nomMecha;
	Color color;
	double poder;
	
	public PowerRanger(String nom, String nomMecha, Color color, double poder) {
		super();
		this.nom = nom;
		this.nomMecha = nomMecha;
		this.color = color;
		this.poder = poder;
	}

	@Override
	public String toString() {
		return "PowerRanger [nom=" + nom + ", nomMecha=" + nomMecha + ", color=" + color + ", poder=" + poder + "]";
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		if (evt.getPropertyName().equals("Generated")) {
			PowerRanger nemesis = (PowerRanger) evt.getNewValue();
			if (nemesis.nom.equals(this.nom)) {
				Enemic ene = (Enemic) evt.getOldValue();
				ene.addPropertyChangeListener(this);
				System.out.println("SOC " + this.nom + " Y VIGILO A " + ene.nom);
			}
		}else if (evt.getPropertyName().equals("atk")) {
			System.out.println(evt.getNewValue());
			System.out.println(this.nom + ": Oh no! ens ataquen");
		}
	}

	@Override
	public String equipar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getPoder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPoder(double poder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNomMecha() {
		// TODO Auto-generated method stub
		return null;
	}
}
