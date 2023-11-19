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
import models.Tamagotchi;

public class Main {
	
	static Session session;
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;
	
	public static synchronized SessionFactory getSessionFactory() {
		
		try 
		{
			if(sessionFactory == null) 
			{
				StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				Metadata metaData  = new MetadataSources(standardRegistry).getMetadataBuilder().build();
				sessionFactory = metaData.getSessionFactoryBuilder().build();
			}
			return sessionFactory;
			
		} 
		catch (Throwable ex) 
		{
			throw new ExceptionInInitializerError(ex);
		}

	}

	public static void main(String[] args) {
		
		session = getSessionFactory().openSession();
		session.beginTransaction(); //PRIMERA TRANSACCION - CREACION DE LOS TAMAGOTCHIS
		
		Tamagotchi tm1 = new Tamagotchi("Max", "Esta re loco", Etapa.Baby);
		Tamagotchi tm2 = new Tamagotchi("Ana", "Duerme mucho", Etapa.Baby);
		Tamagotchi tm3 = new Tamagotchi("Xavi", "No se ubica", Etapa.Baby);
		
		session.persist(tm1);
		session.persist(tm2);
		session.persist(tm3);
		
		session.getTransaction().commit();
		
		//EJERCICI 2
		
		//CREACIO ALIMENTS
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
		
		//CREACCIO AMICS
		session.beginTransaction();
		
		tm1.agregarAmic(tm2);
		tm2.agregarAmic(tm1);
		tm3.agregarAmic(tm1);
		tm3.agregarAmic(tm2);
		
		session.merge(tm2);
		session.merge(tm1);
		session.merge(tm3);

		session.getTransaction().commit();
		
		session.beginTransaction(); //PER MOSTRARLOS
		
		List<Tamagotchi> allTama = session.createQuery("from Tamagotchi").getResultList(); //AGAFEM A LO LOCO TOTS ELS TAMAGOTCHIS
		System.out.println("LLISTA TAMAGOTCHI ACTUALIZADA AMB AMICS: ");
		System.out.println(allTama);
		
		session.getTransaction().commit();
		
		session.close(); //TANQUEM LA SESSIO DE HIBERNATE
	}
}
