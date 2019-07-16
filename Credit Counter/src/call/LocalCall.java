package call;

import code.Day;

public class LocalCall extends Call {
	/*	Rates
	 * MON-FRI 6AM-8:59PM = 0.50 Birr/min
	 * MON-FRI 9PM-5:59PM = 0.45
	 * SAT&SUN 6AM-8:59PM = 0.40
	 * SAT&SUN 9PM-5:59PM = 0.35
	 */
	private double rate;
	final private Day day = new Day();
	
	 public LocalCall() {
		 rate = rate();
	 }
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	@Override
	public double rate() {
		if(day.isWeekend() && day.isAfter9pm()) {
			 rate = 0.35;
		 }
		 else if(day.isWeekend() && !day.isAfter9pm()) {
			 rate = 0.40;
		 }
		 else if(!day.isWeekend() && day.isAfter9pm()) {
			 rate = 0.45;
		 }
		 else {
			 rate = 0.50;
		 }
		return rate;
	}
	
	
	
}
