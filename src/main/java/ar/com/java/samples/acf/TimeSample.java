package ar.com.java.samples.acf;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TimeSample {
	
	public static void main(String[] args) {
		System.out.println(LocalDate.now().toEpochDay());
		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now());
		System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
	}

}
