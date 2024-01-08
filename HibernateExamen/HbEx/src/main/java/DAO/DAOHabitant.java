package DAO;

import java.util.List;
import java.util.Set;

import Models.Habitant;
import Models.Tasca;

public class DAOHabitant extends DAOGeneric<Habitant, Integer>{

	public DAOHabitant() {
		super(Habitant.class);
	}
	
	public void PrintAllUserTasks() {
		List<Habitant> lh = Llistar();
		
		for(int i =0; i < lh.size(); i++) {
			Set<Tasca> tl = GetTasksById(lh.get(i).getIdhabitant());
			
			System.out.println("El habitant " + lh.get(i).getNom() + " te les seguents tasques:");
			for (Tasca tasca : tl) {
				System.out.println(tasca.getTitol());
			}
		}
	}
	
	public Set<Tasca> GetTasksById (int id) {
		Habitant h = Search(id);
		return h.getTasques();
	}

}
