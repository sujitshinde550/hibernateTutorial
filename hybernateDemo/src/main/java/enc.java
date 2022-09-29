import java.util.Base64;

public class enc {
//	public static String decode(String encodedpassword ) {
//		
//	byte[] decodedBytes = Base64.getDecoder().decode(encodedpassword);
//	return new String(decodedBytes);
//	}
	public static void main(String[] args) throws InterruptedException {
		
		String encodedString = Base64.getEncoder().encodeToString("sujit".getBytes());
	System.out.println(new String(encodedString));
	byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
	String decodedString = new String(decodedBytes);
		System.out.println(decodedString);

		
	
	
}
	
}
