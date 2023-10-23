package Problema1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Usuari implements PropertyChangeListener{
	private String username;
	
	public Usuari(String u) {
		this.username = u;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		//SI EL NOMBRE DEL QUE ENVIA EL EVENTO COINCIDE CON EL ESTE MISMO USUARIO ENTONCES LO RECIBE
		if (username.equalsIgnoreCase("nombreprueba")) {
			
		}
		System.out.println(evt.getNewValue());
	}
	
	
	
}
