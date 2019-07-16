package call;

import java.util.Date;

import code.Day;

import java.sql.Time;

public abstract class Call extends Day{
//Class Invariant: Calls won't last more than 24 hours.

	private Day start;
	private Day end;
		
	public Call() {}
	
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

	public abstract double rate();
	
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

