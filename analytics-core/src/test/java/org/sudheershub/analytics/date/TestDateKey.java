package org.sudheershub.analytics.date;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.sudheershub.analytics.date.DateKey;

public class TestDateKey {
	
	@Test
	public void testConstructor() {
		DateKey d1 = DateKey.fromStringDDsMMsYYYY("01/01/2022");
		String str = d1.toString();
		assertEquals("01-01-2022", str);
	}

}
