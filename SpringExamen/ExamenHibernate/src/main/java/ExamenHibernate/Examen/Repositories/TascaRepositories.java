package ExamenHibernate.Examen.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamenHibernate.Examen.Models.Tasca;

public interface TascaRepositories extends JpaRepository<Tasca, Integer>{
	Tasca findByidtasca(int id);
}
