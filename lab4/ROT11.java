package lab4;

class Polibiusz implements Algorithm{
    public String crypt(String from){
		String to = "";
		from = from.toLowerCase();
		int num,r,c;
		for (char letter : from.toCharArray()){
			if (letter > 'z' || letter < 'a'){continue;}
			if (letter == 'j') letter = 'i';
			num = letter - 'a' ;
			if (letter > 'i') num -= 1;
			r = num/5 + 1;
			c = num%5 + 1;
			to = to + (char) (r +'0');
			to = to + (char) (c +'0');
		}
		to += " ";
		return to;	
    }
    public String decrypt(String from){
		String to = "";
		String[] arr = from.split("");
		int c,r,num;
		for (int i = 0; i< arr.length; i+=2){
			r = Integer.parseInt(arr[i]) - 1;
			c = Integer.parseInt(arr[i+1]) - 1;
			num = r*5 + c;
			if (num > 8) num += 1;
			to += (char) (num + 'a');
		}
		to += " ";
		return to;
   }
}
