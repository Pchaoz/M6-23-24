package ExamenHibernate.Examen.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamenHibernate.Examen.Models.Habitant;
import ExamenHibernate.Examen.Models.Tasca;
import ExamenHibernate.Examen.Repositories.HabitantRepositories;

@Service("HabitantService")
public class HabitantService implements IHabitantService {

	@Autowired
	HabitantRepositories hr;
	
	@Override
	public Habitant findByidhabitant(int id) {
		return hr.findByidhabitant(id);
	}

	@Override
	public List<Habitant> getAllHabitants() {
		return hr.findAll();
	}
	
	@Override
	public void GuardarHabitant(Habitant h) {
		hr.save(h);
	}

}
