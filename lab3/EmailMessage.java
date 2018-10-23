import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
 
public class EmailMessage{
	private String from;
	private LinkedList<String> to;
	private String subject;
	private String content;
	private String mimeType;
	private LinkedList<String> cc;
	private LinkedList<String> bcc;
	private EmailMessage(){}
	private EmailMessage(String _from, LinkedList<String> _to, String _subject, String _content,String _mimeType, LinkedList<String> _cc, LinkedList<String> _bcc){
        from=_from;
        to=_to;
        subject=_subject;
        content=_content;
        mimeType=_mimeType;
        cc=_cc;
        bcc=_bcc;
}
	static public Builder builder(){
		return new EmailMessage.Builder();
	}

	public void send(){
		System.out.println(from);
		final String password;
        System.out.print("Password: ");
        Scanner odczyt = new Scanner(System.in);
        password = odczyt.nextLine();

		Properties properties = System.getProperties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "poczta.interia.pl");
		properties.put("mail.debug", "true");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, password);
				}
 			});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
 			for(String str : to) {
				message.addRecipients(Message.RecipientType.TO, str);
			}
			for(String str : cc) {
				message.addRecipients(Message.RecipientType.CC, str);
			}
			for(String str : bcc) {
				message.addRecipients(Message.RecipientType.BCC, str);
			}
			message.setSubject(subject);
			message.setText(content);

			Transport.send(message);
			System.out.println("Wysłano.");
		}
		catch (MessagingException e){
			throw new RuntimeException(e);
		}
	}

	static class Builder{
		private String from;
        private LinkedList<String> to = new LinkedList<String>();
        private String subject;
        private String content;
        private String mimeType;
        private LinkedList<String> cc = new LinkedList<String>();
		private LinkedList<String> bcc = new LinkedList<String>();
		private boolean checkAdress (String str){
			try{
   				if (str.charAt(0) == '@') return false;
				for (int i = 1; i< str.length()-2;++i){
					if (str.charAt(i) == '@') return true;	
				}
			}
			catch (Exception e) {return false;}
			return false;
		}
		public Builder addFrom(String str){
			from = str;
			return this;
		}
		public Builder addTo(String str){
			to.add(str);
			return this;
		}
		public Builder addSubject(String str){
			subject = str;
			return this;
		}
		public Builder addContent(String str){
			content = str;
			return this;
		}
		public Builder addMimeType(String str){
			mimeType= str;
			return this;
		}
		public Builder addCc(String str){
			cc.add(str);
			return this;
		}
		public Builder addBcc(String str){
			bcc.add(str);
			return this;
		}
		public EmailMessage build(){
			System.out.println(from);
			return new EmailMessage(from, to, subject, content, mimeType, cc, bcc);
		}
	}
}
