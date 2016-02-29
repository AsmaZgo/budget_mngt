
import model.User;

import com.mongodb.DBCollection;

import dao.IUserDao;
import dao.UserDao;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testInsert() {
		IUserDao ud = new UserDao();
		User u = new User();
		u.setFname("asma");
		u.setLname("zgolli");
		u.setLogin("assoum");
		u.setMail("dff@dff.djd");
		u.setPasswd("ddsf");
		u.setRole("dsf");
		// ud.insert(u);
		assertTrue(true);
	}

	public void testLogin() {
		IUserDao ud = new UserDao();
		User u = new User();
		u.setFname("asma");
		u.setLname("zgolli");

		System.out.println(ud.login(u.getLogin(), u.getPasswd()));
		assertTrue(true);
	}

	public void testDelete() {
		IUserDao ud = new UserDao();
		User u = new User();
		u.setFname("rez");
		u.setLname("ee");
		u.setLogin("ffds");
		u.setMail("dff");
		u.setPasswd(getName());
		u.setRole("dsf");
		// ud.delete(u);
		assertTrue(true);
	}

	public void testUpdate() {
		IUserDao ud = new UserDao();
		User u = new User();
		u.setFname("dsfdsf");
		u.setLname("dff");
		u.setLogin("sdqqq");
		u.setMail("qdd");
		u.setPasswd("dffff");
		u.setRole("ds");
		ud.update(u);
		assertTrue(true);
	}
}
