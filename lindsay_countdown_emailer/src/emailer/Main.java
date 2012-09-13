package emailer;

import org.joda.time.Period;


public class Main {

	public static void main(String args[]){
		boolean sendEmail = true;
		int tmpSecs = 0;
		System.out.println("Time until Winnipeg:");
		while(DateCalculations.getDateDiff() > 0){
			int secsToWinnipeg = DateCalculations.getDateDiff();
			Period p = new Period(secsToWinnipeg*1000);
			int days = p.getHours() / 24;
			int hours = p.getHours() % 24;
			if(tmpSecs != secsToWinnipeg){
				System.out.print(days + " days " + hours + " hours " + p.getMinutes() 
					+ " minutes and " + p.getSeconds() + " seconds!" +"\r");
				tmpSecs = secsToWinnipeg;
			}
			if(secsToWinnipeg % 86400== 0){
				if (sendEmail){
					System.out.println("Send out email");
					sendEmail = false;
				}
			}else{
				sendEmail = true;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
