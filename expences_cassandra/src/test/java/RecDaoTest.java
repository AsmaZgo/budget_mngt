

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.cassandra.CategDao;
import dao.cassandra.RecordDao;
import dao.cassandra.UtilDao;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.Category;
import model.Record;
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
public class RecDaoTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RecDaoTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RecDaoTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testWrite() { 
    	RecordDao ud = new RecordDao();
      Record d = new Record();
      d.setDescription("test");
      d.setId(55);
      d.setLabel("test");
      d.setAmmont(655);
      d.setCreatedIn(new Date());
     
    	//ud.insert(d);

    }
    public void testRead() { 
      List<Record> d = new ArrayList<Record>();
       
  	RecordDao ud = new RecordDao();
	d = ud.getAll();
System.out.println(d);
    }
    


    

}
