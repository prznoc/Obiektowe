public class Main{
	public static void main(String [] argv){
		EmailMessage wiadomosc = EmailMessage.builder().
		addFrom("ukryty456@interia.pl").
		addTo("przemeknok@interia.pl").
		addTo("przemyslawnocon19@gmail.com").
		addSubject("Mail testowy").
		addContent("Brak tresci").
		build();
		wiadomosc.send();
	}
}
