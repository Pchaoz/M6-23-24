package ExamenHibernate.Examen.Services;

import java.util.List;

import ExamenHibernate.Examen.Models.Tasca;

public interface ITascaService {
	Tasca findByidtasca(int id);
	List<Tasca> getAllTasks();
	void createTask(Tasca t);
}
