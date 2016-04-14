package ar.com.java.samples.acf;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class CollectionsSamples {
	
	public static void main(String[] args) {
		filter();
		System.out.println("---------------------------------------------------------------------------------");
		duplicates();
	}
	
	private static void duplicates() {
		ArrayList<Integer> list = Lists.newArrayList();
		System.out.println("List " + list + " has " + list.stream().distinct().count() + " different elements");
		list.add(1);
		System.out.println("List " + list + " has " + list.stream().distinct().count() + " different elements");
		list.add(2);
		System.out.println("List " + list + " has " + list.stream().distinct().count() + " different elements");
		list.add(2);
		System.out.println("List " + list + " has " + list.stream().distinct().count() + " different elements");
	}

	@SuppressWarnings("unchecked")
	private static void filter() {
		
		ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 3);
		
		// apache commons
		Collection<Integer> ret = CollectionUtils.select(list, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				return object.equals(3);
			}
		});
		System.out.println(ret);
	
		// guava
		Collection<Integer> ret2 = Collections2.filter(list, new com.google.common.base.Predicate<Integer>() {
			@Override
			public boolean apply(Integer input) {
				return input == 2;
			}
		});
		System.out.println(ret2);
		
		Iterable<Integer> ret3 = Iterables.filter(list, new com.google.common.base.Predicate<Integer>() {
			@Override
			public boolean apply(Integer input) {
				return input == 3;
			}
			
		});
		System.out.println(ret3);
		
		Integer ret4 = Iterables.find(list, new com.google.common.base.Predicate<Integer>() {
			@Override
			public boolean apply(Integer input) {
				System.out.println("Evaluate arg " + input);
				return input == 3;
			}
			
		});
		System.out.println(ret4);
	}

}
