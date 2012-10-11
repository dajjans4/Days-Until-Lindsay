package emailer;

import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.joda.time.Seconds;


public class DateCalculations {

	public static LocalDateTime getArrivalDate(){
		//Arrival date (year, month, day, hour, minute)
		return new LocalDateTime(2012, 11, 25, 21, 38);
	}

	public static LocalDateTime getCurrentDate(){
		return new LocalDateTime();
	}	

	public static int getDateDiff(){
		return Seconds.secondsBetween(getCurrentDate(), getArrivalDate()).getSeconds();
	}
	public static String getText(int seconds){
		Period p = new Period(seconds*1000);
		int days = p.getHours() / 24;
		int hours = p.getHours() % 24;

		return (days + " days " + hours + " hours " + p.getMinutes() 
				+ " minutes and " + p.getSeconds() + " seconds!");
	}
}
