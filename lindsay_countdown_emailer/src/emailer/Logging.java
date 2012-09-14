package emailer;

import java.io.*;

public class Logging {

	public static void logEvent(String date, String text){
		try{
		/*	String dirName = "/logs/";
			String fileName = date+".log";
			File dir = new File(dirName);
			File file = new File(dir, fileName);
			*/
			String fileName = "logs" + File.separator + date + ".log";
			FileWriter fstream = new FileWriter(fileName);
			BufferedWriter log = new BufferedWriter(fstream);
			
			log.write(text);
			log.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
