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
		
		
	}

	/*
	 * METODO PARA ACTUALIZAR ENTIDADES GENERICO
	 */
	@Override
	public void update(T entity) {
		
		
	}
	/*
	 * METODO PARA LISTAR TODAS LAS ENTIDADES GENERICO
	 */
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * METODO PARA ENCONTRAR LA ENTIDAD DADA UN ID EN ESPECIFICO GENERICO
	 */
	@Override
	public T find(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
