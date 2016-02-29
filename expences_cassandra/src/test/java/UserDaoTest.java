

import java.util.ArrayList;
import java.util.List;

import dao.cassandra.UtilDao;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.User;

/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
/****3****/

/**
 * Unit test .
 */
public class UserDaoTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public UserDaoTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( UserDaoTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testWrite() { 
      User d = new User();
 d.setFname("test");
 d.setLname("un autre");
 d.setId(6);
 d.setLogin("test");
 d.setPasswd("ppp");
 d.setMail("test@gmail.fr");
 d.setTel(5744);
 d.setRole("guest");
 d.setMembership("son");
	UtilDao ud = new UtilDao();
	ud.insert(d);

    }
    public void testRead() { 
      List<User> d = new ArrayList<User>();

	UtilDao ud = new UtilDao();
	d = ud.getAll();
System.out.println(d);
    }
    public void testLogin() { 
     User d = new User();

	UtilDao ud = new UtilDao();
	d = ud.login("test", "ppp");
System.out.println(d);
    }


    

}
