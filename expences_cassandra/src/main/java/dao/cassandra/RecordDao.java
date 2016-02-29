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
import model.Record;

public class RecordDao extends Repository<Record> {

	private ResultSet results;

	public RecordDao() {
		super();

		session = OpenSession();
	}

	public Record find(String ref, String label) {

		// TODO implement me :(
		return null;
	}

	public Record find(String label) {

		// TODO implement me :(
		return null;
	}

	/* returns the category associeted with the record */
	public Category fetch(String category) {

		// TODO implement me :(
		return null;
	}

	boolean verif(String ref, String label) {

		// TODO implement me :(
		return false;
	}

	public void update(Record entity) {
		session.execute(" UPDATE rec SET rec_id = " + "'" + entity.getId() + "', label = '" + entity.getLabel()
				+ "', ammount = '" + entity.getAmmont() +

		"', category = '" + entity.getCategory() + "', dateCreat = '" + entity.getCreatedIn() + "', descri = "
				+ entity.getDescription() + "' where rec_id = " + entity.getId());
	}

	public void insert(Record entity) {
		session.execute("INSERT INTO rec (rec_id, label,"
				// + " ammount, "
				+ "category, dateCreat, descri) VALUES (" + entity.getId() + ", '" + entity.getLabel()
				// +"','"+entity.getAmmont()
				+ "','" + entity.getCategory() + "','" + entity.getCreatedIn() + "','" + entity.getDescription()
				+ "')");

	}

	public void delete(Record entity) {
		session.execute("DELETE FROM rec WHERE rec_id = " + entity.getId());

	}

	public Record getById(int id) {
		results = session.execute("select * from rec where rec_id = " + id);
		Record obj = null;
		for (Row row : results) {
			obj = new Record();
			obj.setId(row.getInt("rec_id"));
			obj.setLabel(row.getString("label"));
			obj.setAmmont(row.getInt("ammount"));

			obj.setCategory(row.getString("category"));
			obj.setDescription(row.getString("descri"));
			// System.out .format("%s %d\n", row.getString("fname"),
			// row.getInt("tel"));
		}
		return obj;
	}

	public List<Record> getAll() {
		results = session.execute("SELECT * FROM rec");
		List<Record> lobj = new ArrayList<Record>();
		Record obj = null;
		for (Row row : results) {
			obj = new Record();
			obj.setId(row.getInt("rec_id"));
			obj.setLabel(row.getString("label"));
			obj.setAmmont(row.getInt("ammount"));

			obj.setCategory(row.getString("category"));
			obj.setDescription(row.getString("descri"));
			lobj.add(obj);
		}
		return lobj;
	}

}
