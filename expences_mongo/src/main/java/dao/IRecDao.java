package dao;
/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
import com.mongodb.DBCollection;

import model.Category;
import model.Record;
 
 

public interface IRecDao {

	public DBCollection getConnection();

	public String getOne();

	public String getAll();

	public void insert(Record u);

	public void update(Record entity);

	public void delete(Record entity);

	public Record find(String ref , String label) ;
	


	public Record find(String label) ;
	
/*returns the category associeted with the record*/
	public Category fetch(String category) ;

	boolean verif(String ref, String label);

}
