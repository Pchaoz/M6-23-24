package dao;

import models.Joguina;

public class JoguinesDAO extends GenericDAO<Joguina, Integer>{

	public JoguinesDAO() {
		super(Joguina.class);
	}
	
	public void ModificarNivellDiversio(int nouNivell, int id) {
		
		Joguina j = find(id); //BUSQUEM LA JOGUINA
		j.setNivellDiversio(nouNivell); //MODIFIQUEM LA DIVERSIO
		update(j); //LA ACTUALITZEM
	}

}
