package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import models.Aliment;
import models.Etapa;
import models.Joguina;
import models.Tamagotchi;

public class Main {

	static Session session;
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;

	public static synchronized SessionFactory getSessionFactory() {

		try {
			if (sessionFactory == null) {
				StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
						.configure("hibernate.cfg.xml").build();
				Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
				sessionFactory = metaData.getSessionFactoryBuilder().build();
			}
			return sessionFactory;

		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}

	}

	public static void main(String[] args) {

		session = getSessionFactory().openSession();
		session.beginTransaction(); // PRIMERA TRANSACCION - CREACION DE LOS TAMAGOTCHIS

		Tamagotchi tm1 = new Tamagotchi("Max", "Esta re loco", Etapa.Baby);
		Tamagotchi tm2 = new Tamagotchi("Ana", "Duerme mucho", Etapa.Baby);
		Tamagotchi tm3 = new Tamagotchi("Xavi", "No se ubica", Etapa.Baby);

		session.persist(tm1);
		session.persist(tm2);
		session.persist(tm3);

		session.getTransaction().commit();

		// EJERCICI 2

		// CREACIO ALIMENTS
		session.beginTransaction();

		Aliment a1 = new Aliment("Poma", "Apple ho aprova", 20);
		Aliment a2 = new Aliment("Xocolata", "Amb atmelles", 5.72);
		Aliment a3 = new Aliment("Pera", "ES peracular", 25.60);
		Aliment a4 = new Aliment("Pollaste", "Amb llimona", 50);

		session.persist(a1);
		session.persist(a2);
		session.persist(a3);
		session.persist(a4);

		session.getTransaction().commit();

		// CREACCIO AMICS
		session.beginTransaction();

		tm1.agregarAmic(tm2);
		tm2.agregarAmic(tm1);
		tm3.agregarAmic(tm1);
		tm3.agregarAmic(tm2);

		session.merge(tm2);
		session.merge(tm1);
		session.merge(tm3);

		session.getTransaction().commit();

		// ASIGNAMENT DE LA POMA A LA ID 2
		session.beginTransaction();

		Tamagotchi tamaID1 = session.find(Tamagotchi.class, 1);
		Tamagotchi tamaID2 = session.find(Tamagotchi.class, 2);
		Tamagotchi tamaID3 = session.find(Tamagotchi.class, 3);

		tamaID1.setAliment(a1);
		tamaID2.setAliment(a2);
		tamaID3.setAliment(a2);

		session.merge(tamaID1);
		session.merge(tamaID2);
		session.merge(tamaID3);

		session.getTransaction().commit();

		session.beginTransaction(); // PER MOSTRARLOS

		List<Tamagotchi> allTama = session.createQuery("from Tamagotchi").getResultList(); // AGAFEM A LO LOCO TOTS ELS
																							// TAMAGOTCHIS
		System.out.println("LLISTA TAMAGOTCHI ACTUALIZADA AMB AMICS: ");
		System.out.println(allTama);

		session.getTransaction().commit();

		session.beginTransaction();

		Joguina jog1 = new Joguina("Pilota", "Pa jugar a furbo", 5);
		Joguina jog2 = new Joguina("Hotwheels", "FIUUUUUUUUUM", 55);

		session.persist(jog1);
		session.persist(jog2);

		tamaID1.setJoguina(jog1);
		tamaID2.setJoguina(jog2);

		session.merge(tamaID1);
		session.merge(tamaID2);

		session.getTransaction().commit();
		
		System.out.println("======= PRIMERS RESULTATS JOGUINA ========");
		
		session.beginTransaction();

		allTama = session.createQuery("from Tamagotchi").getResultList();
		System.out.println(allTama);
		
		session.getTransaction().commit();

		System.out.println("======= MODIFICO LA JOGUINA DEL 1 AMB LA DEL 2 ========");

		session.beginTransaction();

		tamaID1.setJoguina(null);
		tamaID2.setJoguina(null);

		session.merge(tamaID1);
		session.merge(tamaID2);

		session.getTransaction().commit();

		session.beginTransaction();

		tamaID1.setJoguina(jog2);
		tamaID2.setJoguina(jog1);

		session.merge(tamaID1);
		session.merge(tamaID2);

		session.getTransaction().commit();
		
		System.out.println("======= SEGONS RESULTATS JOGUINA ========");
		
		session.beginTransaction();
		
		allTama = session.createQuery("from Tamagotchi").getResultList();
		System.out.println(allTama);

		session.close(); // TANQUEM LA SESSIO DE HIBERNATE
	}
}
