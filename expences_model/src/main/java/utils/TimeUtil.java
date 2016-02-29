package utils;
/**
 * @author ASMA ZGOLLI
 * @version 1.0
 * @created 28-02-2016 
 * @mail zgolliasma@gmail.com
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

	/** TIME STAMP CONVERSION **/
	/* converts real date to jvm/unix date */
	/* date format dd/MM/yyyy */
	public static long getTime(String s) {
		Date date = new Date(s);
		return date.getTime();

	}

	public static Date getDay(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(s));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		s = sdf.format(c.getTime()); // dt is now the new date
		Date r = c.getTime();
		return r;

	}

	/* increments jvm date (input = real date) */
	/* date format yyyy-MM-dd */
	public static long nextDay(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(s));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.DATE, 1); // number of days to add
		s = sdf.format(c.getTime()); // dt is now the new date
		long r = c.getTime().getTime();
		return r;

	}

	public static String nextDate(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(s));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.DATE, 1); // number of days to add
		s = sdf.format(c.getTime()); // dt is now the new date
		long r = c.getTime().getTime();
		return s;

	}

}
