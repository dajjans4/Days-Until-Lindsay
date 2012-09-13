package emailer;


public class Main {

	public static void main(String args[]){
		boolean sendEmail = true;
		System.out.println("There are not THAT many days until we see each other");
		
		System.out.println("Seconds until I am in Winnipeg:");
		while(DateCalculations.getDateDiff() > 0){
			int secsToWinnipeg = DateCalculations.getDateDiff();
			System.out.print(secsToWinnipeg + "\r");
			if(secsToWinnipeg % 86400== 0){
				if (sendEmail){
					System.out.println("Whole day less");
					sendEmail = false;
				}
			}else{
				sendEmail = true;
			}
		}
	}
	
}
