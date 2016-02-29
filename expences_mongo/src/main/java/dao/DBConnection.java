package dao;

/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
import com.mongodb.MongoClient;

public class DBConnection {
	/* singleton DP */
	private static MongoClient mongoClient = new MongoClient("localhost", 27017);

	public static MongoClient getMongoClient() {
		return mongoClient;
	}

}
