

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.cassandra.CategDao;
import dao.cassandra.UtilDao;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.Category;
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
public class CatDaoTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CatDaoTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CatDaoTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testWrite() { 
    	CategDao ud = new CategDao();
      Category d = new Category();
      d.setDescription("test");
      d.setId(55);
      d.setLabel("test");
      d.setModifiedIn(new Date());
      d.setType("expence");
    	ud.insert(d);

    }
    public void testRead() { 
      List<Category> d = new ArrayList<Category>();
      CategDao ud = new CategDao();
      
	d = ud.getAll();
System.out.println(d);
    }
    


    

}
