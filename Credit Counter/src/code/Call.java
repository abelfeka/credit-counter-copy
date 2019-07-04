package code;

import java.util.Date;
import java.sql.Time;
import enums.CallType;

public abstract class Call extends Day{
//Class Invariant: Calls won't last more than 24 hours.
	/*	Rates
	 * MON-FRI 6AM-8:59PM = 
	 * MON-FRI 9PM-5:59PM =
	 * SAT&SUN 6AM-8:59PM =
	 * SAT&SUN 9PM-5:59PM =
	 */
	private Day start;
	private Day end;
		
	public Call() {	}
	
	public Call(Day start, Day end) {
		this.start = start;	this.end = end;
	}

	@SuppressWarnings("deprecation")
	public double totalCallDurationInMinutes() {
		double hours = end.getHour() - start.getHour();
		double minutes = (end.getMinute() - start.getMinute())+60*hours;
		double seconds = (end.getSecond() - end.getMinute())+60*minutes;
	
		double callTime = (hours*60)+(minutes)+(seconds/60);
		
		return callTime;
	}

	
	public Day getStart() {
		return start;
	}
	public Day getEnd() {
		return end;
	}
	public void setStart(Day start) {
		this.start = start;
	}
	public void setEnd(Day end) {
		this.end = end;
	}
	
	
	
	
	
}
