package ExamenHibernate.Examen.Services;

import java.util.List;

import ExamenHibernate.Examen.Models.Habitant;
import ExamenHibernate.Examen.Models.Tasca;

public interface IHabitantService {
	Habitant findByidhabitant(int id);
	List<Habitant> getAllHabitants();
	void GuardarHabitant(Habitant h);
}
