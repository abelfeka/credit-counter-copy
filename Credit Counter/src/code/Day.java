package code;
import java.util.*;

public class Day {//extends Date {

	private Date date;
	
	public Day() {
		date = new Date(System.currentTimeMillis());
	}
	public Day(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
		
	@Override
	public String toString() {
		String dateString = date.toString().substring(0, 10) + date.toString().substring(24,29);
		String timeString = date.toString().substring(11, 19);
		return "Date: " + dateString + " Time: "+ timeString;
	}
	/**
	 *Sample: Wed Jul 03 2019 
	 * @return String
	 */
	public String DatetoString() {
		return date.toString().substring(0, 10) + date.toString().substring(24,29);
	}
	
	/**
	 * Sample: 23:34:59
	 * @return 
	 */
	public String TimetoString() {
		return date.toString().substring(11, 19);
	}
	/**
	 * Returns three letters as a string that represent
	 * the first three letters of the current day of the week.
	 * */
	 public String getDateOnly() { 
		return DatetoString().substring(0, 3);
	}
	
	public int getHour() {
		return new Integer(TimetoString().substring(0,2));
	}
	public int getMinute() {
		return new Integer(TimetoString().substring(3,5));
	}
	public int getSecond() {
		return new Integer(TimetoString().substring(6));
	}
	
	public boolean isWeekend() {
		Day day = new Day();
	return (day.getDateOnly().equalsIgnoreCase("Sat")||day.getDateOnly().equalsIgnoreCase("Sun")) ? true: false; 
		 
	}
	/**
	 * Checks if the time is in between
	 * 21:00:00 and 5:59:59 (9 am - 6 pm)
	 * @return boolean
	 */
	public boolean isAfter9pm() {
		Day day = new Day();		
		if(day.getHour()>=21 && (day.getHour()<6)) {
			return true;
		}
		return false;
	}
}
