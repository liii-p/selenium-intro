package learning.seleniumjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsTest1 {
	
	//@Test
	public void regular() {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abdul");
		names.add("Amy");
		names.add("Lily");
		names.add("Charlotte");
		names.add("Adam");
		int count = 0;
		
		for(int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if(actual.startsWith("A")) {
				count++;
			}
		}
		
		System.out.println(count);

	}
	
	//@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abdul");
		names.add("Amy");
		names.add("Lily");
		names.add("Charlotte");
		names.add("Adam");
		// there is no life for intermediate op if there is no terminal op
		// terminal op will execute only if inter op (filter) returns true
		// We can create stream with stream package
		// how to use filter in Stream API
		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		long d = Stream.of("Amy", "Lily", "Charlotte", "Adam", "Axolotl").filter(s-> 
		{
			s.startsWith("A");
			return true;
		}).count();
		System.out.println(d);
		// print all the names of ArrayList
		//names.stream().filter(s-> s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}

	//@Test
	public void streamMap() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Stefan");
		names.add("Katherine");
		names.add("Damon");
		names.add("Elena");
		//print names of len greater which have last letter as "y" than 4 with uppercase
		Stream.of("Amy", "Lily", "Charlotte", "Adam", "Axolotl").filter(s->s.endsWith("y")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		//print names which have first letter as "a" with uppercase and alphabetically sorted
		// if using arrays -> arrays.asList() to use it as a list
		List<String> names1 = Arrays.asList("Amy", "Lily", "Charlotte", "Adam", "Axolotl");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		//Merging two different lists
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void streamCollect() {
		List<String> list = Stream.of("Amy", "Lily", "Charlotte", "Adam", "Axolotl").filter(s->s.endsWith("y")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(list.get(0));
		
		List<Integer> intList = Arrays.asList(3,2,2,7,5,1,9,7);
		//print unique number from this array
		//sort the array
		//intList.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> li = intList.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
		
	}
}
