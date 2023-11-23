package dao;

import models.Joguina;
import models.Tamagotchi;

public class TamagotchiDAO extends GenericDAO<Tamagotchi, Integer>{

	public TamagotchiDAO() {
		super(Tamagotchi.class);
	}
	
	public void EquiparJoguina (Joguina j, int id) {
		Tamagotchi t = find(id);
		t.setJoguina(j);
		update(t);
	}
}
