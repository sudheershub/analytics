package org.sudheershub.springrest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StreamTest {

	@Test
	public void testStreamFilter() {

		List<Integer> intList = new ArrayList<>();
		intList.add(5);
		intList.add(-3);
		intList.add(2);
		intList.add(7);
		intList.add(-4);
		
		List<Integer> positive = intList.stream().filter(t -> t > 0 ).sorted().toList();
		
		System.out.println(intList);
		System.out.println(positive);
	}
}
