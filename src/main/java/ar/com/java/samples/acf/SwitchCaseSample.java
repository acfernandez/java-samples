package ar.com.java.samples.acf;

public class SwitchCaseSample {

	public static void main(String[] args) {
		String key = "CONCILIATED";
		switch (key) {
		case "ERROR":
			System.out.println("ERROR");
			break;
		case "CONCILIATED":
		case "BELOW_TOLERANCE": 
		case "OVER_TOLERANCE":
			System.out.println("ACCEPTED");
			break;
		case "PRE_CONCILIATED":
			System.out.println("PENDING");
			break;
		default:
			System.out.println("ERROR");
			break;
		}
	}

}
