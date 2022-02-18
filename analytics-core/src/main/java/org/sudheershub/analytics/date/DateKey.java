package org.sudheershub.analytics.date;

public class DateKey {
	
	private final int day;
	private final int month;
	private final int year;
	
	public static DateKey fromStringDDsMMsYYYY(String dateString) {
		String[] split = dateString.split("/");
		return new DateKey(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
	}
	
	private DateKey(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String toString() {
		return (day < 10 ? "0" : "") + day + "-" + (month < 10 ? "0" : "") + month + "-" + year;
	}
}
