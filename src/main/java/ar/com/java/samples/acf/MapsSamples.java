package ar.com.java.samples.acf;

import java.util.EnumMap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

public class MapsSamples {

	public static void main(String[] args) {
		ListMultimap<String, Boolean> map = ArrayListMultimap.create();
		map.put("SAVE", true);
		map.put("INSERT", false);
		map.put("SAVE", true);
		System.out.println(map.asMap());
		
		EnumMap<Day, Boolean> enumMap = Maps.newEnumMap(Day.class);
		enumMap.put(Day.WEDNESDAY, true);
		enumMap.put(Day.SATURDAY, false);
		enumMap.put(Day.WEDNESDAY, false);
		System.out.println(enumMap);
		
	    Multimap<String, Integer> duplicatedMap = ArrayListMultimap.create();
	    duplicatedMap.put("a", 1);
	    duplicatedMap.put("a", 1);
	    duplicatedMap.put("a", 1);
	    System.out.println(duplicatedMap.get("a").stream().distinct().count());
	    
	}

	private enum Day { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY }
}
