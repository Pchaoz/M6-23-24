package Main;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Enemic {
	String nom;
	PowerRanger nemesis;
	
	
	public Enemic(String nom, PowerRanger nemesis) {
		super();
		this.nom = nom;
		this.nemesis = nemesis;
		this.support = new PropertyChangeSupport(this);
	}
	public void Atacar() {
		this.support.firePropertyChange("atk" ,null , "SOC " + this.nom + " Y ATACO" );
	}
	@Override
	public String toString() {
		return "Enemic [nom=" + nom + ", nemesis=" + nemesis + "]";
	}
	
	public PropertyChangeSupport support;
	
	public void addPropertyChangeListener(PropertyChangeListener pcl)
	{
		support.addPropertyChangeListener(pcl);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl)
	{
		support.removePropertyChangeListener(pcl);
	}
}
