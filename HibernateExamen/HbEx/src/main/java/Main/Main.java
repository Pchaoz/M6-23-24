package Main;

import java.util.Set;

import DAO.DAOHabitant;
import DAO.DAOTasca;
import Models.Especie;
import Models.Habitant;
import Models.Recurs;
import Models.Tasca;

public class Main {

	public static void main(String[] args) {

		DAOTasca tascaDAO = new DAOTasca();
		DAOHabitant habitantDAO = new DAOHabitant();
		
		Habitant h1 = new Habitant("Pol", Especie.human, 30);
		Habitant h2 = new Habitant("Xavi", Especie.furry, 2);
		Habitant h3 = new Habitant("Gerard", Especie.reptilian, 4);
		Habitant h4 = new  Habitant("Pau", Especie.human, 33);
		Habitant h5 = new Habitant("Guillem", Especie.reptilian, 60);
		
		Tasca t1 = new Tasca("Ganar a SKT T1", 30, 500, Recurs.materials);
		Tasca t2 = new Tasca("Bombardear la renfe", 999, 999, Recurs.tools);
		Tasca t3 = new Tasca("Aprobar el examen", 77, 99, Recurs.food);
		Tasca t4 = new Tasca("Ponerse al dia de One Piece", 50, 50, Recurs.materials);
		Tasca t5 = new Tasca("Tener un buen horario de sueno", 20, 20, Recurs.food);
		
		habitantDAO.Persistir(h1);
		habitantDAO.Persistir(h2);
		habitantDAO.Persistir(h4);
		habitantDAO.Persistir(h3);
		habitantDAO.Persistir(h5);
		
		h1.AddTasca(t2);
		h1.AddTasca(t3);
		h2.AddTasca(t5);
		h3.AddTasca(t5);
		h4.AddTasca(t2);	
		h5.AddTasca(t1);
		
		habitantDAO.update(h1);
		habitantDAO.update(h2);
		habitantDAO.update(h3);
		habitantDAO.update(h4);
		habitantDAO.update(h5);
		
		habitantDAO.PrintAllUserTasks();
		
		tascaDAO.SetInitialReward(t5);
		tascaDAO.SetInitialReward(t5);
		
		/*
		Set<Tasca> tl = habitantDAO.GetTasksById(1);
		Habitant htask = habitantDAO.Search(1);
		
		System.out.println("El habitant " + htask.getNom() + " te les seguents tasques:");
		for (Tasca tasca : tl) {
			System.out.println(tasca.getTitol());
		}
		*/
	}

}
