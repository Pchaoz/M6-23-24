package DAO;

import Models.Tasca;

public class DAOTasca extends DAOGeneric<Tasca, Integer>{

	public DAOTasca() {
		super(Tasca.class);
	}
	
	public void SetInitialReward(Tasca tsk) {
		
		if (tsk.getDedicacio() > 85.0) {
			tsk.AddRecompensa(55);
		}else {
			tsk.AddRecompensa(30);
		}
		System.out.println("LA RECOMPENSA HA ASCENDIDO DE " + tsk.getTitol() + " A: " + tsk.getRecompensa());
		update(tsk);
	}

}
