public class Main{
	public static void main(String [] argv){
		EmailMessage wiadomosc = EmailMessage.builder().
		addFrom("przemeknok@interia.pl").
		addTo("ukryty456@interia.pl").
		addSubject("Mail testowy").
		addContent("Brak tresci").
		build();
	}
}
