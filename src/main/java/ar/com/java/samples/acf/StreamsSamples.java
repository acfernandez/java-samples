package ar.com.java.samples.acf;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamsSamples {

	public static void main(String[] args) {
		StreamsSamples ss = new StreamsSamples();
		ss.sample1();
	}
	
	private void sample1() {
				
		String result = Arrays.asList(1, 2, 3, 4, 5, 6)
				.stream()
				.filter(e -> e % 2 == 0)
				.map(String::valueOf)
				.collect(Collectors.joining("-"));
		
		System.out.println("result-> " + result);
	}
}
