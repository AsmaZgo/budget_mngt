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

import model.User;

public class UtilDao extends Repository<User> {
	private User entity;
	private ResultSet results;

	public UtilDao() {
		super();
		session = OpenSession();
	}

	public void update(User entity) {
		// Update the same user with a new age
		session.execute(" UPDATE users SET fname = '" + entity.getFname() + "', lname = '" + entity.getLname()
				+ "', login = '" + entity.getLogin() + "', passwd = '" + entity.getPasswd() + "', phone = "
				+ entity.getTel() + ", email = '" + entity.getMail() + "', role = '" + entity.getRole()
				+ "' where user_id = " + entity.getId());

	}

	public void insert(User entity) {
		System.out.println(entity);
		session.execute(
				"INSERT INTO users (user_id, fname, lname, login, passwd, tel, email, role, membership) VALUES ("
						+ entity.getId() + ", '" + entity.getFname() + "','" + entity.getLname() + "','"
						+ entity.getLogin() + "','" + entity.getPasswd() + "', " + entity.getTel() + " , '"
						+ entity.getMail() + "', '" + entity.getRole() + "', '" + entity.getMembership() + "')");

	}

	public void delete(User entity) {
		session.execute("DELETE FROM users WHERE user_id = " + entity.getId());

	}

	public User getById(int id) {
		results = session.execute("select * from users where user_id = " + id);
		User obj = null;
		for (Row row : results) {
			obj = new User();
			obj.setFname(row.getString("fname"));
			obj.setLname(row.getString("lname"));
			obj.setLogin(row.getString("login"));
			obj.setPasswd(row.getString("passwd"));
			obj.setMail(row.getString("email"));
			obj.setRole(row.getString("role"));
			obj.setTel(row.getInt("tel"));
			obj.setMembership(row.getString("membership"));
			// System.out .format("%s %d\n", row.getString("fname"),
			// row.getInt("tel"));
		}
		return obj;
	}

	public User login(String login, String passwd) {
		results = session.execute("SELECT * FROM users");
		User lobj = null;
		User obj = null;
		for (Row row : results) {
			obj = new User();
			obj.setId(row.getInt("user_id"));
			obj.setFname(row.getString("fname"));
			obj.setLname(row.getString("lname"));
			obj.setLogin(row.getString("login"));
			obj.setPasswd(row.getString("passwd"));
			obj.setMail(row.getString("email"));
			obj.setRole(row.getString("role"));
			obj.setTel(row.getInt("tel"));

			obj.setMembership(row.getString("membership"));
			if (obj.getLogin().equals(login) && obj.getPasswd().equals(passwd))
				lobj = obj;
			System.out.format("%s %d\n", row.getString("fname"), row.getInt("tel"));
		}
		return lobj;
	}

	public List<User> getAll() {

		results = session.execute("SELECT * FROM users");
		List<User> lobj = new ArrayList<User>();
		User obj = null;
		for (Row row : results) {
			obj = new User();
			obj.setId(row.getInt("user_id"));
			obj.setFname(row.getString("fname"));
			obj.setLname(row.getString("lname"));
			obj.setLogin(row.getString("login"));
			obj.setPasswd(row.getString("passwd"));
			obj.setMail(row.getString("email"));
			obj.setRole(row.getString("role"));
			obj.setTel(row.getInt("tel"));

			obj.setMembership(row.getString("membership"));
			lobj.add(obj);

			System.out.format("%s %d\n", row.getString("fname"), row.getInt("tel"));
		}
		return lobj;

	}

}
