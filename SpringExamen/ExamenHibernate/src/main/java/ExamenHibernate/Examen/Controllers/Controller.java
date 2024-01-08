package ExamenHibernate.Examen.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ExamenHibernate.Examen.Models.Especie;
import ExamenHibernate.Examen.Models.Habitant;
import ExamenHibernate.Examen.Models.Recurs;
import ExamenHibernate.Examen.Models.Tasca;
import ExamenHibernate.Examen.Services.HabitantService;
import ExamenHibernate.Examen.Services.TascaService;

@RestController
public class Controller {

	@Autowired
	HabitantService hs;
	
	@Autowired
	TascaService ts;
	
	@GetMapping(path="/")
	public String noMeHeOlvidadoDeLaRaiz() {
		return "Spring funcionant";
	}
	
	@GetMapping(path="/createHabitant")
	public String createHabitant(@RequestParam String nom, @RequestParam String tipus, @RequestParam int energia) {
		Especie e = null;
		
		if (tipus.equalsIgnoreCase("human")) {
			e = Especie.human;
		}else if (tipus.equalsIgnoreCase("furry")) {
			e = Especie.furry;
		}else if (tipus.equalsIgnoreCase("reptilian"))
			e = Especie.reptilian;
		
		Habitant h = new Habitant(nom, e, energia);
		hs.GuardarHabitant(h);
		
		return h.getNom() + " CREAT CORRECTAMENT";
	}
	
	@GetMapping(path="/createTask")
	public String createTask(@RequestParam String nom, @RequestParam double dedicacio,  @RequestParam int recompensa, @RequestParam String recurs) {
		Recurs r = null;
		
		if (recurs.equalsIgnoreCase("food")) {
			r = Recurs.food;
		}else if (recurs.equalsIgnoreCase("materials")) {
			r = Recurs.materials;
		}else if (recurs.equalsIgnoreCase("tools")) {
			r = Recurs.tools;
		}
		
		Tasca t = new Tasca(nom, dedicacio, recompensa, r);
		ts.createTask(t);
		
		return t.getTitol() + " CREADA CORRECTAMENT";
	}
	
	@GetMapping(path="/addTask")
	public String addTask(@RequestParam int idtask, @RequestParam int idhabitant) {
	
		Habitant h = hs.findByidhabitant(idhabitant);
		Tasca t = ts.findByidtasca(idtask);
		
		h.AddTasca(t);
		hs.GuardarHabitant(h);
		return "Tasca " + t.getTitol() + " asignada a " + h.getNom() + " correctament";
	}
}
