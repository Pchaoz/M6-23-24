package Problema1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EnviadorMissatges implements Observable {

	private PropertyChangeSupport support;
	String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public EnviadorMissatges() {
		super();
		this.support = new PropertyChangeSupport(this);
	}
	
	//PARA SUBSCRIBIRSE A LA LISTA O BORRARSE PA ESCUCHAR
	public void addPropertyChangeListener(PropertyChangeListener pcl)
	{
		support.addPropertyChangeListener(pcl);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl)
	{
		support.removePropertyChangeListener(pcl);
	}

	public void sendMessage(String msg) {
		 support.firePropertyChange("a", this.getMsg(), msg);
	}
}
