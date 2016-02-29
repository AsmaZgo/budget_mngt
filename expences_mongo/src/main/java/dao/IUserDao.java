package dao;
/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
import java.util.ArrayList;
import java.util.List;

import model.User;

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

public interface IUserDao {

	public DBCollection getConnection();

	public String getOne();

	public String getAll();

	public void insert(User u);

	public void update(User entity);

	public void delete(User entity);

	public String login(String login , String passwd) ;
	public User find(String login, String passwd);

}
