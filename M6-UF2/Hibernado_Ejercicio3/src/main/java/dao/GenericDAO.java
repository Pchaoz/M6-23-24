package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public class GenericDAO <T, ID extends Serializable> implements InterDAOGeneric<T, ID>{
	
	Class<T> entityClass; //LA CLASE CON LA QUE VAS A TRABAJAR
	
	public GenericDAO (Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	/*
	 * METODO PARA GUARDAR ENTIDADES GENERICO
	 */
	public void save(T entity) {
		
		Session session = Utils.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		
		session.persist(entity);
		
		session.getTransaction().commit();		
	}

	@Override
	/*
	 * METODO PARA BORRAR ENTIDADES GENERICO
	 */
	public void delete(T entity) {
		
		Session session = Utils.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		
		session.remove(entity);
		
		session.getTransaction().commit();		
	}

	/*
	 * METODO PARA BORRAR ENTIDADES POR LA ID GENERICO
	 */
	@Override
	public void delete(ID id) {
		
		Session session = Utils.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		
		T entityToDelete = session.find(entityClass, id);
		session.remove(entityToDelete);
		
		session.getTransaction().commit();
	}

	/*
	 * METODO PARA ACTUALIZAR ENTIDADES GENERICO
	 */
	@Override
	public void update(T entity) {
		
		Session session = Utils.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();	
		
		session.merge(entity);
		
		session.getTransaction().commit();

	}
	/*
	 * METODO PARA LISTAR TODAS LAS ENTIDADES GENERICO
	 */
	@Override
	public List<T> findAll() {
		
		Session session = Utils.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		
		List<T> registres = session.createQuery("FROM "+entityClass.getName()).getResultList();
		
		session.getTransaction().commit();
		return registres;

	}
	
	/*
	 * METODO PARA ENCONTRAR LA ENTIDAD DADA UN ID EN ESPECIFICO GENERICO
	 */
	@Override
	public T find(ID id) {
		
		Session session = Utils.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		
		T entity = session.find(entityClass, id);
		
		session.getTransaction().commit();
		return entity;
	}

}
