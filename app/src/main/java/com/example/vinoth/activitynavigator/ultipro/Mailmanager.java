package com.example.vinoth.activitynavigator.ultipro;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Mailmanager {
	public static boolean sent( String Tomail,String subject,String Body) throws IOException {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("vinoth.m63@gmail.com","m9750174790v");
                    //get email ,pass
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("vinoth.m63@gmail.com"));//geting email to txt
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(Tomail));
			message.setSubject(subject);
			message.setText(Body);
			Transport.send(message);
			return true;

		} catch (MessagingException e) {
			
			return false;
			//throw new RuntimeException(e);
			
			
		}
		
	}
}
