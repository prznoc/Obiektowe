package lab4;

class ROT11 implements Algorithm{
	private final int move = 11;
	private static final int alphabet_size = 26;
	private static final char[] alphabet= { 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v',  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E',
			'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public String crypt(String from){
		String to = "";
		for (char i : from.toCharArray()) {
			if (i <= 'z' && i >= 'a') {
				to = to + (char) ((i + move - 'a') % alphabet_size + 'a');
			} 
			else if (i <= 'Z' && i >= 'A') {
				to = to + (char) ((i + move - 'A') % alphabet_size + 'A');
			} 
			else {
				to = to + i;
			}
		}
		to += " ";
		return to;
    }
    public String decrypt(String from){
    	String to = "";
		for (char i : from.toCharArray()) {
			if (i <= 'z' && i >= 'a') {
				to = to + (char) ((i + alphabet_size - move - 'a') % alphabet_size + 'a');
			} 
			else if (i <= 'Z' && i >= 'A') {
				to = to + (char) ((i + alphabet_size - move - 'A') % alphabet_size + 'A');
			} 
			else {
				to = to + i;
			}
		}
		to += " ";
		return to;
    }
}
