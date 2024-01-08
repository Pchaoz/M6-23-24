package ExamenHibernate.Examen.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ExamenHibernate.Examen.Models.Habitant;

public interface HabitantRepositories extends JpaRepository<Habitant, Integer>{
	Habitant findByidhabitant(int id);
}
