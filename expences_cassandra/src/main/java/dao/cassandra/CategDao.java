package dao.cassandra;

/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import model.Category;
import model.User;

public class CategDao extends Repository<Category> {

	private ResultSet results;

	public CategDao() {
		super();
		session = OpenSession();
	}

	public Category find(String ref, String label) {
		return null;
	}

	public Category find(String label) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Category> fetch(String type) {
		return null;
	}

	boolean verif(String ref, String label) {
		return false;
	}

	public void update(Category entity) {
		session.execute(" UPDATE cat SET cat_id = " + "'" + entity.getId() + "', label = '" + entity.getLabel()
				+ "', type = '" + entity.getType() + "', dateModif = '" + entity.getModifiedIn() + "', descri = "
				+ entity.getDescription() + "' where cat_id = " + entity.getId());

	}

	public void insert(Category entity) {
		session.execute("INSERT INTO cat (cat_id, label, type, " + "dateModif, descri) VALUES (" + entity.getId()
				+ ", '" + entity.getLabel() + "','" + entity.getType() + "','" + entity.getModifiedIn() + "','"
				+ entity.getDescription() + "')");

	}

	public void delete(Category entity) {
		session.execute("DELETE FROM cat WHERE cat_id = " + entity.getId());

	}

	public Category getById(int id) {
		results = session.execute("select * from cat where cat_id = " + id);
		Category obj = null;
		for (Row row : results) {
			obj = new Category();
			obj.setId(row.getInt("cat_id"));
			obj.setLabel(row.getString("label"));
			obj.setType(row.getString("type"));
			obj.setDescription(row.getString("descri"));
			// System.out .format("%s %d\n", row.getString("fname"),
			// row.getInt("tel"));
		}
		return obj;
	}

	public List getAll() {

		results = session.execute("SELECT * FROM cat");
		List<Category> lobj = new ArrayList<Category>();
		Category obj = null;
		for (Row row : results) {
			obj = new Category();
			obj.setId(row.getInt("cat_id"));
			obj.setLabel(row.getString("label"));
			obj.setType(row.getString("type"));
			obj.setDescription(row.getString("descri"));

			lobj.add(obj);

		}
		return lobj;
	}

}
