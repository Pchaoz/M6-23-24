package ExamenHibernate.Examen.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExamenHibernate.Examen.Models.Tasca;
import ExamenHibernate.Examen.Repositories.TascaRepositories;

@Service("TascaService")
public class TascaService implements ITascaService {

	@Autowired
	TascaRepositories tr;
	
	@Override
	public Tasca findByidtasca(int id) {
		return tr.findByidtasca(id);
	}

	@Override
	public List<Tasca> getAllTasks() {
		return tr.findAll();
	}

	@Override
	public void createTask(Tasca t) {
		tr.save(t);
	}

	
}
