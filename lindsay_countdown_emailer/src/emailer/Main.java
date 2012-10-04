package emailer;




public class Main {

	public static void main(String args[]){
		boolean sendEmail = true;
		boolean sendLessThan12 = true;
		int tmpSecs = 0;
		System.out.println("Time until Winnipeg:");
		while(DateCalculations.getDateDiff() > 0){
			int secsToWinnipeg = DateCalculations.getDateDiff();
			if(tmpSecs != secsToWinnipeg){
				System.out.print(DateCalculations.getText(secsToWinnipeg)+"\r");
				tmpSecs = secsToWinnipeg;
			}
			//86400 is number of seconds in a day
			if(secsToWinnipeg % 86400 == 0){
				if (sendEmail){
					Mail.sendEmail(secsToWinnipeg);
					sendEmail = false;
				}
			}else{
				sendEmail = true;
			}
			if(secsToWinnipeg < 43200 && secsToWinnipeg % 3600 == 0){
				if(sendLessThan12){
					Mail.sendEmail(secsToWinnipeg);
					sendLessThan12 = false;
				}
			}else{
				sendLessThan12 = true;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
