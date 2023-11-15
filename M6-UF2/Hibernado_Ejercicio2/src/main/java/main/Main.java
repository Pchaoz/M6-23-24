package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

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
		
		session.beginTransaction(); //SEGUNDA TRANSACCION - RECUPERAR AL TAMAGOTCHI CON ID 1 Y MODIFICARLO
		
		Tamagotchi tama1 = session.find(Tamagotchi.class, 1); //RECUPEREM EL QUE TE LA ID 1
		System.out.println("SOY EL PRIVILEGIADO QUE TIENE LA ID 1: " + tama1.toString()); //EL MOSRTREM PER PANTALLA
		
		tama1.setNom("Updategotchi"); //L'HI MODIFIQUEM EL NOM
		
		session.getTransaction().commit(); //FEM COMMIT PER APLICAR ELS CAMBIS
		
		session.beginTransaction();  //SEGUNDA TRANSACCION - MOSTRAR TOTS ELS TAMAGOTCHIS
		
		List<Tamagotchi> allTama = session.createQuery("from Tamagotchi").getResultList(); //AGAFEM A LO LOCO TOTS ELS TAMAGOTCHIS
		System.out.println(allTama);
		
		for (Tamagotchi t : allTama) {
			
			if (t.getId() == 1) {
				session.remove(t);
			}
		}
		
		session.getTransaction().commit(); //FEM COMMIT PER APLICAR ELS CAMBIS
		
		session.beginTransaction();  //TERCE TRANSACCION - MOSTRAR TOTS ELS TAMAGOTCHIS PERO ACTUALIZADA
		
		allTama = session.createQuery("from Tamagotchi").getResultList(); //AGAFEM A LO LOCO TOTS ELS TAMAGOTCHIS
		System.out.println(allTama);
		
		session.getTransaction().commit();
		
		session.close(); //TANQUEM LA SESSIO DE HIBERNATE
	}
}
