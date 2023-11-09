package Observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class GenericPropertyChanges {
	
	public PropertyChangeSupport support;
	private String thingToSend = "";

	public GenericPropertyChanges() {
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
	
	public String getTipusAigua()
	{
		return this.thingToSend;
	}
	
	public void setTipusAigua(String tipus)
	{
		support.firePropertyChange("NOMBRE EVENTO", this.getTipusAigua(), "NUEVO VALOR");
		this.thingToSend = tipus;
	}

}
