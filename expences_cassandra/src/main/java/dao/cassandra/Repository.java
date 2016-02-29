package dao.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016
 * @mail zgolliasma@gmail.com
 */

public abstract class Repository<T> implements IRepository<T> {
	Cluster cluster;
	Session session;

	public Session OpenSession() {
		this.cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		this.session = cluster.connect("expenses");
		return this.session;
	}

	public void closeSession() {
		if (!this.session.isClosed()) {
			System.err.println("session open : " + this.session.getState() + this.session.getLoggedKeyspace());
			this.session.close();
		}
		if (!this.cluster.isClosed()) {

			System.err.println("cluster open :" + this.cluster.getClusterName() + this.cluster.getMetadata()
					+ this.cluster.getMetrics());
			// Clean up the connection by closing it
			this.cluster.close();
		}
	}

}
