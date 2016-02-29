package dao;

/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import model.Category;
import model.Record;

public class RecDao implements IRecDao {
	// static MongoClient mongoClient = new MongoClient("localhost", 27017);
	static MongoClient mongoClient = DBConnection.getMongoClient();
	static DB db = mongoClient.getDB("Expencesdb");
	static DBCollection coll = db.getCollection("Records");

	public DBCollection getConnection() {
		coll = db.getCollection("Records");
		return coll;

	}

	public String getOne() {
		DBObject myDoc = coll.findOne();

		System.out.println(myDoc);
		return myDoc.toString();

	}

	public String getAll() {
		List<String> la = new ArrayList<String>();
		DBCursor cursor = coll.find();
		try {
			while (cursor.hasNext()) {
				String doc = cursor.next().toString();
				la.add(doc);
			}
		} finally {
			cursor.close();
		}
		return la.toString();

	}

	public void insert(Record u) {
		// DBObject myDoc = (DBObject) u;
		BasicDBObject document = new BasicDBObject();
		document.put("ref", u.getId());
		document.put("label", u.getLabel());
		document.put("desc", u.getDescription());
		document.put("ammount", u.getAmmont());
		document.put("categorie", u.getCategory());
		document.put("creation", u.getCreatedIn());

		coll.insert(document);
		System.out.println(coll);
	}

	public void update(Record u) {
		BasicDBObject document = new BasicDBObject();
		document.put("ref", u.getId());
		document.put("label", u.getLabel());
		document.put("desc", u.getDescription());
		document.put("ammount", u.getAmmont());
		document.put("categorie", u.getCategory());
		document.put("creation", u.getCreatedIn());

		BasicDBObject searchQuery = new BasicDBObject().append("ref", u.getId());

		coll.update(searchQuery, document);

	}
	/*
	 * public void update(User entity) { BasicDBObject newDocument = new
	 * BasicDBObject(); newDocument.append("$set", new
	 * BasicDBObject().append("lname", entity.getLname()));
	 * 
	 * BasicDBObject searchQuery = new BasicDBObject().append("login",
	 * entity.getLogin());
	 * 
	 * coll.update(searchQuery, newDocument);
	 * 
	 * }
	 */

	public void delete(Record entity) {
		BasicDBObject document = new BasicDBObject();
		document.put("ref", entity.getId());
		coll.remove(document);

	}

	public Record find(String ref, String label) {
		Record c = new Record();
		BasicDBObject document = new BasicDBObject();
		if (!ref.isEmpty())
			document.put("ref", ref);
		if (!label.isEmpty())
			document.put("label", label);
		DBCursor cursor = coll.find(document);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
			c = (Record) cursor.next();
			System.out.println("ici");
			System.out.println(c);
		}
		return c;
	}

	public boolean verif(String ref, String label) {
		boolean cond = false;
		BasicDBObject document = new BasicDBObject();
		if (!ref.isEmpty())
			document.put("ref", ref);
		if (!label.isEmpty())
			document.put("label", label);
		DBCursor cursor = coll.find(document);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
			cond = true;
		}
		return cond;
	}

	public Record find(String label) {
		// TODO Auto-generated method stub
		return null;
	}

	public Category fetch(String category) {
		ICatDao r = new CatDao();
		Category c = r.find(category);
		return c;
	}

}
