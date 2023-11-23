package dao;

import java.io.Serializable;
import java.util.List;

public interface InterDAOGeneric  <T, ID extends Serializable>{
	 void save(T entity);
	 void delete(T entity);
	 void delete(ID id);
	 void update(T entity);
	 List<T> findAll();
	 T find(ID id);
}
