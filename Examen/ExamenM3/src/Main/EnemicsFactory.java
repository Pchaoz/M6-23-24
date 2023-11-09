package Main;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EnemicsFactory {

	public Enemic GenerarEnemic (TipusEnemic t, String nom, PowerRanger nemesis) {
		Enemic ene;
		if (t == TipusEnemic.RitaRepulsa) {
			ene = new RitaRepulsa(nom, nemesis);
			GeneratEnemic(ene, nemesis);
			return ene;
		}else if (t == TipusEnemic.LordZedd) {
			ene =  new LordZedd(nom, nemesis);
			GeneratEnemic(ene, nemesis);
			return ene;
		}
		return null;
	}
	
	public PropertyChangeSupport support;

	public EnemicsFactory() {
		super();
		this.support = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl)
	{
		support.addPropertyChangeListener(pcl);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl)
	{
		support.removePropertyChangeListener(pcl);
	}
	
	public void GeneratEnemic(Enemic ene, PowerRanger nemesis)
	{
		support.firePropertyChange("Generated", ene, nemesis);
	}
}
