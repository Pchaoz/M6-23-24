package dao;

import java.util.Set;

import models.Aliment;
import models.Tamagotchi;

public class AlimentsDAO extends GenericDAO<Aliment, Integer>{

	public AlimentsDAO() {
		super(Aliment.class);
	}
	
	public Set<Tamagotchi> ListTamaByFood(Aliment a) {
		
		Set<Tamagotchi> tamawithfood = a.getTamaList();
		return tamawithfood;
	}

	public void ModificarValorNutricional (int newValue, int id) {
		Aliment a = find(id);
		a.setValorNutricional(newValue);
	}
}
