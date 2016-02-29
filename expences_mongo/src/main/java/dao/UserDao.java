package dao;

/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

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

public class UserDao implements IUserDao {
	// static MongoClient mongoClient = new MongoClient("localhost", 27017);
	static MongoClient mongoClient = DBConnection.getMongoClient();
	static DB db = mongoClient.getDB("Expencesdb");
	static DBCollection coll = db.getCollection("Users");

	public DBCollection getConnection() {
		coll = db.getCollection("Users");
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

	public void insert(User u) {
		// DBObject myDoc = (DBObject) u;
		BasicDBObject document = new BasicDBObject();
		// document.put("_id", new ObjectId());
		document.put("login", u.getLogin());
		document.put("passwrd", u.getPasswd());
		document.put("fname", u.getFname());
		document.put("lname", u.getLname());
		document.put("mail", u.getMail());
		document.put("tel", u.getTel());
		document.put("role", u.getRole());

		document.put("membership", u.getMembership());
		coll.insert(document);
		System.out.println(coll);
	}

	public void update(User u) {
		BasicDBObject document = new BasicDBObject();
		// document.put("login", u.getLogin());
		document.put("passwrd", u.getPasswd());
		document.put("fname", u.getFname());
		document.put("lname", u.getLname());
		document.put("mail", u.getMail());
		document.put("tel", u.getTel());
		document.put("role", u.getRole());

		document.put("membership", u.getMembership());
		BasicDBObject searchQuery = new BasicDBObject().append("login", u.getLogin());

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

	public void delete(User entity) {
		BasicDBObject document = new BasicDBObject();
		document.put("login", entity.getLogin());
		coll.remove(document);

	}

	public User find(String login, String passwd) {
		User u = new User();
		BasicDBObject document = new BasicDBObject();
		document.put("login", login);
		document.put("passwrd", passwd);
		DBCursor cursor = coll.find(document);
		while (cursor.hasNext()) {
			u = (User) cursor.next();
		}
		return u;
	}

	public String login(String login, String passwd) {
		String u = new String();
		BasicDBObject document = new BasicDBObject();
		document.put("login", login);
		document.put("passwrd", passwd);
		DBCursor cursor = coll.find(document);
		while (cursor.hasNext()) {
			u = cursor.next().toString();
			System.out.println(u);
		}
		return u;
	}

}
