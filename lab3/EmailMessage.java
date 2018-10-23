import java.io.*;
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
			if (!checkAdress(str)) throw new IllegalArgumentException();
			from = str;
			return this;
		}
		public Builder addTo(String str){
			if (!checkAdress(str)) throw new IllegalArgumentException();
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
            return new EmailMessage(from, to, subject, content, mimeType, cc, bcc);
		}
	}
}
