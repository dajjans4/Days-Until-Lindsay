package emailer;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.joda.time.LocalDateTime;

public class Mail {

	public static void sendEmail(int seconds){

		String host = "smtp.gmail.com";
		String from = "dajjans4";
		String pass = "R1c2LDM8";
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true"); // added this line
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		String[] to = {"dajjans4@gmail.com"};//, "lindshughs@gmail.com"}; // added this line

		Session session = Session.getDefaultInstance(props, null);
		LocalDateTime today = DateCalculations.getCurrentDate();
		String date = Integer.toString(today.getYear())
				+Integer.toString(today.getMonthOfYear())
				+Integer.toString(today.getDayOfMonth());
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			InternetAddress[] toAddress = new InternetAddress[to.length];

			for( int i=0; i < to.length; i++ ) { 
				toAddress[i] = new InternetAddress(to[i]);
			}

			for( int i=0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}
			message.setSubject("Breaking News!");
			message.setText(DateCalculations.getText(seconds));
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		}catch(Exception e){
			Logging.logEvent(date, e.toString());
			return;
		}
		Logging.logEvent(date, "Message Successfully Sent");
	}


}
