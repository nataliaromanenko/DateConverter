package ru.romanenko.main;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class ConversionMethods {
	
	private static long timestamp;
	private static String unixdateHex;
	private static int countDaysSince1970;
	private static String countDaysSince1970InHex;

	
	public static long ToTimeStamp(String inputDate) throws ParseException, java.text.ParseException {

		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyhhmmss");
        java.util.Date date = format.parse(inputDate);
        Timestamp tm = new Timestamp(date.getTime());
        timestamp = tm.getTime()/1000L;
        return timestamp;
        
	}
	
	public static String TimeStampToHex(long inputTimestamp) throws ParseException, java.text.ParseException {
		
		unixdateHex = Long.toHexString(ToTimeStamp(ApplicationFrame.inputDate)).toUpperCase();
		return unixdateHex;
		
	}
	
	
	public static int TimeStampToUnixDays(long inputTimestamp) throws ParseException, java.text.ParseException {
		
		countDaysSince1970 = (int) (ToTimeStamp(ApplicationFrame.inputDate))/86400;
		return countDaysSince1970;
		
	}
	
	public static String UnixDaysToHex(int inputUnixDays) throws ParseException, java.text.ParseException {
		
		countDaysSince1970InHex = Long.toHexString(TimeStampToUnixDays(ToTimeStamp(ApplicationFrame.inputDate))).toUpperCase();
		return countDaysSince1970InHex;
		
	}
	
}
