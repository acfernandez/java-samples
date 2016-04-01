package ar.com.java.samples.acf;

public class StringSwitchCaseSample {

	public static void main(String[] args) {

		String car = "ford";
		Integer color;

		switch (car) {
		case "ford":
			color = 1;
			break;
		case "fiat":
			color = 2;
			break;
		default:
			color = 0;
			break;
		}

		System.out.println("The color number for this car " + car + " is " + color);
	}

}
