package dao.cassandra;


import java.util.List;

import com.datastax.driver.core.*;
/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
public interface IRepository <T>{
 
//public void beginTransaction() ;
public void closeSession() ;
public Session OpenSession();
public void update(T entity) ;
public void insert(T entity) ;

public void delete(T entity);
public T getById(int id) ;
public List< T> getAll() ;

}
