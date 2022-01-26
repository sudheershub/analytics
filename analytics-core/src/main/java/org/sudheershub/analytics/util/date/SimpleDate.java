package org.sudheershub.analytics.util.date;

public class SimpleDate {
	
	private final int day;
	private final int month;
	private final int year;
	
	public static SimpleDate fromStringDDsMMsYYYY(String dateString) {
		String[] split = dateString.split("/");
		return new SimpleDate(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
	}
	
	private SimpleDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String toString() {
		return (day < 10 ? "0" : "") + day + "-" + (month < 10 ? "0" : "") + month + "-" + year;
	}
}
