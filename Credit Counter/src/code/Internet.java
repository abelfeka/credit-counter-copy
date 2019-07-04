package code;

import java.sql.Time;


public class Internet extends Day {

	private Time start;
	private Time end;
	
	public Internet() {}
	
	public Internet(Time start, Time end) {
		this.start = start;
		this.end = end;
	}

	public Time getStart() {
		return start;
	}

	public void setStart(Time start) {
		this.start = start;
	}
	
	public Time getEnd() {
		return end;
	}

	public void setEnd(Time end) {
		this.end = end;
	}
}
