package dao;
/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
import java.util.List;

import com.mongodb.DBCollection;

import model.Category;
 

public interface ICatDao {

	public DBCollection getConnection();

	public String getOne();

	public String getAll();

	public void insert(Category u);

	public void update(Category entity);

	public void delete(Category entity);

	public Category find(String ref , String label) ;
	
	public Category find (String label) ;
	public List<Category> fetch (String type) ;

	boolean verif(String ref, String label);

}
