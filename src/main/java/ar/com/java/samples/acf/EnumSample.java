package ar.com.java.samples.acf;

public enum EnumSample {
	
	TEST, PROD, RC, BETA;

	public static void main(String[] args) {
		System.out.println(EnumSample.TEST.name());
	}
}

