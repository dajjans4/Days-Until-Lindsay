package emailer;

import org.joda.time.LocalDateTime;
import org.joda.time.Seconds;


public class DateCalculations {
	
	public static LocalDateTime getArrivalDate(){
		//I arrive in Winnipeg at 12:15 am on Oct 5th EST
		return new LocalDateTime(2012, 10, 5, 23, 15);
	}
	
	public static LocalDateTime getCurrentDate(){
		return new LocalDateTime();
	}
	
	public static int getDateDiff(){
		Seconds sec = Seconds.secondsBetween(getCurrentDate(), getArrivalDate());
		
		return sec.getSeconds();
	}
}
