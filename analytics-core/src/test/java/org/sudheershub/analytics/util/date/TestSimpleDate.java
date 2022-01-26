package org.sudheershub.analytics.util.date;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestSimpleDate {
	
	@Test
	public void testConstructor() {
		SimpleDate d1 = SimpleDate.fromStringDDsMMsYYYY("01/01/2022");
		String str = d1.toString();
		assertEquals("01-01-2022", str);
	}

}
